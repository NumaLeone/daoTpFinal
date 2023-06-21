package dao.daoTpFinal.repository;

import dao.daoTpFinal.model.Employee.Employee;
import dao.daoTpFinal.model.Employee.FullTimeEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("SELECT e FROM FullTimeEmployee e")
    List<FullTimeEmployee> findAllFullTimeEmployees();
}
