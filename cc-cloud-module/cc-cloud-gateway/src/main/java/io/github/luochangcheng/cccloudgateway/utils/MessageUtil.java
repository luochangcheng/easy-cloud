package io.github.luochangcheng.cccloudgateway.utils;

import io.github.luochangcheng.cccloudgateway.common.GatewayConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageUtil {

    @Autowired
    private MessageSource messageSource;

    public String translate(String lang, String code) {
        return translate(lang, code, (Object) null);
    }

    public String translate(String lang, String code, Object... args) {
        return messageSource.getMessage(code, args, null, getLocale(lang));
    }

    private Locale getLocale(String lang) {
        if (lang == null) {
            return GatewayConstants.DEFAULT_LOCALE;
        }
        try {
            String[] split = lang.split("_");
            return new Locale(split[0], split[1]);
        } catch (Exception ex) {
            return GatewayConstants.DEFAULT_LOCALE;
        }
    }

}
