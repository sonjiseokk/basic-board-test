package com.board.board.domain.image;

import com.board.board.domain.BaseTimeEntity;
import com.board.board.domain.post.PostImage;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "image_id")
    private Long id;
    private String path;
    private String orginal_name;
    private String type;
    private Long size;
    @OneToMany(mappedBy = "image")
    private List<PostImage> postImages = new ArrayList<>();
    @Builder
    public Image(final String path, final String orginal_name, final String type, final Long size) {
        this.path = path;
        this.orginal_name = orginal_name;
        this.type = type;
        this.size = size;
    }
}
