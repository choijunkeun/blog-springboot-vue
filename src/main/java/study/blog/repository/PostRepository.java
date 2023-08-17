package study.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.blog.entity.Post;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findByTitle(String title);
}
