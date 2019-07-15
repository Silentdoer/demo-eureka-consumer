package me.silentdoer.demoeurekaconsumer.api.consumer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/mock")
public class MockController {

    /**
     * 这个已经在Config里配置的LoadBalanced
     */
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        // 调用的时候不需要再指定服务的特定的ip，而且假设是集群的话又没有提供统一的入口，这里还需要自己设计负载均衡算法
        // 有了服务注册与发现中心，这里调用可以直接写服务名即可，然后@LoadBalanced的RestTemplate能够自动去负载均衡选择
        // 一个user-service的健康的具体服务实例来调用
        // 还有一个好处就是如果服务提供者换了ip那么服务消费者还得去改配置
        return restTemplate.getForObject("http://user-service/mock/a_service_api", String.class);
    }
}
