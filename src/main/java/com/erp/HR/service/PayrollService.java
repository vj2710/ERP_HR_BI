package com.erp.HR.service;

import com.erp.HR.domain.Payroll;
import com.erp.HR.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollService {

    @Autowired
    PayrollRepository payrollRepository;

    public boolean updateEmployeeDetails(int employeeId, int bonus, int baseSalary){

        Payroll payroll = payrollRepository.getByEmployeeId(employeeId);

        if(payroll!=null) {
            payroll.setIncentives(bonus);
            payroll.setBasePay(baseSalary);
            payroll.setTotalPay(baseSalary + bonus);
            payroll.setPaymentType("WT");
            payrollRepository.save(payroll);
            return true;
        }

        return false;
    }
}
