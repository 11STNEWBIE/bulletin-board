package com.newbie.bulletinboard.domain.repositories.members;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberDAOTest {

    @Autowired
    MemberDAO memberDAO;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getMemberInformation() {
    }

    @Test
    public void insertMember() {
    }

    @Test
    public void updateMember() {
    }
}