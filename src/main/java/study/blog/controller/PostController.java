package study.blog.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import study.blog.dto.PostDto;
import study.blog.entity.Post;
import study.blog.service.PostService;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;


    /**
     * 게시글 등록
     * */
    @PostMapping("/api/post")
    public PostDto.CreatePostResponse savePost(@RequestBody @Valid PostDto.CreatePostRequest request) {
        Post post = new Post(request.getTitle(), request.getContent(), request.getStatus());

        Long id = postService.createPost(post);

        return new PostDto.CreatePostResponse(id);
    }

    @PutMapping("/api/post/{id}")
    public PostDto.UpdatePostResponse updatePost(
            @PathVariable("id") Long id,
            @RequestBody @Valid PostDto.UpdatePostRequest request) {

        postService.update(id, request.getTitle(), request.getContent());
        Post findPost = postService.findOne(id);
        return new PostDto.UpdatePostResponse(findPost.getId(), findPost.getTitle(), findPost.getContent());
    }
}
