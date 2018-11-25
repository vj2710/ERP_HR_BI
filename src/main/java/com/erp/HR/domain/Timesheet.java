package com.erp.HR.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Timesheet")
public class Timesheet implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timesheetId;
    private Integer employeeId;
    private String month;
    private Integer financialYear;
    private Float totalHoursPunched;
    private Integer totalLeavesTaken;
    private Integer ratingByManager;

    public int getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(int timesheetId) {
        this.timesheetId = timesheetId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getFinancialYear() {
        return financialYear;
    }

    public void setFinancialYear(int financialYear) {
        this.financialYear = financialYear;
    }

    public float getTotalHoursPunched() {
        return totalHoursPunched;
    }

    public void setTotalHoursPunched(float totalHoursPunched) {
        this.totalHoursPunched = totalHoursPunched;
    }

    public int getTotalLeavesTaken() {
        return totalLeavesTaken;
    }

    public void setTotalLeavesTaken(int totalLeavesTaken) {
        this.totalLeavesTaken = totalLeavesTaken;
    }

    public int getRatingByManager() {
        return ratingByManager;
    }

    public void setRatingByManager(int ratingByManager) {
        this.ratingByManager = ratingByManager;
    }
}
