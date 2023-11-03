package com.board.board.web.dto.user;

import com.board.board.web.domain.image.Image;
import com.board.board.web.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String email;
    private String username;
    private String password;
    private Image profileImage;
    @Builder
    public UserSaveRequestDto(final String email, final String username, final String password, final Image profileImage) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
    }
    public User toEntity(UserSaveRequestDto dto) {
        return User.builder()
                .email(dto.email)
                .username(dto.username)
                .password(dto.password)
                .profileImage(dto.profileImage)
                .build();
    }
}
