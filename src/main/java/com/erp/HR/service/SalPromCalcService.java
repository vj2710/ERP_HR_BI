package com.erp.HR.service;

import com.erp.HR.repository.SalPromCalcRepository;
import com.erp.HR.domain.IncrementFactors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class SalPromCalcService {

    @Autowired
    SalPromCalcRepository salPromCalcRepository;

    @Autowired
    PayrollService payrollService;

    public int getBaseSalaryByPositionAndDepartment(String position, char department){
        return salPromCalcRepository.getBaseSalaryByPositionAndDepartment(position, department);
    }

    public boolean calcPromInc(IncrementFactors incrementFactors){

        float hoursFactorIncrement, leavesFactorDeduction, experienceFactorIncrement, managerRating;
        Calendar cal = Calendar.getInstance();
        cal.setTime(incrementFactors.getJoiningDate());

        managerRating = incrementFactors.getRatingByManager();
        System.out.println("ManagerRating = "+managerRating);

        int extraLeaves = incrementFactors.getTotalLeavesTaken() - incrementFactors.getMonthlyLeaves();
        if(extraLeaves > 0) {
            extraLeaves = extraLeaves / incrementFactors.getMonthlyLeaves();
            leavesFactorDeduction = (extraLeaves-0)/20;
        } else
            leavesFactorDeduction = 0;
        System.out.println("Leaves = "+extraLeaves + " ded = " + leavesFactorDeduction);

        float extraHours = incrementFactors.getTotalHoursPunched() - incrementFactors.getMonthlyHours();
        if(extraHours>0 && extraHours<(0.25*incrementFactors.getMonthlyHours()))
            hoursFactorIncrement = (float)((extraHours - 0)/(0.25*incrementFactors.getMonthlyHours() - 0));
        else
            hoursFactorIncrement = 0;
        System.out.println("Hours = "+extraHours + " inc = " + hoursFactorIncrement);

        experienceFactorIncrement = ((Calendar.getInstance().get(Calendar.YEAR) - cal.get(Calendar.YEAR))-1)/9;
        System.out.println("Experience = "+experienceFactorIncrement);

        int bonus = (int)(Math.floor(managerRating) - Math.floor(leavesFactorDeduction)
                + Math.floor(hoursFactorIncrement) + Math.floor(experienceFactorIncrement));

        if(payrollService.updateEmployeeDetails(incrementFactors.getEmployeeId(), bonus, incrementFactors.getBaseSalary()))
            return true;
        else
            return false;

    }
}
