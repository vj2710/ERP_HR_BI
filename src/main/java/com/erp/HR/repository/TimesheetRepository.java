package com.erp.HR.repository;

import com.erp.HR.domain.Timesheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimesheetRepository extends CrudRepository<Timesheet, Integer> {

    List<Timesheet> getAllByEmployeeIdAndMonthAndFinancialYear(int employeeId, String month, int financialYear);
}
