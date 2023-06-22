package dao.daoTpFinal.model.Contract;

import dao.daoTpFinal.model.Employee.Employee;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Stack;

@Entity
@Table(name = "contracts", schema = "payroll")
@Inheritance(strategy = InheritanceType.JOINED)
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private LocalDate postingDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private LocalDate endingDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Stack<ContractVersion> contractVersions;
    @Transient
    private ContractVersionFactory contractVersionFactory;

    public Contract(String contractType, LocalDate postingDate, LocalDate endingDate, double salary) {
        this.postingDate=postingDate;
        this.endingDate = endingDate;
        this.contractVersions = new Stack<>();
        this.contractVersionFactory = new ContractVersionFactory();
        createContractVersion(contractType, postingDate, endingDate, salary);

    }

    public Contract() {

    }

    public Stack<ContractVersion> getContractVersions() {
        return contractVersions;
    }

    private boolean validatePreviousVersionPostingDate(LocalDate newPostingDate){
        return newPostingDate.isAfter(contractVersions.peek().getPostingDate());
    }




    public void createContractVersion(String contractType, LocalDate postingDate, LocalDate endingDate, double salary) {
        if (endingDate.isAfter(postingDate) && salary > 0) {
            if (contractVersions.isEmpty() || validatePreviousVersionPostingDate(postingDate)) {
                if (!contractVersions.isEmpty()) {
                    contractVersions.peek().setEndDate(postingDate);
                }
                contractVersions.push(contractVersionFactory.createAContractVersion(contractType, postingDate, endingDate, salary));
            } else {
                throw new IllegalArgumentException("Invalid contract");
            }
        } else {
            throw new IllegalArgumentException("Invalid contract");
        }
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public LocalDate getEndingDate(){return endingDate;}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEndingDate(LocalDate endingDate) {
        this.endingDate = endingDate;
    }

    public double getSalary() {
        return contractVersions.peek().getSalary();
    }

    public ContractVersion getLastVersion() {
        return contractVersions.peek();
    }
}
