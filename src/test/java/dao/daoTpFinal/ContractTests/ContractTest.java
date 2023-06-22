package dao.daoTpFinal.ContractTests;

import dao.daoTpFinal.model.Contract.Contract;
import dao.daoTpFinal.model.Payroll.Payroll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

public class ContractTest {

    @Test
    public void createPartTimeContract() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endingDate = currentDate.plusDays(1);

        Contract partTimeContract = new Contract("part-time", currentDate, endingDate, 5000.0);

        Assertions.assertEquals(currentDate, partTimeContract.getPostingDate());
        Assertions.assertEquals(endingDate, partTimeContract.getEndingDate());
        Assertions.assertEquals(1, partTimeContract.getContractVersions().size());
        Assertions.assertEquals(5000.0, partTimeContract.getSalary());
    }

    @Test
    public void cantCreateInvalidVersionOfContractTest() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endingDate = currentDate.plusDays(1);

        Contract partTimeContract = new Contract("part-time", currentDate, endingDate, 5000.0);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            partTimeContract.createContractVersion("part-time", endingDate, currentDate, 5000.0);
        }, "Invalid contract");

        Assertions.assertEquals(1, partTimeContract.getContractVersions().size());
    }

    @Test
    public void createFullTimeContract() {
        LocalDate currentDate = LocalDate.now();
        LocalDate endingDate = currentDate.plusDays(1);

        Contract partTimeContract = new Contract("full-time", currentDate, endingDate, 5000.0);

        Assertions.assertEquals(currentDate, partTimeContract.getPostingDate());
        Assertions.assertEquals(endingDate, partTimeContract.getEndingDate());
        Assertions.assertEquals(1, partTimeContract.getContractVersions().size());
        Assertions.assertEquals(5000.0, partTimeContract.getSalary());
    }

    @Test
    public void asda(){
        LocalDate startDate = LocalDate.of(2021, 5, 1);
        LocalDate endDate = LocalDate.of(2023, 6, 1);

        double months = ChronoUnit.MONTHS.between(startDate, endDate);

        long years = ChronoUnit.YEARS.between(startDate, endDate);
        System.out.println(months/12);

        Assertions.assertEquals(25,months);

    }

    @Test
    public void calculatePayroll(){
        // Rango 1
        LocalDate postingDate1 = LocalDate.of(2023, 6, 1);
        LocalDate endDate1 = LocalDate.of(2023, 6, 10);

        // Rango 2
        LocalDate postingDate2 = endDate1.plusDays(1);
        LocalDate endDate2 = postingDate2.plusDays(9);

        // Rango 3
        LocalDate postingDate3 = endDate2.plusDays(1);
        LocalDate endDate3 = postingDate3.plusDays(9);


        Payroll payroll =  new Payroll();
        Contract partTimeContract = new Contract("part-time", postingDate1, endDate1, 5000.0);
        partTimeContract.createContractVersion("full-time", postingDate2, endDate2, 2000);
        partTimeContract.createContractVersion("full-time", postingDate3, endDate3, 4000);

        Assertions.assertEquals(1866.6666666,payroll.getTotalSalary(partTimeContract, postingDate1, endDate3), 0.3 );

    }
}
