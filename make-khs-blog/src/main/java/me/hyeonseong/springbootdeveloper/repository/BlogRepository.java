package me.hyeonseong.springbootdeveloper.repository;

import me.hyeonseong.springbootdeveloper.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}