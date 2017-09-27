package com.deverzone.domain.support;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gavin on 2017. 8. 23..
 */
@Data
@Entity
@Table(name="COMMENT")
public class Comment {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "content",length = 1000,nullable = false)
    private String content;
    private Date register;

    @Column(name = "qna_id")
    private Long qnaId;
}
