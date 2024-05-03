package study.spring.template.blog.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlogUpdateRequest {
    private String title;
    private String content;
}