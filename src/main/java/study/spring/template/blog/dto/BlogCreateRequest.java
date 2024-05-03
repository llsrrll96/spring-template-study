package study.spring.template.blog.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogCreateRequest {
    private String title;
    private String content;
}