package com.feng.springcloud.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by PanRufeng on 2018/4/21.
 */
@RestController
public class DemoController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/")
    public String greeting() {
        discoveryClient.getInstances("producer-service").forEach(s->System.out.print(s.getUri()));
        System.out.println();
        discoveryClient.getServices().forEach(s->System.out.println(s));
        return "Greeting from Producer. <br/> <a href = '/hello?name=Producer'>Hello Producer</a>";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(@RequestParam("name") String name) {
        return "Hello " + name;
    }
}
