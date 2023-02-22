package com.web_service.notice_board.web;

import org.junit.jupiter.api.Test;
import org.springframework.mock.env.MockEnvironment;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProfileControllerUnitTest {
    @Test
    public void real_profile_access(){
        //given
        String expectedProfile = "real";
        MockEnvironment env = new MockEnvironment();
        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("oauth");
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);

        //when
        String profile = controller.profile();
        //then
        assertThat(profile).isEqualTo(expectedProfile);

    }
    @Test
    public void real_profile_not_exist_then_first_element_access(){
        //given
        String expectedProfile = "oauth";
        MockEnvironment env = new MockEnvironment();

        env.addActiveProfile(expectedProfile);
        env.addActiveProfile("real-db");

        ProfileController controller = new ProfileController(env);
        //when
        String profile = controller.profile();
        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }

    @Test
    public void active_profile_not_exist_then_default_access(){
        //given
        String expectedProfile = "default";
        MockEnvironment env = new MockEnvironment();

        ProfileController controller = new ProfileController(env);
        //when
        String profile = controller.profile();
        //then
        assertThat(profile).isEqualTo(expectedProfile);
    }

}
