package ai.turbochain.ipex.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import ai.turbochain.ipex.gate.filter.CrossDomainFilter;
import ai.turbochain.ipex.gate.filter.LogFilter;

@SpringBootApplication
@EnableFeignClients
@EnableZuulProxy
public class IpexZuul {

	public static void main(String[] args) {
		SpringApplication.run(IpexZuul.class, args);
	}
	
	@Bean(name = "LogFilter")
	public LogFilter getLogFilter(){
		return new LogFilter();
	}
	
	
	@Bean(name = "CrossDomainFilter")
	public CrossDomainFilter getCrossDomainFilter(){
		return new CrossDomainFilter();
	}
	
	/**
	 * 跨域处理Filter(最先执行此过滤器，避免跨域请求调用两次而执行后续的过滤器链)
	 * 
	 * @return
	 */
//	@Bean
//    @Order(Integer.MAX_VALUE)
//	public FilterRegistrationBean crossDomainFilterRegistration() {
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new CrossDomainFilter());
//		registration.addUrlPatterns("/*");
//		registration.setName("CrossDomainFilter");
//		return registration;
//	}

}
