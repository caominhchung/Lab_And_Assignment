package fa.training.service;

import fa.training.entities.Member;

public interface MemberService{
    boolean create(Member member);

    Member findMemberByUserNameAndPassword(Member member);

    boolean isExistUsername(String username);

    boolean isExistEmail(String email);
}
