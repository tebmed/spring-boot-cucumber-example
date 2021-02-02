package org.canal.test.glue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.canal.test.entities.ContractEntity;
import org.canal.test.entities.HistoryEntity;
import org.canal.test.entities.SubscriberEntity;
import org.canal.test.repository.SubscriberRepository;
import org.canal.test.services.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressModificationSteps {

	
	@Autowired
	private SubscriberRepository susbcriberRepository;
	
	
    @Autowired 
    SubscriberService subscriberService;
	
	private SubscriberEntity subscriber, expected, actual;
	
	private List<HistoryEntity> movements;
	
	
	@Before
	public void setup() {
		
		susbcriberRepository.deleteAll();
		subscriber = new SubscriberEntity();
		movements = new ArrayList<>();

	}
	
	
	@Given("^a subscriber with many contracts and a main address in france$")
	public void aSubscriberWithContractsAndAddress() {
		
		subscriber.setFirstName("Mohammed");
		subscriber.setLastName("TEBIB");
		subscriber.setAddress("France");
		
		List<ContractEntity> contracts = new ArrayList<ContractEntity>();
		ContractEntity contract1 = new ContractEntity();
		contract1.setAddress("Germay");
		contract1.setSubscriber(subscriber);
		
		ContractEntity contract2 = new ContractEntity();
		contract1.setAddress("Italy");
		contract1.setSubscriber(subscriber);
		
		contracts.add(contract1);
		contracts.add(contract2);
		
		subscriber.setContracts(contracts);
      
		susbcriberRepository.save(subscriber);
	}
	
	@Transactional
	@When("^the advisor update the subscriber address$")
	public void whenTheAdvisorUpdateTheAddress() throws JsonProcessingException{ 
		
	    actual = subscriberService.updateSubscriberAddress(this.subscriber.getId(), "Paris");  
	
	}
	
	@Then("^the new address of the suscriber is saved in the list of the subscriber contracts$")
	public void thenThenNewAddressIsSaved() {
		
		List<ContractEntity> contracts = new ArrayList<ContractEntity>();
		ContractEntity contract1 = new ContractEntity();
		contract1.setAddress("Paris");
		contract1.setSubscriber(subscriber);
	
   	    ContractEntity contract2 = new ContractEntity();
        contract1.setAddress("Paris");
       	contract1.setSubscriber(subscriber);

		contracts.add(contract1);
		contracts.add(contract2);
		
		expected = new SubscriberEntity("Mohammed", "TEBIB", "Paris", contracts);
		
		this.validateUpdatedAddress(expected, actual);
			
	}
	
	private void validateUpdatedAddress(SubscriberEntity expected, SubscriberEntity actual) {
	
		assertEquals(expected.getAddress(), actual.getAddress());
		assertEquals(actual.getAddress(), "Paris");
		assertEquals(actual.getContracts().get(0).getAddress(), "Paris");
	    
	}
	
	@And("^an address modification movement is created with the new address$")
	public void thenTheNewModificationMovementIsCreatedWithTheNewAddress() {
		 this.movements = subscriberService.getUpdatesHistory(this.subscriber.getId());
		 assertNotEquals(this.exists("France", "Paris", movements), null);
	}
	
	private HistoryEntity exists(String oldAddress, String newAddress, List<HistoryEntity> movements) {

		return movements.stream().filter(movement -> (newAddress.equals(movement.getNewAddress()) && (oldAddress.equals(movement.getOldAddress()))))
				                 .findAny()
				                 .orElse(null);
	}
}
