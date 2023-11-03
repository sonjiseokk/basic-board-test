package com.board.board.service.user;

import com.board.board.web.domain.image.Image;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserUpdateParam {
    private String email;
    private String username;
    private String password;
    private Image profileImage;

    @Builder
    public UserUpdateParam(final String email, final String username, final String password, final Image profileImage) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
    }
}
