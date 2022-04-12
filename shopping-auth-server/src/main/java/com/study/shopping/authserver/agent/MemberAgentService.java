package com.study.shopping.authserver.agent;

import com.study.shopping.common.to.member.WBSocialUserTO;
import com.study.shopping.common.utils.R;
import com.study.shopping.common.vo.auth.WBSocialUserVO;
import com.study.shopping.authserver.feign.MemberFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberAgentService {

    @Autowired
    MemberFeignService memberFeignService;

    public R oauthLogin(WBSocialUserVO user) {
        WBSocialUserTO param = new WBSocialUserTO();
        param.setAccessToken(user.getAccess_token());
        param.setExpiresIn(user.getExpires_in());
        param.setRemindIn(user.getRemind_in());
        param.setIsRealName(user.getIsRealName());
        param.setUid(user.getUid());
        return memberFeignService.oauthLogin(param);
    }
}
