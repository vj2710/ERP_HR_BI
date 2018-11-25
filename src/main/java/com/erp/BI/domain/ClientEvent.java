package com.erp.BI.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "client")
public class ClientEvent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clientID;
    @Column(name = "clientName") private String clientName;
    @Column(name = "location") private String location;
    @Column(name = "productsEnrolled") private int productsEnrolled;
    @Column(name = "potentialProductsID") private int potentialProductsID;
    @Column(name = "clientClass") private String clientClass;
    @Column(name = "clientSince") private Date clientSince;

    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClientName() {
        return clientName;
    }

    public void setProductsEnrolled(int productsEnrolled) {
        this.productsEnrolled = productsEnrolled;
    }
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getProductsEnrolled() {
        return productsEnrolled;
    }

    public int getPotentialProductsID() {
        return potentialProductsID;
    }

    public void setPotentialProductsID(int potentialProductsID) {
        this.potentialProductsID = potentialProductsID;
    }

    public String getClientClass() {
        return clientClass;
    }

    public void setClientClass(String clientClass) {
        this.clientClass = clientClass;
    }

    public Date getClientSince() {
        return clientSince;
    }

    public void setClientSince(Date clientSince) {
        this.clientSince = clientSince;
    }
}