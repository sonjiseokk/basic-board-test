package com.board.board.domain.post;

import com.board.board.domain.BaseTimeEntity;
import com.board.board.domain.comment.Comment;
import com.board.board.domain.user.User;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.*;
import static jakarta.persistence.GenerationType.*;

@Entity
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_id")
    private Long id;
    private String title;
    private String content;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "post")
    private List<PostImage> postImages = new ArrayList<>();
    @OneToMany(mappedBy = "post", fetch = LAZY)
    private List<Comment> comments = new ArrayList<>();
}
