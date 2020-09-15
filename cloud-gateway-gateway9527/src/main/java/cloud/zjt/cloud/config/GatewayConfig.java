package cloud.zjt.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zjt
 * @date 2020-09-14
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("zjt_gateway_baidu_news_h2", item -> item.path("/guonei").uri("http://news.baidu.com/guonei"))
                .route("zjt-gateway-baidu-news-h3", item -> item.path("/guoji").uri("http://news.baidu.com/guoji"))
                .route("zjt-gateway-baidu-news-h4", item -> item.path("/mil").uri("http://news.baidu.com/mil"))
                .route("zjt-gateway-baidu-news-h5", item -> item.path("/finance").uri("http://news.baidu.com/finance"))
                .route("zjt-gateway-baidu-news-h6", item -> item.path("/ent").uri("http://news.baidu.com/ent"))
                .route("zjt-gateway-baidu-news-h7", item -> item.path("/sports").uri("http://news.baidu.com/sports"))
                .route("zjt-gateway-baidu-news-h8", item -> item.path("/internet").uri("http://news.baidu.com/internet"));
        return routes.build();
    }

}
