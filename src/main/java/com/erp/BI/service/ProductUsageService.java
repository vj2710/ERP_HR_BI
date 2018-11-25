package com.erp.BI.service;

import com.erp.BI.domain.SalesEvent;
import com.erp.BI.repository.ProductUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductUsageService {

    @Autowired
    private ProductUsageRepository productUsageRepository;


    public int product_Usage(int id, String month, int year) {
        List<SalesEvent> products_list = productUsageRepository.findByProduct_ProductIDAndMonthAndFinancialYear(id,month,year);
        return (products_list.size()+1);
    }


    public double productTotalProfit (int id, String month, int year) {
        List<SalesEvent> products_list = productUsageRepository.findByProduct_ProductIDAndMonthAndFinancialYear(id,month,year);
        double total = 0;
        for(int i = 0; i < products_list.size(); i++){
            SalesEvent s = products_list.get(i);
            int units_sold = s.getUnitsSold();
            double selling_price = s.getSellingPrice();
            double price = units_sold*selling_price;
            total = total + price;
        }
        return total;

    }

    public double sellingPricetotal (String month, int year){
        List<SalesEvent> products_list = productUsageRepository.findByMonthAndFinancialYear(month,year);
        double total = 0;
        for (SalesEvent s: products_list) {
            total = total + s.getUnitsSold()*s.getSellingPrice();
        }
        return total;
    }
    public List<Integer>  allPIDBasedOnMonthYear(String month, int year){
        List<SalesEvent> product_list = productUsageRepository.findByMonthAndFinancialYear(month,year);
        List<Integer> data = new ArrayList<>();
        for (SalesEvent s:product_list) {
                Integer e = s.getProduct().getProductID();
                data.add(e);
        }
        return data;
    }

    public int leastSoldProduct(int clientID){
     List<SalesEvent> salesEvents = productUsageRepository.findByClient_ClientID(clientID);
     Map<Integer,Integer> productCount = new HashMap<Integer,Integer>();
     for (SalesEvent s:salesEvents) {
         if(productCount.containsKey(s.getProduct().getProductID())){
             int units = s.getUnitsSold();
             int total = productCount.get(s.getProduct().getProductID())+units;
             productCount.replace(s.getProduct().getProductID(),total);
         }
         else {
             productCount.put(s.getProduct().getProductID(),s.getUnitsSold());
         }
        }

        int leastSoldProductID = Collections.min(productCount.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
     return leastSoldProductID;

    }


}