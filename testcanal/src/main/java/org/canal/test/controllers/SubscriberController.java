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
	  
	  
	  /*
	   * Get all subscriber list
	   * @retrun the list
	   */
	  @GetMapping("/subscribers")
	  public List<SubscriberEntity> getAllSubscribers(){
		  return subscriberService.getAll();
      }
	  
	  /*
	   * Create a new susbcriber
	   * @param subscriber infromations: firstName, lastName, address
	   * @retrun the created subscriber
	   */
	  @PostMapping(value="/create")
	  public SubscriberEntity createSubscriber(@RequestParam("firstName") String firstName,
			                                   @RequestParam("lastName") String lastName,
			                                   @RequestParam("address") String address) {
		   
		   return subscriberService.create(firstName, lastName, address);
	  }
	  
	  
	  
	  /*
	   * update a subscriber address
	   * @param subscriber id, the new address
	   */
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
