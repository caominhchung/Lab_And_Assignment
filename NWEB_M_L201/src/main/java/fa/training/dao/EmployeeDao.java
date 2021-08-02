package fa.training.dao;

import fa.training.entities.Employee;
import fa.training.entities.User;
import fa.training.utils.HibernateUtils;
import fa.training.utils.Log4J;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private static SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

    public void addEmployee(Employee employee) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = new User((employee.getEmployeeName()+employee.getDateOfBirth().getDay()),employee.getEmployeeName());
            employee.setUser(user);
            session.save(employee);
            session.getTransaction().commit();
        }catch(HibernateException e){
            Log4J.getLogger().error(e);
        }
    }

    public List<Employee> findAllEmployee() {
        List<Employee> employees = null;
        try (Session session = sessionFactory.openSession()) {
            employees = session.createQuery("SELECT NEW Employee(employeeId,employeeName,gender,dateOfBirth,department) FROM Employee", Employee.class)
                    .list();
        }catch(HibernateException e){
            Log4J.getLogger().error(e);
        }
        return employees;
    }
}
