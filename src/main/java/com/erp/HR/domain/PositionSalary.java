package com.erp.HR.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PositionSalary")
public class PositionSalary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int positionId;
    private String position;
    private String department;
    private Integer baseSalary;
    private Integer monthlyLeaves;
    private Integer monthlyHours;
    private Character employmentType;

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getMonthlyLeaves() {
        return monthlyLeaves;
    }

    public void setMonthlyLeaves(int monthlyLeaves) {
        this.monthlyLeaves = monthlyLeaves;
    }

    public int getMonthlyHours() {
        return monthlyHours;
    }

    public void setMonthlyHours(int monthlyHours) {
        this.monthlyHours = monthlyHours;
    }

    public char getEmploymentType() {
        return employmentType;
    }

    public void setEmploymentType(char employmentType) {
        this.employmentType = employmentType;
    }
}
