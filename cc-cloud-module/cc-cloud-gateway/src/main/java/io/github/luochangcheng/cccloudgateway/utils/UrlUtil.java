package io.github.luochangcheng.cccloudgateway.utils;

import io.github.luochangcheng.cccloudstarterauth.common.enums.AuthClientType;
import lombok.experimental.UtilityClass;

import java.net.URI;

@UtilityClass
public class UrlUtil {

    public int matchAuth(URI uri) {
        String replaceFirst = uri.getPath().replaceFirst("[/][a-z,A-Z,-]{1,}[/]", "");
        if (replaceFirst.startsWith(AuthClientType.ADMIN.name().toLowerCase() + "/")) {
            return AuthClientType.ADMIN.getCode();
        }
        if (replaceFirst.startsWith(AuthClientType.BUS.name().toLowerCase() + "/")) {
            return AuthClientType.BUS.getCode();
        }
        if (replaceFirst.startsWith(AuthClientType.APPLET.name().toLowerCase() + "/")) {
            return AuthClientType.APPLET.getCode();
        }
        return 0;
    }

}
