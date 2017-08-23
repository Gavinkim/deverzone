package com.deverzone.model.support;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by gs on 2017. 8. 23..
 */
@Data
@Entity
@Table(name="QNA")
public class QnA {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title",length = 300,nullable = false)
    private String title;
    @Column(name = "content",length = 1000,nullable = false)
    private String content;
    private Date register;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "qna_id")
    private List<Comment> comments;
}
