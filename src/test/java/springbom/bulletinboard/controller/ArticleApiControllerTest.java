package springbom.bulletinboard.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springbom.bulletinboard.business.ArticleBusinessService;
import springbom.bulletinboard.dto.ArticleSaveRequestDto;
import springbom.bulletinboard.model.Article;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ArticleApiController.class)
public class ArticleApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleBusinessService businessService;

    @Test
    public void 모든게시글읽기_기본() throws Exception {
        Article expectedFirst = new Article("THIS IS TITLE","Hello, world");
        expectedFirst.setId(1);

        Article expectedSecond = new Article("Rainy day", "rain rain...");
        expectedSecond.setId(2);

        String expectedJson = "[" + fomattingToJson(expectedFirst) + "," + fomattingToJson(expectedSecond) + "]";

        when(businessService.retrieveAllArticles()).thenReturn(
                Arrays.asList(expectedFirst, expectedSecond)
        );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/article/all")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json(expectedJson))
                .andReturn();
    }

//    @Test
//    public void 게시글추가_기본() throws Exception {
//        Article expected = ArticleSaveRequestDto.builder()
//                .title("test-title")
//                .contents("test-contents")
//                .build().toEntity();
//
//        String expectedJson = fomattingToJson(expected);
//
//        when(businessService.addArticle(any(ArticleSaveRequestDto.class))).thenReturn(expected.getId());
//
//        RequestBuilder request = MockMvcRequestBuilders
//                .post("/api/article/add")
//                .param("title", "test-title")
//                .param("contents", "test-contents");
//
//
//        MvcResult result = mockMvc.perform(request)
//                .andExpect(status().isOk())
//                .andExpect(content().json(expectedJson))
//                .andReturn();
//    }

    private String fomattingToJson(Article article) {
        return String.format("" +
                "{\"id\":%d,\"title\":\"%s\",\"contents\":\"%s\",\"value\":%d}",
                article.getId(), article.getTitle(), article.getContents(), article.getValue()
        );

    }

}