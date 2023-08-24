package study.blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import study.blog.entity.Post;
import study.blog.enums.ExistStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class PostDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PostResponse {
        private Long id;
        private String title;
        private String content;
        private ExistStatus status;

        private List<ReplyDto.ReplyResponse> replies;

        private String createdBy;
        private LocalDateTime lastModifiedDate;

        public PostResponse(Long id, String title, String content, ExistStatus status) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.status = status;
        }

        @Builder
        public PostResponse(Post post) {
            this.id = post.getId();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.status = post.getStatus();
            this.createdBy = post.getCreatedBy();
            this.lastModifiedDate = post.getLastModifiedDate();

            this.replies = post.getReplies()
                            .stream()
                            .map(ReplyDto.ReplyResponse::new)
                            .collect(Collectors.toList());
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreatePostResponse {
        private Long id;

        public CreatePostResponse(Long id) {
            this.id = id;
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class CreatePostRequest {
        @NotBlank(message = "title miss")
        private String title;
        @NotBlank(message = "content miss")
        private String content;
        private final ExistStatus status = ExistStatus.EXIST;
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdatePostResponse {
        private Long id;
        private String title;
        private String content;
        private ExistStatus status;

        @Builder
        public UpdatePostResponse(Long id, String title, String content, ExistStatus status) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.status = status;
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class UpdatePostRequest {
        @NotBlank(message = "title miss")
        private String title;
        @NotBlank(message = "content miss")
        private String content;

        private ExistStatus status;
    }
}
