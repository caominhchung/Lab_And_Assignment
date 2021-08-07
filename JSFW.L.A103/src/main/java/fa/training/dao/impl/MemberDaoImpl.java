package fa.training.dao.impl;

import fa.training.dao.MemberDao;
import fa.training.entities.Member;
import fa.training.util.Log4J;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MemberDaoImpl implements MemberDao {
    SessionFactory sessionFactory;

    public MemberDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean create(Member member) {
        boolean check = true;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(member);
            session.getTransaction().commit();
        } catch (Exception e) {
            check = false;
            Log4J.getLogger().error(e);
        }
        return check;
    }

    @Override
    public Member findMemberByUserNameAndPassword(Member member) {
        Member findMember;
        try (Session session = sessionFactory.openSession()) {
            findMember = session.createQuery("FROM Member U WHERE U.username = :userName AND U.password = :password", Member.class)
                    .setParameter("userName", member.getUsername())
                    .setParameter("password", member.getPassword())
                    .getSingleResult();
        } catch (Exception e) {
            Log4J.getLogger().error(e);
            findMember = null;
        }
        return findMember;
    }

    @Override
    public boolean isExistUsername(String username) {
        Member findMember;
        try (Session session = sessionFactory.openSession()) {
            findMember = session.createQuery("FROM Member U WHERE U.username = :username", Member.class)
                    .setParameter("username", username)
                    .getSingleResult();
        } catch (Exception e) {
            Log4J.getLogger().error("Username not existed");
            findMember = null;
        }
        return findMember != null;
    }

    @Override
    public boolean isExistEmail(String email) {
        Member findMember;
        try (Session session = sessionFactory.openSession()) {
            findMember = session.createQuery("FROM Member U WHERE U.email = :email", Member.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (Exception e) {
            Log4J.getLogger().error("Email not existed");
            findMember = null;
        }
        return findMember != null;
    }
}
