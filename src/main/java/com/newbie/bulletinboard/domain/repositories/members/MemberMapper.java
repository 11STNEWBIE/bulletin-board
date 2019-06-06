package com.newbie.bulletinboard.domain.repositories.members;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
    int memberNameUpdate(MemberVO memberDTO);

    int memberStatusUpdate(MemberVO memberDTO);
}
