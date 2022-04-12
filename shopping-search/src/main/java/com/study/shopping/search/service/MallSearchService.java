package com.study.shopping.search.service;

import com.study.shopping.common.vo.search.SearchParam;
import com.study.shopping.common.vo.search.SearchResult;

/**
 * 商城检索
 */
public interface MallSearchService {

    /**
     * 检索商品
     */
    SearchResult search(SearchParam param);
}