package fa.training.servlet;

import fa.training.dao.DepartmentDao;
import fa.training.dao.EmployeeDao;
import fa.training.entities.Department;
import fa.training.entities.Employee;
import fa.training.utils.Log4J;
import org.hibernate.HibernateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list-employees")
public class ListEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private EmployeeDao employeeDao = new EmployeeDao();
    private DepartmentDao departmentDao = new DepartmentDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Employee> listOfEmployee = employeeDao.findAllEmployee();
            System.out.println(listOfEmployee.size());
            request.setAttribute("listOfEmployee", listOfEmployee);

            request.getRequestDispatcher("/views/list-employees.jsp").
                    forward(request, response);

        } catch (HibernateException e) {
            Log4J.getLogger().error(e.getMessage());
        }

    }
}
