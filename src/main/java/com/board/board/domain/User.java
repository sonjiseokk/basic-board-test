package com.board.board.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;

@Entity(name = "users")
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
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "image_id")
    private Image profileImage;
}
