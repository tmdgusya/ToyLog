package com.sdev.toylog.entity;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Post extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 255, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @Column(columnDefinition = "BIT", length = 1, nullable = false)
    @ColumnDefault(value = "false")
    private boolean deleted;

    @Column(name = "LIKE_COUNT")
    @ColumnDefault("0")
    private Long likeCounts;

    @ManyToOne
    private User author;

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private final List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
    private final List<Like> likes = new ArrayList<>();

}
