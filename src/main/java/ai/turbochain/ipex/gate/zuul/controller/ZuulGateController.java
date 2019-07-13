package ai.turbochain.ipex.gate.zuul.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.web.ZuulHandlerMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ai.turbochain.ipex.gate.zuul.service.RefreshRouteService;

/**
 * ZuulGateController
 * 系统存在ZuulController 重名不起作用
 * @author fly
 *
 */
@RestController
public class ZuulGateController {
	
	public static final String PATH_ROOT = "/";

    @RequestMapping(PATH_ROOT)
    public String welcome() {
        return "Welcome!";
    }

    @Autowired
    RefreshRouteService refreshRouteService;

    @RequestMapping("/refreshRoute")
    public String refreshRoute(){
        refreshRouteService.refreshRoute();
        return "refreshRoute";
    }

    @Autowired
    ZuulHandlerMapping zuulHandlerMapping;

    @RequestMapping("/watchNowRoute")
    public String watchNowRoute(){
        //可以用debug模式看里面具体是什么
        Map<String, Object> handlerMap = zuulHandlerMapping.getHandlerMap();
        for(String key : handlerMap.keySet()) {
        	System.out.println(key + " : " + handlerMap.get(key));
        }
        return "watchNowRoute";
    }


}
