package cloud.zjt.cloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author zjt
 * @date 2020-09-14
 */
@Slf4j
@Component
public class MyLogGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // 请求头 可以做权鉴
        HttpHeaders headers = exchange.getRequest().getHeaders();
        MultiValueMap<String, String> params = exchange.getRequest().getQueryParams();
        String userName = params.getFirst("userName");
        // 简单校验一下userName 为空不被接受请求
        if (StringUtils.isBlank(userName)) {
            log.info("用户名为空");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        log.info("---------进入全局过滤器------------");
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }

}
