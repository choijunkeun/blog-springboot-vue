package study.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.blog.entity.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
}
