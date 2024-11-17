package io.github.luochangcheng.ccclouduser.utils;

import io.github.luochangcheng.cccloudcommoncore.base.Constant;
import io.github.luochangcheng.cccloudcommoncore.base.IUserRequest;
import io.github.luochangcheng.cccloudstartermybatisplus.common.config.handler.FieldFillHandler;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@AutoConfigureBefore(FieldFillHandler.class)
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
