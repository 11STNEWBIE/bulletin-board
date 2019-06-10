package board.bulletin.toy.domain;

import board.bulletin.toy.domain.posts.Posts;
import board.bulletin.toy.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() {
        postsRepository.deleteAll();
    }

    @Test
    public void savePosts() {
        postsRepository.save(Posts.builder()
                                .title("테스트제목")
                                .content("테스트본문")
                                .writer("hello")
                                .build()
        );

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("테스트제목"));
        assertThat(posts.getContent(), is("테스트본문"));
        assertThat(posts.getWriter(), is("hello"));


    }
}
