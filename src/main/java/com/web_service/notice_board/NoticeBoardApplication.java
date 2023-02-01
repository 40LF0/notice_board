package com.web_service.notice_board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
public class NoticeBoardApplication {

    public static void main(String[] args) {
        SpringApplication.run(NoticeBoardApplication.class, args);
    }

}
