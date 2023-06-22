package dao.daoTpFinal.model.Contract;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "contract_versions", schema = "payroll")

public class ContractVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date postingDate;

    private Date endDate;

    private double salary;


    public ContractVersion(Date postingDate, Date endDate, double salary) {

        this.postingDate = postingDate;
        this.endDate = endDate;
        this.salary = salary;

    }

    public ContractVersion() {

    }

    public Long getId() {
        return id;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public double getSalary() {
        return salary;
    }


}
