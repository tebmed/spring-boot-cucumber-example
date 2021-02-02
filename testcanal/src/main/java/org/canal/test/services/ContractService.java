package org.canal.test.services;

import java.util.ArrayList;
import java.util.List;

import org.canal.test.entities.ContractEntity;
import org.canal.test.entities.SubscriberEntity;
import org.canal.test.repository.ContractRepository;
import org.canal.test.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ContractService {
	
	@Autowired
	private ContractRepository contractRepository;
	
	@Autowired
	private SubscriberRepository subscriberRepository;

	public List<ContractEntity> getAll(){
		return (ArrayList<ContractEntity>) contractRepository.findAll();
	}

	public ContractEntity subscribe(Long subscriberId,  String address) {
		
	    SubscriberEntity subscriberEntity = subscriberRepository.findSubscriberById(subscriberId);

		ContractEntity contractEntity = new ContractEntity();
		contractEntity.setAddress(address);
		contractEntity.setSubscriber(subscriberEntity);
		
		return contractRepository.save(contractEntity);
	}

	
}
