package springbom.bulletinboard.data;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import springbom.bulletinboard.model.Member;
import springbom.bulletinboard.model.MemberRole;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Test
    public void insertTest() {
        Member member = new Member();
        member.setMemberName("user111");
        member.setPassword("pw");

        MemberRole role = new MemberRole();
        role.setRoleName("USER");
        member.setRoles(Arrays.asList(role));

        repository.save(member);

        Optional<Member> result = repository.findByMemberName("user111");
        assertTrue(result.isPresent());
    }
}