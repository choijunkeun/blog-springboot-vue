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
    private List<Reply> replies = new ArrayList<>(); // 댓글

    // 게시글 상태를 존재, 미존재 말고 게시, 숨김, 삭제로 바꿀 예정..
    @Enumerated(value = EnumType.STRING)
    private ExistStatus status; // 게시글 상태 [EXIST, NOT_EXIST]

    @Builder
    public Post(String title, String content, ExistStatus status) {
        this.title = title;
        this.content = content;
        this.status = status;
    }


    //======= 비즈니스로직 =======//
    /**
     * 게시물 수정
     * */
    public void editPost(String title, String content) {
        if(status == ExistStatus.NOT_EXIST) {
            throw new IllegalStateException("삭제 된 포스트는 수정이 불가능합니다.");
        }
        this.title = title;
        this.content = content;
    }

    /**
     * 게시물 숨김
     * */
    public void hidePost(ExistStatus status) {
        if(status != ExistStatus.HIDE) {
            this.status = ExistStatus.HIDE;
        } else {
            this.status = ExistStatus.EXIST;
        }
    }

    /**
     * 게시물 삭제(NOT_EXIST 상태변경)
     * */
    public void deletePost(ExistStatus status) {
        if(status == ExistStatus.NOT_EXIST) {
            throw new IllegalStateException("이미 삭제 된 포스트입니다.");
        }
        this.status = ExistStatus.NOT_EXIST;
    }
}
