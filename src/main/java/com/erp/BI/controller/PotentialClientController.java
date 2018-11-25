package com.erp.BI.controller;

import com.erp.BI.service.PotentialClientService;
import com.erp.BI.service.ProductUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/BI/potentialClient")
public class PotentialClientController {

    @Autowired
    PotentialClientService potentialClientService;

    @Autowired
    ProductUsageService productUsageService;

    @GetMapping("/client/leastSoldProduct/{clientName}/")
    public int leastSoldProduct(
            @PathVariable(value = "clientName") String clientName
    ){
        int clientID = potentialClientService.leastSoldProduct(clientName);
        int leastSoldProduct = productUsageService.leastSoldProduct(clientID);
        return leastSoldProduct;
    }

    @GetMapping("/clientSince/{clientSince}/")
    public String leastActiveClient(
            @PathVariable(value = "clientSince") Date clientSince
    ){
       String leastActiveClient = potentialClientService.leastActiveClient(clientSince);
        return leastActiveClient;
    }

}
