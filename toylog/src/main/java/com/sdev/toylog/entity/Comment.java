package com.sdev.toylog.entity;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Entity
public class Comment extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String contents;

    @Column(columnDefinition = "BIT", length = 1, nullable = false)
    @ColumnDefault(value = "false")
    private boolean deleted;

    @ManyToOne
    private User author;

    @ManyToOne
    private Post post;

}
