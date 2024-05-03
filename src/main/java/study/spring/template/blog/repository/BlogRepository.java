package study.spring.template.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.spring.template.blog.domain.entity.Blog;

public interface BlogRepository extends JpaRepository<Blog,Long> {
}
