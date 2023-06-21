package dao.daoTpFinal.model.Contract;

import dao.daoTpFinal.model.Employee.Employee;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contracts", schema = "payroll")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date endingDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "salary",nullable = false)
    private double salary;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
