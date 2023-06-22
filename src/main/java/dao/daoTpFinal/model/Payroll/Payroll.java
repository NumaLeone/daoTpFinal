package dao.daoTpFinal.model.Payroll;

import dao.daoTpFinal.model.Contract.Contract;
import dao.daoTpFinal.model.Contract.ContractVersion;
import dao.daoTpFinal.model.Employee.Employee;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

public class Payroll {

    public Payroll() {

    }

    private List<ContractVersion> interceptContracts(Contract contract, LocalDate startDate, LocalDate endDate){
        Stack<ContractVersion> newStack = contract.getContractVersions();
        List<ContractVersion> versions = new ArrayList<>();
            for (int i = 0; i < newStack.size(); i++) {
                    if(newStack.peek().getPostingDate().isAfter(startDate) && newStack.peek().getPostingDate().isBefore(endDate)){
                        versions.add(newStack.pop());
                    }
            }
        return versions;
    }

   public double getTotalSalary(Contract contract, LocalDate startDate, LocalDate endDate){
        List<ContractVersion> versions = interceptContracts(contract,  startDate,  endDate);
        double total = 0;
       for (int i = 0; i < versions.size(); i++) {
           if(endDate.isBefore(versions.get(i).getEndDate())){
               double months = getMonthDifference(versions.get(i).getPostingDate(), endDate);
               total += versions.get(i).getSalary()*months;
           }else {
               double months = getMonthDifference(versions.get(i).getPostingDate(), versions.get(i).getEndDate());
               total += versions.get(i).getSalary()*months;
           }

       }

        return total;
   }

   private double getMonthDifference(LocalDate postingDate, LocalDate endDate){
       long daysDifference = ChronoUnit.DAYS.between(postingDate, endDate);
       int totalDaysInMonth = endDate.getMonth().length(endDate.isLeapYear());
       double monthsDifference = (double) daysDifference / totalDaysInMonth;
       return monthsDifference;
   }

}
