package com.newbie.bulletinboard.domain.repositories.members;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberVO, Long> {
    Optional<MemberVO> findByMemId(String memId);
}
