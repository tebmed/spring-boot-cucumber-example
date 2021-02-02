package org.canal.test.repository;

import java.util.List;
import java.util.Optional;
import org.canal.test.entities.ContractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends CrudRepository<ContractEntity, Long> {
	
	 Optional<ContractEntity> findByIdAndSubscriberId(Long id, Long subscriberId);
	 
	 List<ContractEntity> findBySubscriberId(Long subscriberId);
}
