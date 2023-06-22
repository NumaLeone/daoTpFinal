package dao.daoTpFinal.model.Contract;

import jakarta.persistence.Entity;

import java.util.Date;

public class ContractVersionFactory {

    public ContractVersion createAContractVersion(String contractVersionType, Date startDate, Date endDate, double salary) {
        return createContract(contractVersionType, startDate, salary, endDate);
    }


    private ContractVersion createContract(String contractVersionType, Date startDate, double salary, Date endDate) {
        ContractVersion newContractVersion = null;
        if (contractVersionType.toLowerCase().equals("full-time")) {
            newContractVersion = new FullTimeContract(startDate, endDate, salary);
        } else if (contractVersionType.toLowerCase().equals("part-time")) {
            newContractVersion = new PartTimeContract(startDate, endDate, salary);
        }
        return newContractVersion;
    }
}