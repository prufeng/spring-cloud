package com.feng.springcloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by PanRufeng on 2018/4/21.
 */
@RestController
public class DemoController {

    @Autowired
    DiscoveryClient discoveryClient;

    @Autowired
    DemoFeign demoFeign;

    @GetMapping("/")
    public String greeting() {
        discoveryClient.getInstances("producer-service").forEach(s->System.out.print(s.getUri()));
        System.out.println();
        discoveryClient.getServices().forEach(s->System.out.println(s));
        return "Greeting from Consumer. <br/> <a href = '/hello/Producer'>Hello Producer</a>";
    }

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name){
        return demoFeign.hello(name);
    }
}
