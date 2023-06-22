package dao.daoTpFinal.model.Contract;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "full_time_contracts", schema = "payroll")
public class FullTimeContract extends ContractVersion{
    public FullTimeContract( Date postingDate, Date endDate, double salary) {
        super(postingDate,endDate ,salary);
    }


    public FullTimeContract() {

    }

}
