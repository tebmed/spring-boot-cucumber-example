package org.canal.test.repository;

import org.canal.test.entities.SubscriberEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberRepository extends CrudRepository<SubscriberEntity, Long>{

	public SubscriberEntity findSubscriberById(Long subscriberId);
	
}
