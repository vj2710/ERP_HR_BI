package com.erp.BI.repository;

import com.erp.BI.domain.ClientEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface PotentialClientRepository extends CrudRepository<ClientEvent, Long>{

    ClientEvent findByClientName(String clientName);
    List<ClientEvent> findByClientSinceGreaterThan(Date clientSince);
}