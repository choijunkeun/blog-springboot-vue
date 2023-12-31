package study.blog.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.blog.enums.ExistStatus;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Reply extends BaseTimeEntity {  // 댓글

    @Id @GeneratedValue
    @Column(name = "reply_id")
    private Long id;

    @Column(nullable = false)
    private String replyWriter;  // 댓글 작성자

    @Column(nullable = false)
    private String reply; // 댓글 내용

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Enumerated(value = EnumType.STRING)
    private ExistStatus status; // 댓글 상태 [EXIST, NOT_EXIST]

    /* 연관관계 편의메서드 정의 */
    public void setPost(Post post) {
        this.post = post;
        post.getReplies().add(this);
    }

    /* 댓글 생성, 댓글 삭제 */


}
