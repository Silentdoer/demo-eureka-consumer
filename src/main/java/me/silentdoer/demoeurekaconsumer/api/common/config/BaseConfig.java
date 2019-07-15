package me.silentdoer.demoeurekaconsumer.api.common.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BaseConfig {

    /**
     * 开启负载均衡，每一个消费者其实都是定期从eureka-server里获取可用服务列表更新到本地，然后对于key相同（spring.application.name)
     * 的服务通过这个LoadBalanced去调用的时候就会在本地里进行一个选择的负载均衡，比如可能是ip/循环等等方式
     *
     * 会定期更新本地服务缓存，调用服务时指定服务名即可（一个服务名可以有多个服务实例），然后这里会自动负载均衡选择一个服务实例
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
