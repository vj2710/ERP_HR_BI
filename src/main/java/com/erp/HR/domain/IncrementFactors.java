package com.erp.HR.domain;

import java.sql.Date;

public interface IncrementFactors {

    public int getEmployeeId();

    public Float getTotalHoursPunched();

    public Integer getMonthlyHours();

    public Date getJoiningDate();

    public Integer getMonthlyLeaves();

    public Integer getBaseSalary();

    public Integer getTotalLeavesTaken();

    public Integer getRatingByManager();

}
