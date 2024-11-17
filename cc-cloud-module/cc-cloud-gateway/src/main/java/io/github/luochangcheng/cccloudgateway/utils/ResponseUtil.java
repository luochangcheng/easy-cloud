package io.github.luochangcheng.cccloudgateway.utils;

import com.alibaba.fastjson2.JSON;
import lombok.experimental.UtilityClass;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class ResponseUtil {

    public Mono<Void> authFail(ServerWebExchange exchange, String lang, MessageUtil messageUtil) {
        Map<String, Object> body = new HashMap<>();
        int code = 1004;
        body.put("code", code);
        body.put("message", messageUtil.translate(lang, String.valueOf(code)));
        byte[] bytes = JSON.toJSONBytes(body);
        DataBuffer wrap = exchange.getResponse().bufferFactory().wrap(bytes);
        exchange.getResponse().setStatusCode(HttpStatus.OK);
        exchange.getResponse().getHeaders().add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        return exchange.getResponse().writeWith(Mono.just(wrap));
    }

}
