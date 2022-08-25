package com.work.glkt.vod;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wzhao
 * @create 2022-08-11 12:30
 */
//启动类
@SpringBootApplication
//包扫描
@MapperScan("com.work.glkt.vod.mapper")
@ComponentScan(basePackages = "com.work")
@EnableDiscoveryClient
public class ServiceVodApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServiceVodApplication.class, args);
	}
}
