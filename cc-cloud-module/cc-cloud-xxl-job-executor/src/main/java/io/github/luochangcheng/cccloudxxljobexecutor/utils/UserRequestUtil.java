package io.github.luochangcheng.cccloudxxljobexecutor.utils;

import io.github.luochangcheng.cccloudcommoncore.base.Constant;
import io.github.luochangcheng.cccloudcommoncore.base.IUserRequest;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UserRequestUtil implements IUserRequest {

    @Override
    public String getUserId() {
        return Constant.DEFAULT_USER_ID;
    }

    @Override
    public Locale getLanguage() {
        return Constant.DEFAULT_LOCALE;
    }

}
