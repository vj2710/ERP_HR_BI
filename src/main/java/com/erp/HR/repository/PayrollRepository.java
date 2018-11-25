package com.erp.HR.repository;

import com.erp.HR.domain.Payroll;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends CrudRepository<Payroll, Integer> {

    Payroll getByEmployeeId(int employeeId);
}
