package com.web_service.notice_board.config.auth.dto;

import com.web_service.notice_board.domain.user._User;
import lombok.Getter;
import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(_User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}