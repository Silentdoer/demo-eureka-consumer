package me.silentdoer.demoeurekaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DemoEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoEurekaConsumerApplication.class, args);
    }

}
