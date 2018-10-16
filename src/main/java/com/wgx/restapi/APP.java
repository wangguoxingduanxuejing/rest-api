package com.wgx.restapi;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wgx.restapi.dao")
public class APP {

	public static void main(String[] args) {
		SpringApplication.run(APP.class, args);
	}
}
