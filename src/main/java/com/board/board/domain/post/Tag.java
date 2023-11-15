package com.board.board.domain.post;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Tag {
    @Id
    @GeneratedValue
    @Column(name = "tag_id")
    private Long id;
    private String name;
    @JoinColumn(name = "post_id")
    @ManyToOne(fetch = LAZY)
    private Post post;
}
