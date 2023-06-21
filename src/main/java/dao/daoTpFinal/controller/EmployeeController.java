package dao.daoTpFinal.controller;

import dao.daoTpFinal.model.Employee.Employee;
import dao.daoTpFinal.model.Employee.FullTimeEmployee;
import dao.daoTpFinal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/full-time")
    public FullTimeEmployee createFullTimeEmployee(@RequestBody FullTimeEmployee employee) {
        return employeeService.createFullTimeEmployee(employee);
    }
    @GetMapping("/full-time/all")
    public List<FullTimeEmployee> getAllFullTimeEmployees() {
        return employeeService.getAllFullTimeEmployees();
    }
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
