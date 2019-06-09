package springbom.bulletinboard.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springbom.bulletinboard.business.ArticleBusinessService;
import springbom.bulletinboard.model.Article;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleController.class)
public class ArticleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleBusinessService businessService;

    @Test
    public void home() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals("This is home", result.getResponse().getContentAsString());
    }

    @Test
    public void retrieveAllArticles_basic() throws Exception {
        Article articleFirst = new Article("THIS IS TITLE","Hello, world");
        articleFirst.setId(1);

        Article articleSecond = new Article("Rainy day", "rain rain...");
        articleSecond.setId(2);

        when(businessService.retrieveAllArticles()).thenReturn(
                Arrays.asList(articleFirst, articleSecond)
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/articles")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("" +
                        "[{\"id\":1,\"title\":\"THIS IS TITLE\",\"contents\":\"Hello, world\",\"value\":0}," +
                        "{\"id\":2,\"title\":\"Rainy day\",\"contents\":\"rain rain...\",\"value\":0}]"))
                .andReturn();
    }
}