package dao.daoTpFinal.model.Employee;

import jakarta.persistence.*;

@Entity
@Table(name = "part_time_employees", schema = "payroll")
public class PartTimeEmployee extends Employee {
    @Column(nullable = false)
    private double hourlyRate;

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return 0;
    }
}
