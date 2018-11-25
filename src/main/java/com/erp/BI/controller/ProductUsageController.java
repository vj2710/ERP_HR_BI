package com.erp.BI.controller;

import com.erp.BI.service.GrowthManagementService;
import com.erp.BI.service.ProductUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BI/productUsage")
public class ProductUsageController {

    @Autowired
    ProductUsageService productUsageService;

    @Autowired
    GrowthManagementService growthManagementService;

    @GetMapping("/sales/{id}/{month}/{year}/")
    public int productUsage(
            @PathVariable(value = "id") int productID,
            @PathVariable(value = "month") String month,
            @PathVariable(value = "year") int year
    ) {
        return productUsageService.product_Usage(productID, month, year);
    }
    @GetMapping("/sales/{id}/{month}/{year}/totalProfit/")
    public double productTotalProfit(
            @PathVariable(value = "id") int productID,
            @PathVariable(value = "month") String month,
            @PathVariable(value = "year") int year
    ) {
       double total_profit = productUsageService.productTotalProfit(productID,month,year);
        return total_profit;
    }

    @GetMapping("/sales/{month}/{year}/profits/")
    public double highProfits(
            @PathVariable(value = "month") String month,
            @PathVariable(value = "year") int year
    ){
        List<Integer> productIDs = productUsageService.allPIDBasedOnMonthYear(month, year);
        double total_cost_productID = 0;
        for (Integer e: productIDs){
            total_cost_productID = total_cost_productID + growthManagementService.cost_total(e);
        }
        double profit = productUsageService.sellingPricetotal(month, year) - total_cost_productID;
        return profit;
    }

    @GetMapping("/sales/{month}/{year}/loss/")
    public double lossesIncurred(
            @PathVariable(value = "month") String month,
            @PathVariable(value = "year") int year
    ){
        List<Integer> productIDs = productUsageService.allPIDBasedOnMonthYear(month, year);
        double total_cost_productID = 0;
        for (Integer e: productIDs){
            total_cost_productID = total_cost_productID + growthManagementService.cost_total(e);
        }
        double loss = total_cost_productID - productUsageService.sellingPricetotal(month, year);
        if(loss < 0)
            loss = 0;
        return loss;
    }

}