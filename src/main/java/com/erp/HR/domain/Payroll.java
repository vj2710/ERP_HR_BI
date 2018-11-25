package com.erp.HR.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Payroll")
public class Payroll implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int payrollId;
    private Integer employeeId;
    private Integer basePay;
    private Integer incentives;
    private Integer totalPay;
    private String paymentType;

    public int getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(int payrollId) {
        this.payrollId = payrollId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getBasePay() {
        return basePay;
    }

    public void setBasePay(int basePay) {
        this.basePay = basePay;
    }

    public int getIncentives() {
        return incentives;
    }

    public void setIncentives(int incentives) {
        this.incentives = incentives;
    }

    public int getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(int totalPay) {
        this.totalPay = totalPay;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

}
