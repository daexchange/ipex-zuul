package ai.turbochain.ipex.gate.filter;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * 处理跨域的filter
 * 
 * @author fly
 *
 */
public class CrossDomainFilter implements Filter {

	Logger logger = Logger.getLogger(CrossDomainFilter.class);
	
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    	//啥请求都允许跨域
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //如果是OPTIONS请求就return 往后执行会到业务代码中 他不带参数会产生异常
        if (request.getMethod().equals("OPTIONS")) {
            return;
        }
        //第二次就是POST请求 之前设置了跨域就能正常执行代码了
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

}
