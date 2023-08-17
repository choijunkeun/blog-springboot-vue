package study.blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.blog.entity.Comment;
import study.blog.enums.ExistStatus;

import java.util.List;

public class PostDto {

    @Getter
    @NoArgsConstructor
    public static class CreatePostResponse {
        private Long id;

        public CreatePostResponse(Long id) {
            this.id = id;
        }
    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CreatePostRequest {
        @NotBlank(message = "title miss")
        private String title;
        @NotBlank(message = "content miss")
        private String content;
        private final ExistStatus status = ExistStatus.EXIST;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdatePostResponse {
        private Long id;
        private String title;
        private String content;
    }

    @Getter
    @NoArgsConstructor
    public static class UpdatePostRequest {
        @NotBlank(message = "title miss")
        private String title;
        @NotBlank(message = "content miss")
        private String content;
    }
}
