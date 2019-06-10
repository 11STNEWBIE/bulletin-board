package pal.study.board.domain;

import org.junit.Before;

public class UserUnitTest {

    private User user;

    @Before
    public void setUp() {
        user = new User(1L, "test", "12345", "hyukjin", "gogokow27@gmail.com", "010-8545-6158");
    }


}
