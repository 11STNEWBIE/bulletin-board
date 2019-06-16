package com.newbie.bulletinboard.domain.repositories.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostVO, Long> {
}
