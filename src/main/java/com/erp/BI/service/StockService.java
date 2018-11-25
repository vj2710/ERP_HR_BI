package com.erp.BI.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
public class StockService {

    public String getStockPrice() throws IOException{

        URL url = new URL("https://www.worldtradingdata.com/api/v1/stock?symbol=AAPL,MSFT,HSBA.L&api_token=3A1z889eUXeT0s4VofpHhQE7xjamzypKJbOK3GCH7smex6kDw0N6SsaIgbp1");
        URLConnection urlconn = url.openConnection();
        InputStreamReader inStream = new InputStreamReader(urlconn.getInputStream());
        BufferedReader buff = new BufferedReader(inStream);

        String line = buff.readLine();
        return line;
    }
}
