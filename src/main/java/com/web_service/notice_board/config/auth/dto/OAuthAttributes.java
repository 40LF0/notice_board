package com.web_service.notice_board.config.auth.dto;

import com.web_service.notice_board.domain.user.Role;
import com.web_service.notice_board.domain.user._User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String email;
    private String picture;

    @Builder
    public OAuthAttributes
            (Map<String, Object> attributes,String nameAttributeKey,String name,String email,String picture){
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.email = email;
        this.picture = picture;

    }
    public static OAuthAttributes of(String registrationId
            ,String userNameAttributes,Map<String,Object> attributes){
        System.out.println("registerationId is "+ registrationId);
        if("naver".equals(registrationId)){
            return ofNaver("id", attributes);
        }
        if("kakao".equals(registrationId)){
            return ofKakao(userNameAttributes, attributes);
        }

        return ofGoogle(userNameAttributes, attributes);
    }

    public static OAuthAttributes ofGoogle(String userNameAttributes,Map<String,Object> attributes){
        return OAuthAttributes.builder()
                .name((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .picture((String) attributes.get("picture"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributes)
                .build();
    }

    public static OAuthAttributes ofKakao(String userNameAttributes,Map<String,Object> attributes){
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");


        System.out.println(kakaoProfile.get("nickname"));
        System.out.println(kakaoAccount.get("email"));
        System.out.println(kakaoProfile.get("profile_image_url"));
        return OAuthAttributes.builder()
                .name((String) kakaoProfile.get("nickname"))
                .email((String) kakaoAccount.get("email"))
                .picture((String) kakaoProfile.get("profile_image_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributes)
                .build();
    }

    private static OAuthAttributes ofNaver(String userNameAttributes,Map<String,Object> attributes){
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");



        System.out.println("ofNaver");
        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .picture((String) response.get("profile_image"))
                .attributes(response)
                .nameAttributeKey(userNameAttributes)
                .build();
    }




    public _User toEntity(){
        return _User.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
