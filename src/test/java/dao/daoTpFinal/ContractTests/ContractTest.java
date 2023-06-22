package dao.daoTpFinal.ContractTests;

import dao.daoTpFinal.model.Contract.Contract;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class ContractTest {

    @Test
    public void createPartTimeContract(){
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date endingDate = calendar.getTime();

        Contract partTimeContract = new Contract("part-time", currentDate, endingDate, 5000.0);
        Assertions.assertEquals(currentDate, partTimeContract.getPostingDate());
        Assertions.assertEquals(endingDate, partTimeContract.getEndingDate());
        Assertions.assertEquals(1, partTimeContract.contractVersions.size());
        Assertions.assertEquals(5000.0, partTimeContract.getSalary());


    }

    @Test
    public void cantCreateInvalidVersionOfContractTest(){
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date endingDate = calendar.getTime();

        Contract partTimeContract = new Contract("part-time", currentDate,  endingDate,5000.0);
        Assertions.assertThrows(RuntimeException.class, () -> {
            partTimeContract.createContractVersion("part-time",  endingDate, currentDate,5000.0);
        }, "Invalid contract");
        Assertions.assertEquals(1, partTimeContract.contractVersions.size());
    }
    @Test
    public void createFullTimeContract(){
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date endingDate = calendar.getTime();

        Contract partTimeContract = new Contract("full-time", currentDate, endingDate, 5000.0);
        Assertions.assertEquals(currentDate, partTimeContract.getPostingDate());
        Assertions.assertEquals(endingDate, partTimeContract.getEndingDate());
        Assertions.assertEquals(1, partTimeContract.contractVersions.size());
        Assertions.assertEquals(5000.0, partTimeContract.getSalary());
    }
}
