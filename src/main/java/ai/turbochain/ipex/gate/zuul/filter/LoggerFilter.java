package ai.turbochain.ipex.gate.zuul.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 处理通过zuul转发的filter日志
 * @author fly
 *
 */
@Component
public class LoggerFilter extends ZuulFilter {

	public final static Logger logger = LoggerFactory.getLogger(LoggerFilter.class);

	@Override
	public String filterType() {
		return FilterConstants.POST_TYPE;
	}

	@Override
	public int filterOrder() {
		return FilterConstants.SEND_RESPONSE_FILTER_ORDER - 1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		// 请求的类型，post get ..
		String method = request.getMethod();
		// Map<String, String> params = request.getParameterMap();
		// String paramsStr = params.toString();//请求的参数
		long statrtTime = (long) context.get("startTime");// 请求的开始时间
		Throwable throwable = context.getThrowable();// 请求的异常，如果有的话
		if(throwable != null) {
			String msg = throwable.getMessage();
		}
		// 请求的uri
		String requestURI = request.getRequestURI();
		// 请求的iP地址
		request.getRemoteAddr();
		context.getResponseStatusCode();// 请求的状态
		long duration = System.currentTimeMillis() - statrtTime;// 请求耗时

		logger.info(request.getRemoteAddr() + " 访问了 " + requestURI + ", 总用时 " + duration + " 毫秒。");

		return null;
	}

}