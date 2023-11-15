package com.board.board.api.dto.user;

import com.board.board.domain.image.Image;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserUpdateRequestDto {
    private final String email;
    private final String username;
    private final String password;
    private final Image profileImage;
    @Builder
    public UserUpdateRequestDto(final String email, final String username, final String password, final Image profileImage) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
    }
}
