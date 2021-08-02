package fa.training.dao;

import fa.training.entities.User;
import fa.training.utils.HibernateUtils;
import fa.training.utils.Log4J;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class UserDao {
    private SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    public boolean login(User user) {
        boolean check = false;
        try(Session session = sessionFactory.openSession()){
            User findUser = session.createQuery("FROM User U WHERE U.userName = :userName",User.class)
                    .setParameter("userName", user.getUserName())
                    .getSingleResult();
            if(findUser != null && user.getPassword().equals(findUser.getPassword())){
                check = true;
            }
        }catch(Exception exception){
            Log4J.getLogger().error(exception);
        }
        return check;
    }
}
