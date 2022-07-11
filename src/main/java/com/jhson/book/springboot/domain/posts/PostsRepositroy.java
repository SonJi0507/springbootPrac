package com.jhson.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepositroy extends JpaRepository<Posts, Long> {

}
