package com.newbie.bulletinboard.domain.services.posts;

import com.newbie.bulletinboard.domain.dtos.posts.PostDTO;
import com.newbie.bulletinboard.domain.exceptions.PostNotFoundException;
import com.newbie.bulletinboard.domain.repositories.posts.PostDAO;
import com.newbie.bulletinboard.domain.repositories.posts.PostVO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;
    private final ModelMapper modelMapper;

    @Override
    public PostDTO insertPost(PostDTO postDTO) {
        PostVO postVO = modelMapper.map(postDTO, PostVO.class);
        return modelMapper.map(postDAO.insertPost(postVO), PostDTO.class);
    }

    @Override
    public PostDTO getPost(PostDTO postDTO) throws PostNotFoundException {
        PostVO postInformation = postDAO.getPostInformation(modelMapper.map(postDTO, PostVO.class))
                .orElseThrow(() -> new PostNotFoundException(postDTO.getPostId()));

        return modelMapper.map(postInformation, PostDTO.class);
    }

    @Override
    public PostDTO updatePostContent(PostDTO postDTO) throws PostNotFoundException {
        PostVO map = modelMapper.map(postDTO, PostVO.class);

        PostVO postInformation = postDAO.getPostInformation(map).orElseThrow(() -> new PostNotFoundException(postDTO.getPostId()));

        postInformation.setUpdateDate(new Date());
        postInformation.setUpdateId(map.getUpdateId());

        PostVO postVO = postDAO.updatePost(postInformation);
        return modelMapper.map(postVO, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostList(int page, int size) {
        return postDAO.getPostList(page, size)
                .stream()
                .map(postVO -> modelMapper.map(postVO, PostDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO deletePosts(PostDTO postDTO) throws PostNotFoundException {
        var postVO = modelMapper.map(postDTO, PostVO.class);
        postVO = postDAO.getPostInformation(postVO)
                .orElseThrow(() -> new PostNotFoundException(postDTO.getPostId()));

        postDAO.deletePost(postVO);
        return modelMapper.map(postVO, PostDTO.class);
    }
}
