package com.mall.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mall.goods")
public class GoodsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(GoodsServiceApplication.class, args);
    }
}