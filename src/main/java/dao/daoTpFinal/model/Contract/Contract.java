package dao.daoTpFinal.model.Contract;

import dao.daoTpFinal.model.Employee.Employee;
import jakarta.persistence.*;

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
    private Date postingDate;

    @Column()
    @Temporal(TemporalType.DATE)
    private Date endingDate;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    public Stack<ContractVersion> contractVersions;
    @Transient
    private ContractVersionFactory contractVersionFactory;

    public Contract(String contractType, Date postingDate, Date endingDate, double salary) {
        this.postingDate=postingDate;
        this.endingDate = endingDate;
        this.contractVersions = new Stack<>();
        this.contractVersionFactory = new ContractVersionFactory();
        createContractVersion(contractType, postingDate, endingDate, salary);

    }

    public Contract() {

    }

    private boolean validatePreviousVersionPostingDate(Date newPostingDate){
        return newPostingDate.after(contractVersions.peek().getPostingDate());
    }


    public void createContractVersion(String contractType, Date postingDate, Date endingDate, double salary){
        if(endingDate.after(postingDate)&& salary>0){
            if(contractVersions.size()>0){
                if(validatePreviousVersionPostingDate(postingDate)){
                    contractVersions.push(contractVersionFactory.createAContractVersion(contractType, postingDate, endingDate, salary));
                }
                else throw new RuntimeException("Invalid contract");
            }
            contractVersions.push(contractVersionFactory.createAContractVersion(contractType, postingDate, endingDate, salary));
        }


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getPostingDate() {
        return postingDate;
    }

    public Date getEndingDate(){return endingDate;}

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public double getSalary() {
        return contractVersions.peek().getSalary();
    }
}
