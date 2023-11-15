package com.board.board.domain.notification;

import com.board.board.domain.comment.Comment;
import com.board.board.domain.post.Post;
import com.board.board.domain.post.Tag;
import com.board.board.domain.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification {
    @Id
    @GeneratedValue
    @Column(name = "notification_id")
    private Long id;
    private NotificationType type;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = LAZY)
    private User receiveUser;
    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = LAZY)
    private User sendUser;

    @JoinColumn(name = "post_id")
    @ManyToOne(fetch = LAZY)
    private Post post;
    @JoinColumn(name = "comment_id")
    @ManyToOne(fetch = LAZY)
    private Comment comment;
    @JoinColumn(name = "tag_id")
    @ManyToOne(fetch = LAZY)
    private Tag tag;

}
