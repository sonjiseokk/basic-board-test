package com.board.board.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.*;

@Entity
public class Image extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "image_id")
    private Long id;
    private String path;
    private String imageName;
    private String type;
    private Long size;
    @OneToMany(mappedBy = "image")
    private List<PostImage> postImages = new ArrayList<>();
}
