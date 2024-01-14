package me.hyeonseong.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.hyeonseong.springbootdeveloper.domain.Article;
import me.hyeonseong.springbootdeveloper.dto.AddArticleRequest;
import me.hyeonseong.springbootdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public Article save(AddArticleRequest request) {
        return blogRepository.save(request.toEntity());
    }
}