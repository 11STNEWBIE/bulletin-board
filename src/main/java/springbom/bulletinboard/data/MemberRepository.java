package springbom.bulletinboard.data;

import org.springframework.data.jpa.repository.JpaRepository;
import springbom.bulletinboard.model.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberName(String memberName);
}