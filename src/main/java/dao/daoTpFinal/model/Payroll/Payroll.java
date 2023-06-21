package dao.daoTpFinal.model.Payroll;

import dao.daoTpFinal.model.Employee.Employee;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payrolls", schema = "payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date effectiveDate;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date processingDate;

    @Column(nullable = false)
    private String period;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "salary",nullable = false)
    private double salary;

    public Payroll(Date effectiveDate, Date processingDate, String period, Employee employee, double salary) {
        this.effectiveDate = effectiveDate;
        this.processingDate = processingDate;
        this.period = period;
        this.employee = employee;
        this.salary = salary;
    }

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

    public Date getProcessingDate() {
        return processingDate;
    }

    public void setProcessingDate(Date processingDate) {
        this.processingDate = processingDate;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
