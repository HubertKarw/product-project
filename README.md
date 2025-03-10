# Product Project
Internet shop for electronics  
[Project][git-repo]

## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Features](#features)
* [Project status](#project-status)
* [Featured code](#featured-code)

## General info
This is project creating complete system for internet shop using Java.  
This program allows to:  
* Create users  
* Manage shopping carts and products
* Processing orders
<p align="right">(<a href="#table-of-contents">back to top⬆️</a>)</p>

## Technologies
* [Java][java-url] SDK version: 18.0.2
<p align="right">(<a href="#table-of-contents">back to top⬆️</a>)</p>


## Features
* Creating products such as computer, smartphone and electronics
* Displaying list of available Products
* Creating and displaying Cart with items added by client
* Creating Client
* Ordering items
* Creating receipts for orders
* Keeping information about order times
* Multithreaded order processing
* Option for discounting cart price
<p align="right">(<a href="#table-of-contents">back to top⬆️</a>)</p>



## Project status
* Task 1 :green_square:
* Task 2 :green_square:
* Task 3 :green_square:
* Task 4 :green_square:
* Task 5 :green_square:
* Task 6 :green_square:
* Task 7 :green_square:
* Task 8 :green_square:
* Task 9 :green_square:
* Task 10 :green_square:
* Task 11 :green_square:
* Task 12 :green_square:
* Task 13 :yellow_square:
* Task 14 :green_square:
* Task 15 :yellow_square:
<p align="right">(<a href="#table-of-contents">back to top⬆️</a>)</p>

## Featured code
Code for multi thread order processing
* To improve order processing time and allow processing multiple orders at once i`ve use asychronized method for processing order. It uses synchronized  in few methods to make sure that processing multiple orders at the same time does not lead to wrong outputs in problematic moments of the code running.
```
    public void run() {
        orderToProcess.markOrderAsProcessed();
        String receipt = createReceipt();
        System.out.println(receipt);
        writeToFile(receipt);
        orderToProcess.getCart().placeOrder();
        orderToProcess.setTotalPrice(BigDecimal.ZERO);
        System.out.println(Thread.currentThread().getName() + ": finished");
        System.out.println(Thread.currentThread().getId() + ": finished");
    }
```
<p align="right">(<a href="#table-of-contents">back to top⬆️</a>)</p>


[java-url]:https://www.java.com/pl/  
[git-repo]:https://github.com/HubertKarw/product-project  
