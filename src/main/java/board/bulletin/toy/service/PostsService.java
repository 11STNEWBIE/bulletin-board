package board.bulletin.toy.service;

import board.bulletin.toy.controller.dto.PostsSaveRequestDto;
import board.bulletin.toy.domain.posts.Posts;
import board.bulletin.toy.domain.posts.PostsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    public List<Posts> getPosts() {
        return postsRepository.findAll();
    }

    @Transactional
    public Long save(PostsSaveRequestDto dto) {
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public void update(Long id, PostsSaveRequestDto dto) {
        Posts posts = postsRepository.getOne(id);
        if (posts == null) return;

        posts.setTitle(dto.getTitle());
        posts.setContent(dto.getContent());
        posts.setWriter(dto.getWriter());
        postsRepository.save(posts);
    }

    @Transactional
    public void delete(Long id) {
        postsRepository.deleteById(id);
    }
}
