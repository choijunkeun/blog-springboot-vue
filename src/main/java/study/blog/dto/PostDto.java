package study.blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import study.blog.entity.Post;
import study.blog.enums.ExistStatus;


public class PostDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class PostResponse {
        private Long id;
        private String title;
        private String content;
        private ExistStatus status;

        public PostResponse(Long id, String title, String content, ExistStatus status) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.status = status;
        }

        public PostResponse(Post post) {
            this.id = post.getId();
            this.title = post.getTitle();
            this.content = post.getContent();
            this.status = post.getStatus();
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
