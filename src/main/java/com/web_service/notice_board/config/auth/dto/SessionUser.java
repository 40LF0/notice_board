package com.web_service.notice_board.config.auth.dto;

import com.web_service.notice_board.domain.user.User;
import lombok.Getter;
import org.hibernate.Session;

@Getter
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
