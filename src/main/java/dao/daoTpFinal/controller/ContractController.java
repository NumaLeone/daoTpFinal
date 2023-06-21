package dao.daoTpFinal.controller;

import dao.daoTpFinal.model.Contract.Contract;
import dao.daoTpFinal.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contracts")
public class ContractController {

    private final ContractService contractService;

    @Autowired
    public ContractController (ContractService contractService){
        this.contractService = contractService;
    }

    @GetMapping
    public ResponseEntity<List<Contract>> getAllContracts(){
        List<Contract> contracts = contractService.getAllcontracts();
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contract> getContractById(@PathVariable Long id) {
        Contract contract = contractService.getContractById(id);
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contract> createContract(@RequestBody Contract contract){
        Contract savedContract  = contractService.saveContract(contract);
        return new ResponseEntity<>(savedContract, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContract(@PathVariable Long id) {
        contractService.deleteContract(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
