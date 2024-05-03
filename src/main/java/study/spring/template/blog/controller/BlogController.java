package study.spring.template.blog.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import study.spring.template.blog.dto.BlogCreateRequest;
import study.spring.template.blog.service.BlogService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class BlogController {
    private final BlogService blogService;

    // blog 조회
    @GetMapping
    public ResponseEntity<?> getBlogs() {
        log.info("getBlogs");
        return ResponseEntity.ok(blogService.getBlogs());
    }

    // blog 상세조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getBlog(@PathVariable("id") Long id) {
        log.info("getBlog id: {}", id);
        return ResponseEntity.ok(blogService.getBlog(id));
    }


    // blog 생성
    @PostMapping()
    public ResponseEntity<String> createBlog(@RequestBody BlogCreateRequest request) {
        log.info("createBlog request: {}", request);
        blogService.create(request);
        return ResponseEntity.ok("created");
    }
}
