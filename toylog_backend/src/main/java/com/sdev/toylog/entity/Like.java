package com.sdev.toylog.entity;

import lombok.Getter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Entity(name = "LIKES")
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, columnDefinition = "BIT", length = 1)
    @ColumnDefault(value = "false")
    private boolean clicked;

    @ManyToOne
    User user;

    @ManyToOne
    Post post;

}
