package dao.daoTpFinal.service;

import dao.daoTpFinal.model.Employee.ContractEmployee;
import dao.daoTpFinal.model.Employee.Employee;
import dao.daoTpFinal.model.Employee.FullTimeEmployee;
import dao.daoTpFinal.model.Employee.PartTimeEmployee;
import dao.daoTpFinal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));
    }
    public List<FullTimeEmployee> getAllFullTimeEmployees(){
        return employeeRepository.findAllFullTimeEmployees();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existingEmployee.setName(employee.getName());
        existingEmployee.setContactDetails(employee.getContactDetails());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        if (employeeRepository.existsById(id)) {
            employeeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }

    public FullTimeEmployee createFullTimeEmployee(FullTimeEmployee employee) {

        return employeeRepository.save(employee);
    }

    public PartTimeEmployee createPartTimeEmployee(PartTimeEmployee employee) {

        return employeeRepository.save(employee);
    }

    public ContractEmployee createContractEmployee(ContractEmployee employee) {

        return employeeRepository.save(employee);
    }
}
