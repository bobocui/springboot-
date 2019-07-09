package com.springboot.jap.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author ：cuibo
 * @date ：Created in 2019/5/27 23:00
 * @description：
 * @modified By：
 * @version: $
 */
@RestController
public class HelloController {
    private final Logger logger=Logger.getLogger(String.valueOf(getClass()));

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getInstances("hello-service").get(0);
        logger.info("/hello, host:" + instance.getHost()+ instance.getServiceId());
        return "Hellow Word";
    }
}
