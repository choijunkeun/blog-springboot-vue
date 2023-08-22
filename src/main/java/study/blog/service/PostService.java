package study.blog.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.blog.entity.Post;
import study.blog.enums.ExistStatus;
import study.blog.repository.PostRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    /**
     * 게시물 생성
     * */
    @Transactional
    public Long createPost(Post post) {
        postRepository.save(post);
        return post.getId();
    }

    /**
     * 게시물 수정
     * */
    @Transactional
    public void update(Long id, String title, String content) {
        Post post = postRepository.findById(id).get();
        post.editPost(title, content);
    }

    /**
     * 게시물 상태 변경(숨김처리)
     * */
    @Transactional
    public void updateStatus(Long id, ExistStatus status) {
        Post post = postRepository.findById(id).get();
        post.hidePost(status);
    }

    /**
     * 게시물 삭제
     * */
    @Transactional
    public void delete(Long id, ExistStatus status) {
        Post post = postRepository.findById(id).get();
        post.deletePost(status);
    }

    /**
     * 게시물 전체 조회
     * */
    public Page<Post> findAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    /**
     * 게시물 단건 조회
     * */
    public Post findOne(Long postId) {
        return postRepository.findById(postId).get();
    }
}
