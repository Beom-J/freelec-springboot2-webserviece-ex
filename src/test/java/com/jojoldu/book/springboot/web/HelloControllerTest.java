package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

// 테스트 진행 시 JUnit 내장 실행자 외에 다른 실행자 실행 (SpringRunner)
@RunWith(SpringRunner.class)
// Web 에 집중할 수 있는 어노테이션
// @Controller , @ControllerAdvice 등 사용 가능해짐
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // Bean 자동 주입
    @Autowired
    private MockMvc mvc; // web API 테스트 시 사용, HTTP get / post 등에 대한 테스트 가능

    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // /hello 주소로 get 요청
                .andExpect(status().isOk()) // 통신 결과 검증
                .andExpect(content().string(hello)); // 응답한 content 내용이 hello 가 맞는지 검증
    }

    @Test
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto") // /hello/dto 에 접속해서
                .param("name",name) // name 파라미터에 Name 을 넣고
                .param("amount", String.valueOf(amount))) // amount 파라미터에 amount 를 넣어서
                .andExpect(status().isOk()) // 응답 결과가 정상이면
                .andExpect(jsonPath("$.name", is(name))) // json 응답 값이 name 과 같은지 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}
