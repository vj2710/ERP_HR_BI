package com.erp.HR.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@SqlResultSetMapping(
        name="incrementFactors",
        columns = {
                @ColumnResult(name = "employeeId"),
                @ColumnResult(name = "totalHoursPunched"),
                @ColumnResult(name = "monthlyHours"),
                @ColumnResult(name = "joiningDate"),
                @ColumnResult(name = "monthlyLeaves"),
                @ColumnResult(name = "baseSalary"),
                @ColumnResult(name = "totalLeavesTaken"),
                @ColumnResult(name = "ratingByManager")
        }
)

@NamedNativeQuery(name="EmployeeInfo.calcPromInc", query = "select e.employeeId as employeeId, t.totalHoursPunched as totalHoursPunched, ps.monthlyHours as monthlyHours, h.joiningDate as joiningDate, ps.monthlyLeaves as monthlyLeaves, ps.baseSalary as baseSalary, t.totalLeavesTaken as totalLeavesTaken, t.ratingByManager as ratingByManager " +
        "from Timesheet t, PositionSalary ps, HiringInfo h, EmployeeInfo e " +
        "where e.employeeId = :employeeId and ps.department = e.department and ps.position = e.jobTitle " +
        "and t.employeeId = e.employeeId and h.employeeId = e.employeeId", resultSetMapping = "incrementFactors")
@Entity
@Table(name = "EmployeeInfo")
public class EmployeeInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private String emailId;
    private Date dateOfBirth;
    private Character gender;
    private Integer phoneNo;
    private String department;
    private String jobTitle;
    private Integer managerId;
    private Character activeFlag;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public char getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(char activeFlag) {
        this.activeFlag = activeFlag;
    }
}
