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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ArticleApiController.class)
public class ArticleApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleBusinessService businessService;

    @Test
    public void homeTest() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request).andReturn();

        assertEquals("This is home", result.getResponse().getContentAsString());
    }

    @Test
    public void retrieveAllArticlesTest_basic() throws Exception {
        Article expectedFirst = new Article("THIS IS TITLE","Hello, world");
        expectedFirst.setId(1);

        Article expectedSecond = new Article("Rainy day", "rain rain...");
        expectedSecond.setId(2);

        String expectedJson = "[" + fomattingToJson(expectedFirst) + "," + fomattingToJson(expectedSecond) + "]";

        when(businessService.retrieveAllArticles()).thenReturn(
                Arrays.asList(expectedFirst, expectedSecond)
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/articles")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    @Test
    public void addTest_basic() throws Exception {
        Article expected = new Article("test-title", "test-contents");
        expected.setId(0);
        String expectedJson = fomattingToJson(expected);

        when(businessService.addArticle(any(Article.class))).thenReturn(expected);

        RequestBuilder request = MockMvcRequestBuilders
                .post("/add")
                .param("id", "0")
                .param("title", "test-title")
                .param("contents", "test-contents");


        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

    private String fomattingToJson(Article article) {
        return String.format("" +
                "{\"id\":%d,\"title\":\"%s\",\"contents\":\"%s\",\"value\":%d}",
                article.getId(), article.getTitle(), article.getContents(), article.getValue()
        );

    }

}