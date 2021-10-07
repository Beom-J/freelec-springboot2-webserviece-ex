package com.jojoldu.book.springboot.web.dto;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트(){
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // 검증하고 싶은 대상을 인자로 받고, 받은 값이 name과 같은지 비교
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
