package fa.training.dao;

import fa.training.entities.Member;

public interface MemberDao {
    boolean create(Member member);

    Member findMemberByUserNameAndPassword(Member member);

    boolean isExistUsername(String username);

    boolean isExistEmail(String email);
}
