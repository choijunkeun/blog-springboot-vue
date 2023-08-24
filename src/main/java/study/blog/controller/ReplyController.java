package study.blog.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import study.blog.dto.PostDto;
import study.blog.dto.ReplyDto;
import study.blog.service.ReplyService;

@RestController
@RequiredArgsConstructor
public class ReplyController {

    private final ReplyService replyService;

    // 게시글에 댓글 등록
    @PostMapping("/api/reply")
    public ReplyDto.ReplyRequest saveReply(@RequestBody @Valid ReplyDto.ReplyRequest request) {


    }

    // 게시글의 댓글 삭제

}
