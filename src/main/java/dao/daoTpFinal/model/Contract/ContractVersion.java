package dao.daoTpFinal.model.Contract;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "contract_versions", schema = "payroll")

public class ContractVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate postingDate;

    private LocalDate endDate;

    private double salary;

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ContractVersion(LocalDate postingDate, LocalDate endDate, double salary) {

        this.postingDate = postingDate;
        this.endDate = endDate;
        this.salary = salary;

    }

    public ContractVersion() {

    }

    public Long getId() {
        return id;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getSalary() {
        return salary;
    }


}
