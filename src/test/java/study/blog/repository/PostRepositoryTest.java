package study.blog.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.blog.entity.Post;
import study.blog.enums.ExistStatus;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(false)
class PostRepositoryTest {
    @Autowired PostRepository postRepository;
    @PersistenceContext EntityManager em;

    @Test
    public void testCreatePost() {
        // given
        for(int i=1; i <= 100; i++) {
            Post post = new Post("게시글" + i, "내용입니다" + i, ExistStatus.EXIST);
            Post savedPost = postRepository.save(post);
        }

        // when
//        Post findPost = postRepository.findByTitle("게시글 제목1").get(0);

        // then
    }


}