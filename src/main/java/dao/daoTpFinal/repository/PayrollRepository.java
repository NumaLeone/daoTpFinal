package dao.daoTpFinal.repository;

import dao.daoTpFinal.model.Payroll.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, Long> {

}