package com.erp.BI.repository;


import com.erp.BI.domain.SalesEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductUsageRepository extends CrudRepository<SalesEvent, Long> {
    List<SalesEvent> findByProduct_ProductIDAndMonthAndFinancialYear(int productID, String month, int financialYear);
    List<SalesEvent> findBySalesIDAndMonthAndFinancialYear(int salesID, String month, int financialYear);
    List<SalesEvent> findByMonthAndFinancialYear(String month, int financialYear);
    List<SalesEvent> findByClient_ClientID(int clientID);
}
