package com.jhson.book.springboot.service.posts;


import com.jhson.book.springboot.domain.posts.PostsRepositroy;
import com.jhson.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepositroy postsRepositroy;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepositroy.save(requestDto.toEntity()).getId();
    }
}
