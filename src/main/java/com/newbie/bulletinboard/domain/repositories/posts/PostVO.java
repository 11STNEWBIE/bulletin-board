package com.newbie.bulletinboard.domain.repositories.posts;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "POST")
@Data
public class PostVO {
    @Column(name = "POST_ID")
    @Id
    @SequenceGenerator(name = "postInfo_sequence",
            sequenceName = "postInfo_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "postInfo_sequence")
    private Long postId;

    @Column(name = "POST_CONTENT", columnDefinition = "text")
    private String postContent;

    @Column(name = "CREATE_DT")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "CREATE_SEQ")
    private Long createId;

    @Column(name = "UPDATE_SEQ")
    private Long updateId;

    @Temporal(TemporalType.DATE)
    @Column(name = "UPDATE_DT")
    private Date updateDate;
}
