package com.board.board.domain;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.*;

@Entity
public class PostImage {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "post_image_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;
}
