package com.newbie.bulletinboard.domain.repositories.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberStatus;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MEMBER_INFO")
@Data
@EqualsAndHashCode(of = {"memSeq", "memId"})
public class MemberVO {
    @Id
    @SequenceGenerator(name = "memberInfo_sequence",
                        sequenceName = "memberInfo_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberInfo_sequence")
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

    @Column(name = "PASSWORD")
    private String password;

}
