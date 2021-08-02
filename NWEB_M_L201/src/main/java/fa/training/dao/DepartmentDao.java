package fa.training.dao;

import fa.training.entities.Department;
import fa.training.utils.HibernateUtils;
import fa.training.utils.Log4J;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDao {
    private SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public List<Department> findAllDepartment() {
        List<Department> departments = new ArrayList<Department>();
        try (Session session = sessionFactory.openSession()) {
            departments = session.createQuery("FROM Department", Department.class)
                    .list();
        }catch(HibernateException e){
            Log4J.getLogger().error(e);
        }
        return departments;
    }
    public Department findDepartmentById(Integer id){
        Department department = null;
        try(Session session = sessionFactory.openSession()){
            department = session.get(Department.class,id);
        }catch(HibernateException e){
            Log4J.getLogger().error(e);
        }
        return department;
    }
}
