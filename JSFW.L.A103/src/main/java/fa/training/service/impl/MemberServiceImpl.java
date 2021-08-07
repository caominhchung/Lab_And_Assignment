package fa.training.service.impl;

import fa.training.dao.MemberDao;
import fa.training.entities.Member;
import fa.training.service.MemberService;
import fa.training.util.Log4J;

public class MemberServiceImpl implements MemberService {
    private MemberDao memberDao;
    public MemberServiceImpl(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public boolean create(Member member) {
        boolean check;
        try{
            check = memberDao.create(member);
        }catch(Exception e){
            Log4J.getLogger().error(e);
            check = false;
        }
        return check;
    }

    @Override
    public Member findMemberByUserNameAndPassword(Member member) {
         return  memberDao.findMemberByUserNameAndPassword(member);
    }

    @Override
    public boolean isExistUsername(String username) {
        boolean check;
        try{
            check = memberDao.isExistUsername(username);
        }catch(Exception e){
            Log4J.getLogger().error(e);
            check = true;
        }
        return check;
    }

    @Override
    public boolean isExistEmail(String email) {
        boolean check;
        try{
            check = memberDao.isExistEmail(email);
        }catch(Exception e){
            Log4J.getLogger().error(e);
            check = true;
        }
        return check;

    }
}
