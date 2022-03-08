/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author evenal
 */
public class Checkout {
    public static final int PROD_DURATION = 2;
    public static final int PAY_DURATION = 15;
    SuperMarket shop;
    String name;
    Queue<Customer> queue = new LinkedList<>();
    int nextCustomerTime = 0;


    public Checkout(SuperMarket shop, int i) {
        this.shop = shop;
        this.name = "Checkout" + i;
    }

    public Queue<Customer> getQueue() {
        return queue;
    }

    public void queueAdd(Customer customer){
        queue.add(customer);
    }

    public void setNextCustomerTime(int nextCustomerTime){
        this.nextCustomerTime = nextCustomerTime;
    }

    public int getNextCustomerTime() {
        return nextCustomerTime;
    }
}
