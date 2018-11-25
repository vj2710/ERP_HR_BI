package com.erp.BI.controller;

import com.erp.BI.domain.ProductEvent;
import com.erp.BI.service.GrowthManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/BI/growthManagement")
public class GrowthManagementController {

    @Autowired
    private GrowthManagementService growthManagementService;

    @GetMapping("/products/startDate/{startDate}/endDate/{endDate}")
    public List<ProductEvent> productsDeclined (
             @PathVariable Date startDate,
             @PathVariable Date endDate
             ){
        List<ProductEvent> products_declined = growthManagementService.productsDeclined(startDate, endDate,"Declined");
        return products_declined;
    }

}
