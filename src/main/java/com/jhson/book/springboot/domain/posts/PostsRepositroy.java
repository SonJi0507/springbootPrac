package com.jhson.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepositroy extends JpaRepository<Posts, Long> {
    
    //SpringDataJap에서 제공하지 않는 메소드는 아래처럼 쿼리 작성도 가능함
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
