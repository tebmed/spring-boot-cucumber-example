package org.canal.test.repository;
import java.util.List;

import org.canal.test.entities.HistoryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoryRepository extends CrudRepository<HistoryEntity, Long>{

	public List<HistoryEntity> findHistoryBySubscriberId(Long subscriberId);
	
}
