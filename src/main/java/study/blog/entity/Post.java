package study.blog.entity;


import jakarta.persistence.*;
import lombok.*;
import study.blog.enums.ExistStatus;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "title", "content", "status"})
public class Post extends BaseEntity {    // 게시글 엔티티

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;       // 제목

    @Column(nullable = false)
    private String content;     // 내용

    @OneToMany(mappedBy = "post")
    private List<Comment> comments = new ArrayList<>(); // 댓글

    @Enumerated(value = EnumType.STRING)
    private ExistStatus status; // 게시글 상태 [EXIST, NOT_EXIST]

    @Builder
    public Post(String title, String content, ExistStatus status) {
        this.title = title;
        this.content = content;
        this.status = status;
    }
}
