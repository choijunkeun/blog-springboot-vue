package study.blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import study.blog.entity.Post;
import study.blog.entity.Reply;
import study.blog.enums.ExistStatus;

import java.time.LocalDateTime;

public class ReplyDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ReplyRequest {
        private Long id;
        private String reply;
        private Post post;
        private ExistStatus status;

        @Builder
        public ReplyRequest(Long id, String reply, Post post, ExistStatus status) {
            this.id = id;
            this.reply = reply;
            this.post = post;
            this.status = status;
        }
    }

    @Getter
    public static class ReplyResponse {

        private Long id;
        private String reply;
//        private String replyWriter; // 나중에 추가
        private Long postId;
        private LocalDateTime lastModifiedDate;


        public ReplyResponse(Reply reply) {
            this.id = reply.getId();
            this.reply = reply.getReply();
//            this.replyWriter = reply.getReplyWriter(); // 나중에 추가
            this.postId = reply.getPost().getId();
            this.lastModifiedDate = reply.getLastModifiedDate();

        }
    }

}
