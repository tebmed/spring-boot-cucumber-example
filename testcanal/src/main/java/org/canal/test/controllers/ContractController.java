package org.canal.test.controllers;

import java.util.List;

import org.canal.test.entities.ContractEntity;
import org.canal.test.services.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/contract")
public class ContractController {
	
	  @Autowired
	  private ContractService contractService;
	  
	  
	  /*
	   * Get all conctracts list
	   * @retrun the list
	   */
	  @GetMapping("/contracts")
	  public List<ContractEntity> getAllContracts(){
		  return contractService.getAll();
      }
	  
	  
	  /*
	   * Subscrine to a contract
	   * @param id of the subscriber
	   * @retrun the list
	   */
	  @PostMapping(value="/subscribe")
	  public ResponseEntity<String> subscribe(@RequestParam("subscriberId") Long subscriberId,
			                  @RequestParam("address")      String address) {
	
		 contractService.subscribe(subscriberId, address);
		 return new ResponseEntity<>("Done!", HttpStatus.OK);
	  }
	  
}
