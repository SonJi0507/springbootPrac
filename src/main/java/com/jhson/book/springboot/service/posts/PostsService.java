package com.jhson.book.springboot.service.posts;


import com.jhson.book.springboot.domain.posts.Posts;
import com.jhson.book.springboot.domain.posts.PostsRepositroy;
import com.jhson.book.springboot.web.dto.PostsListResponseDto;
import com.jhson.book.springboot.web.dto.PostsResponseDto;
import com.jhson.book.springboot.web.dto.PostsSaveRequestDto;
import com.jhson.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepositroy postsRepositroy;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepositroy.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepositroy.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id){
        Posts entity = postsRepositroy.findById(id).orElseThrow(() -> new
                IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepositroy.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id){
        Posts posts = postsRepositroy.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));
        postsRepositroy.delete(posts);
    }
}
