package dao.daoTpFinal.EmployeesTest;

import dao.daoTpFinal.model.Contract.FullTimeContract;
import dao.daoTpFinal.model.Employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class EmployeeTest {

    @Test
    public void createEmployee(){
        Employee employee = new Employee("Numa", "numa@gmail.com");
        Assertions.assertEquals("Numa", employee.getName());
        Assertions.assertEquals("numa@gmail.com", employee.getContactDetails());

    }

    @Test
    public void addFullTimeContractToEmployee(){
        Employee employee = new Employee("Numa", "numa@gmail.com");
        Date currentDate = new Date();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date endingDate = calendar.getTime();
//        FullTimeContract fullTimeContract = new FullTimeContract(currentDate, 5000.0);
//        fullTimeContract.setEmployee(employee);
//        fullTimeContract.setEndingDate(endingDate);
//
//        Assertions.assertEquals(currentDate, fullTimeContract.getPostingDate());
//        Assertions.assertEquals(endingDate, fullTimeContract.getEndingDate());
//        Assertions.assertEquals(5000.0, fullTimeContract.getSalary());
//        Assertions.assertEquals(employee, fullTimeContract.getEmployee());

    }
}
