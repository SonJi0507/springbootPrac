package com.jhson.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor // 기본 생성자 자동추가
@Entity // 테이블과 링크될 클래스임을 나타내줌 , Entity 클래스에는 Setter 메소드를 만들지 않아야 한다.
// 따로 builder 클래스를 이용하여 어떤 필드값에 어떤 값을 채워야 하는지를 분명하게 해준다.
public class Posts {
    @Id //해당 테이블의 PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 생성규칙 GenerationType.IDENTITY옵션을 추가해야 auto_increment 적용
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable=false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
