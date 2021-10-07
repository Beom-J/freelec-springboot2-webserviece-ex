package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing // JPA Auditing 활성화
// 여기서부터 스프링 설정을 읽기 시작
// 스프링부트 자동 설정, Bean 생성 & 읽기 자동 설정
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        // 내장 WAS 실행
        SpringApplication.run(Application.class, args);
    }
}
