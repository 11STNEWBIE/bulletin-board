package pal.study.board.web;

import org.junit.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pal.study.board.domain.User;
import pal.study.board.support.AcceptanceTest;

import static org.assertj.core.api.Assertions.*;

public class ApiUserAcceptanceTest extends AcceptanceTest {

    @Test
    public void create() {
        //given
        User newUser = new User(1L, "test", "12345", "hyukjin", "gogokow27@gmail.com", "010-8545-6158");

        //when
        ResponseEntity<Void> response = template().postForEntity("/api/users", newUser, Void.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void update() {
        //given
        User modifiedUser = new User(1L, "hyukjin", "test", "변경된이름", "test@test.com", "010-0000-0000");

        //when
        ResponseEntity<Void> response = basicAuthTemplate(defaultUser()).exchange("/api/users/1", HttpMethod.PUT, createHttpEntity(modifiedUser), Void.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void delete() {
        //when
        ResponseEntity<Void> response = basicAuthTemplate(defaultUser()).exchange("/api/users/1", HttpMethod.DELETE, createHttpEntity(1L), Void.class);

        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
