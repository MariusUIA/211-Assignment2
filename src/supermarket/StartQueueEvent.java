/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;

import java.util.Arrays;

public class StartQueueEvent extends Event {
    Customer customer;
    Checkout[] checkouts = SuperMarket.getCheckouts();
    Checkout checkout;


    public StartQueueEvent(Customer customer) {
        super(customer.endShoppingTime);
        this.customer = customer;
    }


    @Override
    public Event happen() {
        checkout = checkouts[0];
        for (Checkout check:checkouts) {
            if(check.nextCustomerTime < checkout.nextCustomerTime){
                checkout = check;
            }
        }
        customer.checkoutLine = checkout.queue.size();
        checkout.queueAdd(customer);
        if (checkout.getNextCustomerTime() > getTime()) {
            customer.checkoutTime = checkout.getNextCustomerTime();
        }
        else {
            customer.checkoutTime = getTime();
        }
        customer.queueWaitDuration = customer.checkoutTime - customer.endShoppingTime;
        checkout.setNextCustomerTime(customer.checkoutTime + customer.checkoutDuration);


        System.out.println("Customer " + customer.name + " stopped shopping at time " + customer.endShoppingTime + ". They waited in queue for " + customer.queueWaitDuration + ".");

        return new EndShoppingEvent(customer, checkout);
    }

    @Override
    public String toString() {
        return "StartQueueEvent {Curent time is " + getTime() + ". (" + customer.name + ")";
    }
}
