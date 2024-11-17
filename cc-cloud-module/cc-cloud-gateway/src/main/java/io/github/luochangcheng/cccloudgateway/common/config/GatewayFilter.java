package io.github.luochangcheng.cccloudgateway.common.config;

import io.github.luochangcheng.cccloudgateway.common.GatewayConstants;
import io.github.luochangcheng.cccloudgateway.utils.MessageUtil;
import io.github.luochangcheng.cccloudgateway.utils.ResponseUtil;
import io.github.luochangcheng.cccloudgateway.utils.UrlUtil;
import io.github.luochangcheng.cccloudstarterauth.common.AuthConstants;
import io.github.luochangcheng.cccloudstarterauth.model.BaseUser;
import io.github.luochangcheng.cccloudstarterauth.utils.JwtTokenUtil;
import io.github.luochangcheng.cccloudstarterredis.utils.RedisUtil;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
public class GatewayFilter implements GlobalFilter, Ordered {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private RedisUtil<BaseUser> redisUtil;
    @Autowired
    private MessageUtil messageUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        ServerHttpRequest.Builder mutate = request.mutate();
        int match = UrlUtil.matchAuth(request.getURI());
        String lang = Optional.ofNullable(request.getHeaders().getFirst(GatewayConstants.LANG)).orElse(GatewayConstants.DEFAULT_LOCALE.toString());
        if (match > 0) {
            String token = request.getHeaders().getFirst(AuthConstants.TOKEN_HEADER_NAME);
            //校验token合法性
            if (token == null || !jwtTokenUtil.validToken(token)) {
                return ResponseUtil.authFail(exchange, lang, messageUtil);
            }
            //校验redis中是否有改用户以及是否是当前登录用户的token
            BaseUser baseUser = jwtTokenUtil.getUserInfoFromToken(token);
            String redisKey = String.format(AuthConstants.CACHE_NAME_LOGIN_FORMAT, baseUser.getUserId(), match);
            BaseUser redisUser = redisUtil.get(redisKey);
            if (redisUser == null || !token.equals(redisUser.getToken())) {
                return ResponseUtil.authFail(exchange, lang, messageUtil);
            }
        }
        //设置链路id
        addHeader(mutate, GatewayConstants.TRACER_ID, MDC.get(GatewayConstants.TRACER_ID));
        //设置语言
        addHeader(mutate, GatewayConstants.LANG, lang);
        return chain.filter(exchange);
    }

    private void addHeader(ServerHttpRequest.Builder mutate, String name, Object value) {
        if (value == null) {
            return;
        }
        String valueStr = value.toString();
        String valueEncode = URLEncoder.encode(valueStr, StandardCharsets.UTF_8);
        mutate.header(name, valueEncode);
    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE;
    }
}