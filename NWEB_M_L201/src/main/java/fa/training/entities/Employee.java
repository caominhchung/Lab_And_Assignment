package fa.training.entities;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Employee", schema = "dbo")
public class Employee {
    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "gender")
    private byte gender;
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",unique = true,nullable = false)
    private User user;

    public Employee(Integer employeeId, String employeeName, byte gender, Date dateOfBirth, Department department) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.department = department;
    }

    public Employee(String employeeName, byte gender, Date dateOfBirth) {
        this.employeeName = employeeName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public Employee() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public byte getGender() {
        return gender;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
