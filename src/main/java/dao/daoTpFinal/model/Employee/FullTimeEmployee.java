package dao.daoTpFinal.model.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "full_time_employees", schema = "payroll")
public class FullTimeEmployee extends Employee {
    @Column(nullable = false)
    private double salary;

    @Override
    public double calculateSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

}
