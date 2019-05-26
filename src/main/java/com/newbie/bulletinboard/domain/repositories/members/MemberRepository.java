package com.newbie.bulletinboard.domain.repositories.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberDTO, Long> {
}
