package org.canal.test.services;

import java.util.ArrayList;
import java.util.List;

import org.canal.test.entities.ContractEntity;
import org.canal.test.entities.HistoryEntity;
import org.canal.test.entities.SubscriberEntity;
import org.canal.test.repository.HistoryRepository;
import org.canal.test.repository.SubscriberRepository;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SubscriberService {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@Autowired
	private HistoryRepository historyRepository;
	
	public List<SubscriberEntity> getAll(){
		return (ArrayList<SubscriberEntity>) subscriberRepository.findAll();	
	}

	public SubscriberEntity create(String firstName, String lastName, String address) {
		
		SubscriberEntity subscriberEntity = new SubscriberEntity();
	       
		subscriberEntity.setFirstName(firstName);
	    subscriberEntity.setLastName(lastName);
	    subscriberEntity.setAddress(address);
		
	    return subscriberRepository.save(subscriberEntity);
	}
	
	public SubscriberEntity updateSubscriberAddress(Long subscriberId,  String newAddress) {
		
	    SubscriberEntity subscriberEntity = subscriberRepository.findSubscriberById(subscriberId);
	    
	    String oldAddress = subscriberEntity.getAddress();
	    
	    subscriberEntity.setAddress(newAddress);	
	    
	    List<ContractEntity> contracts = subscriberEntity.getContracts();
	    HistoryEntity newChange = new HistoryEntity();

	    for (ContractEntity contractEntity : contracts) {
		   contractEntity.setAddress(newAddress);
		    newChange.setcontractId(contractEntity.getId());
	    }  
	    subscriberEntity.setContracts(contracts); 
	    newChange.setsubscriberId(subscriberEntity.getId());
	    newChange.setDate(LocalDate.now());
	    newChange.setOldAddress(oldAddress);
	    newChange.setNewAddress(newAddress);
	    
	    newChange.setEvent("update address -- SubscriberName: "+subscriberEntity.getFirstName() +
	    		           ", oldAddress= "+ oldAddress+ ", newAddress= "+ newAddress+
	    		           ", at: "+ LocalDate.now());
	    
	    historyRepository.save(newChange);
	    
	    return subscriberRepository.save(subscriberEntity);
	}
	
    public List<ContractEntity> getSubscriberContracts(Long subscriberId) {
    	    	
    	SubscriberEntity subscriber = subscriberRepository.findSubscriberById(subscriberId);
    	    	
		return  subscriber.getContracts();
	}
    

    public List<HistoryEntity> getUpdatesHistory(Long subscriberId) {
    	
    	return historyRepository.findHistoryBySubscriberId(subscriberId);	
    
    }
}
