package com.company;

import com.company.test.Test;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
//        Test.creatingAndCheckingCorrectDisplayOfAllProducts();
//        Test.processorTest();
//        Test.ramTest();
//        Test.addingAndRemovingProductsToProductManager();
//        Test.creatingClient();
//        Test.creatingCartAndPrintingInformation();
        Smartphone s =  new Smartphone( "samsung", BigDecimal.valueOf(120), 10, "red", 1200);
        Smartphone s2 = s.clone();
        System.out.println(s==s2);
    }
}
