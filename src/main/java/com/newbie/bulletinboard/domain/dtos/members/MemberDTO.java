package com.newbie.bulletinboard.domain.dtos.members;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "MEMBER_INFO")
@Data
public class MemberDTO {

    @Id
    @GeneratedValue
    @Column(name = "MEM_SEQ")
    private Long memSeq;

    @Column(name = "MEM_ID", unique = true)
    private String memId;

    @Column(name = "MEM_NAME")
    private String memName;

    @Column(name = "CREATE_DT")
    @Temporal(TemporalType.DATE)
    private Date createDate;

    @Column(name = "MEM_STATUS")
    @Enumerated(EnumType.ORDINAL)
    private MemberStatus memberStatus = MemberStatus.UNAUTHORIZED;

    @Column(name = "UPDATE_DT")
    private Date updateDate;

    @OneToMany(mappedBy = "createId")
    private List<PostDTO> createdPosts = new ArrayList<>();

    @OneToMany(mappedBy = "updateId")
    private List<PostDTO> updatePosts = new ArrayList<>();

}
