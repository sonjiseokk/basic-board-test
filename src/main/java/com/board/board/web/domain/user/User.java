package com.board.board.web.domain.user;

import com.board.board.service.user.UserUpdateParam;
import com.board.board.web.domain.image.Image;
import com.board.board.web.domain.post.PostLike;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.LAZY;

@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private String email;
    private String username;
    private String password;
    @OneToMany(mappedBy = "user")
    private List<PostLike> likes = new ArrayList<>();
    @OneToOne(fetch = LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id")
    private Image profileImage;
    @Builder
    public User(final String email, final String username, final String password, final Image profileImage) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.profileImage = profileImage;
    }

    public Long getId() {
        return id;
    }

    public void update(final UserUpdateParam updateParam) {
        this.email = updateParam.getEmail();
        this.username = updateParam.getUsername();
        this.password = updateParam.getPassword();
        this.profileImage = updateParam.getProfileImage();
    }
}
