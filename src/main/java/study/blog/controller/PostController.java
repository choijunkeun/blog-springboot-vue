package study.blog.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import study.blog.service.PostService;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
}
