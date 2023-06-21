package dao.daoTpFinal.model.Employee;

import dao.daoTpFinal.model.Contract.Contract;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employees", schema = "payroll")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactDetails;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List <Contract> contracts = new ArrayList<>();

    public void setName(String name){
        this.name = name;
    }

    public void setContactDetails(String contactDetails){
        this.contactDetails = contactDetails;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public double calculateSalary(){
        return 0;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setPayrolls(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
