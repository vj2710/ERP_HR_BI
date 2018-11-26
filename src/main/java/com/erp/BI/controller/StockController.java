package com.erp.BI.controller;


import com.erp.BI.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/BI/stock")
public class StockController {


    @Autowired
    private StockService stockService;

    @GetMapping("/getPrice")
    public String getStockPrice() throws IOException {
        String stock = stockService.getStockPrice();
        return stock;
    }
}
