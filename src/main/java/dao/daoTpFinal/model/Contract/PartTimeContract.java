package dao.daoTpFinal.model.Contract;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "part_time_contracts", schema = "payroll")
public class PartTimeContract extends ContractVersion {
    public PartTimeContract(LocalDate postingDate, LocalDate endDate, double salary) {
        super(postingDate,endDate ,salary);
    }

    public PartTimeContract() {

    }
}
