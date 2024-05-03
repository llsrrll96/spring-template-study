package study.spring.template.blog.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import study.spring.template.blog.dto.BlogCreateRequest;
import study.spring.template.blog.dto.BlogUpdateRequest;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(nullable = false, name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;


    @Builder
    public Blog(Long id, String title, String content, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }

    public static Blog of(BlogCreateRequest request) {
        return Blog.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }

    public void update(BlogUpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();
    }
}