package study.spring.template.blog.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.spring.template.blog.dto.BlogCreateRequest;
import study.spring.template.blog.domain.entity.Blog;
import study.spring.template.blog.repository.BlogRepository;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    @Transactional(readOnly = true)
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Blog getBlog(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(RuntimeException::new);
    }

    public void create(BlogCreateRequest request) {
        blogRepository.save(Blog.of(request));
    }
}