package dao.daoTpFinal.EmployeesTest;
import dao.daoTpFinal.model.Employee.FullTimeEmployee;
import dao.daoTpFinal.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestPropertySource(properties = {
        "spring.jpa.hibernate.ddl-auto=create-drop",
        "spring.datasource.url=jdbc:h2:mem:testdb"
})
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void testCreateFullTimeEmployee() {
        // Crear instancia de FullTimeEmployee
        FullTimeEmployee employee = new FullTimeEmployee();
        employee.setName("John Doe");
        employee.setContactDetails("john.doe@example.com");
        employee.setSalary(5000.0);

        // Llamar al método para crear el empleado
        FullTimeEmployee createdEmployee = employeeService.createFullTimeEmployee(employee);

        // Verificar que el empleado se haya creado correctamente
        assertNotNull(createdEmployee.getId());
    }
}