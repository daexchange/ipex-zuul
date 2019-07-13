package ai.turbochain.ipex.gate.zuul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.jdbc.core.JdbcTemplate;

//import com.ipex.gate.zuul.filters.CustomRouteLocator;


/**
 *  配置自定义的路由定位器
 *  临时不启用了
 * @author fly
 *
 */
//@Configuration
//public class CustomZuulConfig {
//
//    @Autowired
//    ZuulProperties zuulProperties;
//    @Autowired
//    ServerProperties server;
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    @Bean
//    public CustomRouteLocator routeLocator() {
//        CustomRouteLocator routeLocator = new CustomRouteLocator(this.server.getServletPrefix(), this.zuulProperties);
//        routeLocator.setJdbcTemplate(jdbcTemplate);
//        return routeLocator;
//    }
//
//}
