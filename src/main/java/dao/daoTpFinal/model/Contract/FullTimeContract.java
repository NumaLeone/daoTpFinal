package dao.daoTpFinal.model.Contract;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "full_time_contracts", schema = "payroll")
public class FullTimeContract extends ContractVersion{
    public FullTimeContract(LocalDate postingDate, LocalDate endDate, double salary) {
        super(postingDate,endDate ,salary);
    }


    public FullTimeContract() {

    }

}
