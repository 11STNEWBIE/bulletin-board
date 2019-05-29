package com.newbie.bulletinboard.domain.repositories.members;

import com.newbie.bulletinboard.domain.dtos.members.MemberDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberDTO, Long> {
    Optional<MemberDTO> findByMemId(String memId);
}
