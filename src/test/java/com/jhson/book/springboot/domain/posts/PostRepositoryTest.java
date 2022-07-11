package com.jhson.book.springboot.domain.posts;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

//@WebMvcTest(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostRepositoryTest {

    @Autowired
    PostsRepositroy postsRepositroy;

    @AfterEach // Junit에서 단위 테스트가 끝날 때 마다 수행되는 메소드를 지정, 보통은 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침법을 막기 위해 사용
    public void cleanup(){
        postsRepositroy.deleteAll();
    }

    @Test
    void 게시글저장_불러오기() {
        String title=  "테스트 게시글";
        String content = "테스트 본문";

        postsRepositroy.save(Posts.builder() // 테이블 posts에 insert/update 쿼리를 실행, id값이 있다면 update 업사면 insert
                .title(title)
                .content(content)
                .author("jojoldu@gmail.com")
                .build()
        );

        List<Posts> postsList = postsRepositroy.findAll(); //테이블 posts에 있는 모든 데이터를 조회해오는 메소드

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);

    }
}
