package com.newbie.bulletinboard.domain.repositories.posts;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostDTO, Long> {
}
