package com.web_service.notice_board.web.dto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {
    @Test
    public void lombok_function_test(){
        //given
        String name = "test";
        int amount = 100;
        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);
        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);


    }
}
