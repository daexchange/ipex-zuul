package ai.turbochain.ipex.gate.zuul.filter;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * 
 * @author fly
 *
 */
@Component
public class SessionAccessFilter extends ZuulFilter {

	public boolean shouldFilter() {
		// 是否执行该过滤器，此处为true，说明需要过滤  
		return true;
	}

	public Object run() {
		System.out.println("==================SessionAccessFilter==================");
//		RequestContext ctx = RequestContext.getCurrentContext();
//        HttpSession httpSession = ctx.getRequest().getSession();
//        HttpServletRequest request = ctx.getRequest();
//        final String requestUri = request.getRequestURI();
//        final String method = request.getMethod();
//        User user = getSessionUser(httpSession);
//        String username = null;
//        if(user!=null) {
//             username = user.getUsername();
//            // 设置头部校验信息
//            ctx.addZuulRequestHeader("Authorization",
//                    Base64Utils.encodeToString(user.getUsername().getBytes()));
//            // 查找合法链接
//        }
//        // 不进行拦截的地址
//        if (isStartWith(requestUri) || isContains(requestUri)|| isOAuth(requestUri))
//            return null;
//        List<PermissionInfo> permissionInfos = userService.getAllPermissionInfo();
//        // 判断资源是否启用权限约束
//        Collection<PermissionInfo> result = getPermissionInfos(requestUri, method, permissionInfos);
//        if(result.size()>0){
//            if(username!=null)
//                checkAllow(requestUri, method, ctx, username);
//        }
		
		return null;
	}

	/**
	 * pre：可以在请求被路由之前调用
		route：在路由请求时候被调用
		post：在route和error过滤器之后被调用
		error：处理请求时发生错误时被调用
	 */
	@Override
	public String filterType() {
		// 前置过滤器  
		return "pre";
	}

	@Override
	public int filterOrder() {
		// 优先级为0，数字越大，优先级越低  
		return 0;
	}

}
