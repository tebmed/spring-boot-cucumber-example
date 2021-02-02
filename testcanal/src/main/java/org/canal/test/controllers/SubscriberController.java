package org.canal.test.controllers;

import java.util.List;

import org.canal.test.entities.ContractEntity;
import org.canal.test.entities.HistoryEntity;
import org.canal.test.entities.SubscriberEntity;
import org.canal.test.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/subscriber")
public class SubscriberController {
	
	  @Autowired
	  private SubscriberService subscriberService;
	  
	  @GetMapping("/subscribers")
	  public List<SubscriberEntity> getAllSubscribers(){
		  return subscriberService.getAll();
      }
	  
	  @PostMapping(value="/create")
	  public SubscriberEntity createSubscriber(@RequestParam("firstName") String firstName,
			                                   @RequestParam("lastName") String lastName,
			                                   @RequestParam("address") String address) {
		   
		   return subscriberService.create(firstName, lastName, address);
	  }
	  
	  @PutMapping(value="/updateAddress")
	  public SubscriberEntity updateSubscriberAddress(@RequestParam("subscriberId") Long subscriberId,
                                                      @RequestParam("newAddress") String newAddress) {
		  return subscriberService.updateSubscriberAddress(subscriberId, newAddress);
	  }
	  
	  @GetMapping("/getContracts")
	  public List<ContractEntity> getSubscriberContracts(@RequestParam("subscriberId") Long subscriberId) {
		  return subscriberService.getSubscriberContracts(subscriberId);
	  }
	 
	  @GetMapping("/getUpdatesHistory")
	  public List<HistoryEntity>  getUpdatesHistory(Long subscriberId) {
		  return subscriberService.getUpdatesHistory(subscriberId);
	  }
	 
}
