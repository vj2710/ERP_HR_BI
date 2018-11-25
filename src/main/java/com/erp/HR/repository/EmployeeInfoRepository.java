package com.erp.HR.repository;

import com.erp.HR.domain.EmployeeInfo;
import com.erp.HR.domain.IncrementFactors;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeInfoRepository extends CrudRepository<EmployeeInfo, Integer> {

    List<EmployeeInfo> getAllByEmployeeIdAndDepartmentAndJobTitle(int employeeId, String department, String jobTitle);
    List<EmployeeInfo> getAllByActiveFlag(char activeFlag);
    List<EmployeeInfo> getAllByEmployeeId(int employeeId);
    List<EmployeeInfo> getAllByDepartmentAndJobTitle(String department, String jobTitle);
    IncrementFactors calcPromInc(@Param("employeeId") int employeeId);
}
