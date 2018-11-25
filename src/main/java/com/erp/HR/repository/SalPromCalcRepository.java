package com.erp.HR.repository;

import com.erp.HR.domain.PositionSalary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalPromCalcRepository extends CrudRepository<PositionSalary, Integer> {

    int getBaseSalaryByPositionAndDepartment(String position, char department);
    //List<Integer> getEmployeeIdByActiveFlag(char activeFlag);
}
