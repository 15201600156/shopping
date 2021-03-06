package com.study.shopping.product.service.impl;

import com.alibaba.fastjson.TypeReference;
import com.study.shopping.common.constant.ObjectConstant;
import com.study.shopping.common.entity.product.*;
import com.study.shopping.common.utils.PageUtils;
import com.study.shopping.common.utils.Query;
import com.study.shopping.common.utils.R;
import com.study.shopping.common.vo.product.*;
import com.study.shopping.product.agent.CouponAgentService;
import com.study.shopping.product.dao.SkuInfoDao;
import com.study.shopping.product.feign.SeckillFeignService;
import com.study.shopping.product.service.SkuImagesService;
import com.study.shopping.product.service.SkuInfoService;
import com.study.shopping.product.service.SkuSaleAttrValueService;
import com.study.shopping.product.service.SpuInfoDescService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.stream.Collectors;


@Service("skuInfoService")
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoDao, SkuInfoEntity> implements SkuInfoService {

    @Autowired
    SkuImagesService skuImagesService;
    @Autowired
    SkuSaleAttrValueService skuSaleAttrValueService;
    @Autowired
    CouponAgentService couponAgentService;
    @Autowired
    SpuInfoDescService spuInfoDescService;
    @Autowired
    AttrGroupServiceImpl attrGroupService;
    @Autowired
    SeckillFeignService seckillFeignService;
    @Autowired
    ThreadPoolExecutor executor;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                new QueryWrapper<SkuInfoEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPageByCondition(Map<String, Object> params) {
        QueryWrapper<SkuInfoEntity> queryWrapper = new QueryWrapper<>();

        String key = (String) params.get("key");
        if (!StringUtils.isEmpty(key)) {
            queryWrapper.and(qw -> {
                qw.eq("sku_id", key).or().like("sku_name", key);
            });
        }

        String catelogId = (String) params.get("catelogId");
        if (!StringUtils.isEmpty(catelogId) && !"0".equalsIgnoreCase(catelogId)) {
            queryWrapper.eq("catalog_Id", catelogId);
        }

        String brandId = (String) params.get("brandId");
        if (!StringUtils.isEmpty(brandId) && !"0".equalsIgnoreCase(brandId)) {
            queryWrapper.eq("brand_id", brandId);
        }

        // ????????????
        String min = (String) params.get("min");
        if (!StringUtils.isEmpty(min)) {
            queryWrapper.ge("price", min);
        }

        String max = (String) params.get("max");
        if (!StringUtils.isEmpty(max)) {
            try {
                BigDecimal bigDecimal = new BigDecimal(max);
                if (bigDecimal.compareTo(BigDecimal.ZERO) == 1) {
                    queryWrapper.le("price", max);
                }
            } catch (Exception e) {
            }

        }

        IPage<SkuInfoEntity> page = this.page(
                new Query<SkuInfoEntity>().getPage(params),
                queryWrapper
        );
        return new PageUtils(page);
    }

    /**
     * ??????sku
     */
    @Override
    public void saveSkuInfo(SpuInfoEntity spuInfo, List<Skus> skus) {
        // ????????????spu???????????????sku??????
        if (!CollectionUtils.isEmpty(skus)) {
            skus.forEach(sku -> {
                // ????????????sku????????????
                String defaultImg = null;
                for (Images img : sku.getImages()) {
                    if (ObjectConstant.BooleanIntEnum.YES.getCode().equals(img.getDefaultImg())) {
                        defaultImg = img.getImgUrl();
                        break;
                    }
                }
                //   1)sku??????????????????pms_sku_info
                SkuInfoEntity skuInfo = new SkuInfoEntity();
                BeanUtils.copyProperties(sku, skuInfo);
                skuInfo.setSpuId(spuInfo.getId());
                skuInfo.setCatalogId(spuInfo.getCatalogId());
                skuInfo.setBrandId(spuInfo.getBrandId());
                skuInfo.setSkuDefaultImg(defaultImg);
                skuInfo.setSaleCount(0L);
                this.baseMapper.insert(skuInfo);
                Long skuId = skuInfo.getSkuId();

                //   2)sku??????????????????pms_sku_images?????????????????????????????????
                List<SkuImagesEntity> skuImagesEntities = sku.getImages().stream().
                        filter(img -> !StringUtils.isEmpty(img.getImgUrl())).
                        map(img -> {
                            SkuImagesEntity skuImages = new SkuImagesEntity();
                            skuImages.setSkuId(skuId);
                            skuImages.setImgUrl(img.getImgUrl());
                            skuImages.setDefaultImg(img.getDefaultImg());
                            return skuImages;
                        }).collect(Collectors.toList());
                skuImagesService.saveBatch(skuImagesEntities);

                //   3)sku?????????????????????pms_sku_sale_attr_value
                List<SkuSaleAttrValueEntity> skuSaleAttrValueEntities = sku.getAttr().stream().map(attr -> {
                    SkuSaleAttrValueEntity skuSaleAttrValue = new SkuSaleAttrValueEntity();
                    BeanUtils.copyProperties(attr, skuSaleAttrValue);
                    skuSaleAttrValue.setSkuId(skuId);

                    return skuSaleAttrValue;
                }).collect(Collectors.toList());
                skuSaleAttrValueService.saveBatch(skuSaleAttrValueEntities);

                //   4)sku??????????????????????????????????????????????????????????????????????????????????????????
                //   sms_sku_ladder\sms_sku_full_reduction\sms_member_price
                R r = couponAgentService.saveSkuReduction(skuId, sku);
                if (r.getCode() != 0) {
                    log.error("????????????spu??????????????????");
                }
            });


        }
    }

    /**
     * ??????spuId???????????????sku??????
     */
    @Override
    public List<SkuInfoEntity> getSkusBySpuId(Long spuId) {
        return this.list(new QueryWrapper<SkuInfoEntity>().eq("spu_id", spuId));
    }

    /**
     * ??????skuId?????????????????????VO??????
     */
    @Override
    public SkuItemVO item(Long skuId) throws ExecutionException, InterruptedException {
        SkuItemVO result = new SkuItemVO();

        CompletableFuture<SkuInfoEntity> skuInfoFuture = CompletableFuture.supplyAsync(() -> {
            // 1.??????sku???????????????pms_sku_info???????????????????????????????????????????????????
            SkuInfoEntity skuInfo = getById(skuId);
            result.setInfo(skuInfo);
            return skuInfo;
        }, executor);

        CompletableFuture<Void> imagesFuture = CompletableFuture.runAsync(() -> {
            // 2.??????sku???????????????pms_sku_images???
            List<SkuImagesEntity> images = skuImagesService.getImagesBySkuId(skuId);
            result.setImages(images);
        }, executor);

        CompletableFuture<Void> seckillSkuFuture = CompletableFuture.runAsync(() -> {
            // 3.??????????????????????????????????????????
            R r = seckillFeignService.getSkuSeckilInfo(skuId);
            if (r.getCode() == 0) {
                SeckillSkuVO seckillSku = r.getData(new TypeReference<SeckillSkuVO>() {
                });
                result.setSeckillSku(seckillSku);
            }
        }, executor);

        CompletableFuture<Void> saleAttrFuture = skuInfoFuture.thenAcceptAsync((skuInfo) -> {
            // 4.????????????sku??????spu?????????????????????????????????pms_sku_info???pms_sku_sale_attr_value???
            List<SkuItemSaleAttrVO> saleAttr = skuSaleAttrValueService.getSaleAttrBySpuId(skuInfo.getSpuId());
            result.setSaleAttr(saleAttr);
        }, executor);

        CompletableFuture<Void> descFuture = skuInfoFuture.thenAcceptAsync((skuInfo) -> {
            // 5.??????spu???????????????pms_spu_info_desc?????????????????????
            SpuInfoDescEntity desc = spuInfoDescService.getById(skuInfo.getSpuId());
            result.setDesc(desc);
        }, executor);

        CompletableFuture<Void> groupAttrsFuture = skuInfoFuture.thenAcceptAsync((skuInfo) -> {
            // 6.??????spu?????????????????????pms_product_attr_value???pms_attr_attrgroup_relation???pms_attr_group???
            List<SpuItemAttrGroupVO> groupAttrs = attrGroupService.getAttrGroupWithAttrsBySpuId(skuInfo.getSpuId(), skuInfo.getCatalogId());
            result.setGroupAttrs(groupAttrs);
        }, executor);

        // ???????????????????????????
        CompletableFuture.allOf(imagesFuture, saleAttrFuture, descFuture, groupAttrsFuture, seckillSkuFuture).get();

        return result;
    }

    @Override
    public List<SkuInfoEntity> getByIds(Collection<Long> skuIds) {
        return this.baseMapper.selectBatchIds(skuIds);
    }
}