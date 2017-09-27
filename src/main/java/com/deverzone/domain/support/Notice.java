package com.deverzone.domain.support;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by gavin on 2017. 8. 23..
 */
@Data
@Entity
@Table(name="NOTICE")
public class Notice {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title",length = 300,nullable = false)
    private String title;
    @Column(name = "content",length = 1000,nullable = false)
    private String content;
    private Date register;
}
