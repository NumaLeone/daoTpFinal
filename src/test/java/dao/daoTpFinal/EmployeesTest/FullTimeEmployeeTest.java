package dao.daoTpFinal.EmployeesTest;

import dao.daoTpFinal.model.Employee.FullTimeEmployee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullTimeEmployeeTest {

    @Test
    public void testGettersAndSetters() {
        FullTimeEmployee employee = new FullTimeEmployee();
        employee.setName("John Doe");
        employee.setContactDetails("john.doe@example.com");
        employee.setSalary(5000.0);

        assertEquals("John Doe", employee.getName());
        assertEquals("john.doe@example.com", employee.getContactDetails());
        assertEquals(5000.0, employee.calculateSalary());
    }

    @Test
    public void testCalculateSalary() {
        FullTimeEmployee employee = new FullTimeEmployee();
        employee.setName("John Doe");
        employee.setContactDetails("john.doe@example.com");
        employee.setSalary(5000.0);

        assertEquals(5000.0, employee.calculateSalary());
    }
}
