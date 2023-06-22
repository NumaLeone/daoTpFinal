package dao.daoTpFinal.model.Employee;

import dao.daoTpFinal.model.Contract.Contract;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

@Entity
@Table(name = "employees", schema = "payroll")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee {
    public Employee(String name, String contactDetails) {
        this.name = name;
        this.contactDetails = contactDetails;
        this.contracts = new Stack<>();
    }
    public Employee() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactDetails;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private Stack<Contract> contracts;

    public void setName(String name){
        this.name = name;
    }

    public void addContract(Contract contract){
        this.contracts.push(contract);
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

    public Stack<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Stack<Contract> contracts) {
        this.contracts = contracts;
    }
}
