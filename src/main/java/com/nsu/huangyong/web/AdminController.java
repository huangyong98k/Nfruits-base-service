package com.nsu.huangyong.web;

import com.nsu.huangyong.common.constant.SysInfo;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestController
@Api(value = "API-base-service",description = "服务根响应")
public class AdminController {
    /**
     * 当前服务的根响应
     * @return 服务名称和版本
     */
    @RequestMapping("/")
    public Object info() {
        Map<String, String> infoMap = new LinkedHashMap<>();
        infoMap.put("name", SysInfo.NAME.getValue());
        infoMap.put("desc", "水果商城（huangyong.nsu@qq.com）");
        infoMap.put("version", SysInfo.VERSION.getValue());
        return infoMap;
    }
    @RequestMapping("/home")
    public void home(HttpServletRequest request, HttpServletResponse response) throws Exception{
        response.sendRedirect("/shop/tpl/index.html");
    }
}
