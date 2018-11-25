package com.erp.BI.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "sales")
public class SalesEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int salesID;
    @Column(name = "unitsSold") private int unitsSold;
    @Column(name = "month") private String month;
    @Column(name = "financialYear") private int financialYear;
    @Column(name = "sellingPrice") private Double sellingPrice;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "clientID") private ClientEvent client;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productID") private ProductEvent product;

    public int getSalesID() {
        return salesID;
    }
    public void setSalesID(int salesID) {
        this.salesID = salesID;
    }
    public int getUnitsSold() {
        return unitsSold;
    }
    public void setUnitsSold(int unitsSold) {
        this.unitsSold = unitsSold;
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

    public ClientEvent getClient() {
        return client;
    }

    public void setClient(ClientEvent client) {
        this.client = client;
    }

    public ProductEvent getProduct() {
        return product;
    }

    public void setProduct(ProductEvent product) {
        this.product = product;
    }
    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}

