package com.bbibm.time;

import com.rjkj.cf.common.security.annotation.EnableRjkjFeignClients;
import com.rjkj.cf.common.security.annotation.EnableRjkjResourceServer;
import com.rjkj.cf.common.swgger.annotation.EnableRJSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableRJSwagger2
@EnableRjkjFeignClients
@EnableRjkjResourceServer
@SpringCloudApplication
@EnableAsync
public class TimeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimeApplication.class,args);
    }
}
