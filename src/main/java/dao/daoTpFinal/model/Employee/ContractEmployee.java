package dao.daoTpFinal.model.Employee;
import jakarta.persistence.*;

@Entity
@Table(name = "contract_employees", schema = "payroll")
public class ContractEmployee extends Employee {
    @Column(nullable = false)
    private double contractAmount;

    public void setContractAmount(double contractAmount) {
        this.contractAmount = contractAmount;
    }

    @Override
    public double calculateSalary() {
        return contractAmount;
    }

}
