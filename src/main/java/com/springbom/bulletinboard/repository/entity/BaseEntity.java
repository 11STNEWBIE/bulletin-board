package com.springbom.bulletinboard.repository.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CREATE_DT")
    @Temporal(TemporalType.DATE)
    @CreatedDate
    private Date createDate;

    @Column(name = "UPDATE_DT")
    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    private Date updateDate;
}
