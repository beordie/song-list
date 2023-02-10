package com.beordie.eureka.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author yishun
 * @version 1.0
 * @date 2023/2/8 17:25
 * @describe TODO
 */
@RestController
@RequestMapping("/eureka/health")
public class HealthController {
    @RequestMapping(method = RequestMethod.GET)
    /**
     * 健康检查
     * @param request: 请求
     * @param response: 响应
     * @return : none
     */
    public void healthCheck(HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpStatus.OK.value());
    }
}
