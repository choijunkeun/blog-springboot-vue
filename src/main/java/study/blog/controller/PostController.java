package study.blog.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import study.blog.dto.PostDto;
import study.blog.entity.Post;
import study.blog.repository.PostRepository;
import study.blog.service.PostService;


@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    /**
     * 게시물 단건 조회(상세)
     * */
    @GetMapping("/api/posts/{id}")
    public PostDto.PostResponse findPost(@PathVariable("id") Long id) {
        Post post = postService.findOne(id);

        return new PostDto.PostResponse(post.getId(), post.getTitle(), post.getContent(), post.getStatus());
    }

    /**
     * 게시물 전체 조회(페이징)
     * */
    @GetMapping("/api/posts")
    public Page<PostDto.PostResponse> postList(@PageableDefault(size = 10)Pageable pageable) {
        return postService.findAll(pageable)
                .map(PostDto.PostResponse::new);
    }

    /**
     * 게시글 등록
     * */
    @PostMapping("/api/post")
    public PostDto.CreatePostResponse savePost(@RequestBody @Valid PostDto.CreatePostRequest request) {
        Post post = new Post(request.getTitle(), request.getContent(), request.getStatus());

        Long id = postService.createPost(post);

        return new PostDto.CreatePostResponse(id);
    }

    /**
     * 게시물 수정
     * */
    @PutMapping("/api/posts/{id}")
    public PostDto.UpdatePostResponse updatePost(
            @PathVariable("id") Long id,
            @RequestBody @Valid PostDto.UpdatePostRequest request) {

        postService.update(id, request.getTitle(), request.getContent());
        Post findPost = postService.findOne(id);

        return PostDto.UpdatePostResponse.builder()
                .title(findPost.getTitle())
                .content(findPost.getContent())
                .build();
    }

    /**
     * 게시글 상태 변경(숨김처리) 코드 수정중....
     * */
    @PatchMapping("/api/posts/{id}")
    public PostDto.UpdatePostResponse updatePostStatus(
            @PathVariable("id") Long id,
            @RequestBody @Valid PostDto.UpdatePostRequest request) {

        postService.updateStatus(id, request.getStatus());
        Post findPost = postService.findOne(id);

        return PostDto.UpdatePostResponse.builder()
                .title(findPost.getTitle())
                .content(findPost.getContent())
                .build();
    }

}
