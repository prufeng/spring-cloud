package com.feng.springcloud.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by PanRufeng on 2018/5/27.
 */
@FeignClient(name="producer-service")
public interface DemoFeign {
    @GetMapping(value = "/hello")
    public String hello(@RequestParam("name") String name);
}
