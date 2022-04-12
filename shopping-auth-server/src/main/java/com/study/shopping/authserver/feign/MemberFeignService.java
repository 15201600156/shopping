package com.study.shopping.authserver.feign;

import com.study.shopping.common.to.member.WBSocialUserTO;
import com.study.shopping.common.utils.R;
import com.study.shopping.common.vo.auth.UserLoginVO;
import com.study.shopping.common.vo.auth.UserRegisterVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 会员服务
 */
@FeignClient("shopping-member")
public interface MemberFeignService {

    /**
     * 注册
     */
    @PostMapping("/member/member/regist")
    R regist(@RequestBody UserRegisterVO user);

    /**
     * 登录
     */
    @PostMapping("/member/member/login")
    R login(@RequestBody UserLoginVO vo);

    /**
     * 微博社交登录
     */
    @PostMapping("/member/member/weibo/oauth2/login")
    public R oauthLogin(@RequestBody WBSocialUserTO user);


}