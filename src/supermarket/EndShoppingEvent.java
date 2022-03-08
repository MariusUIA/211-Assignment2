/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import eventsim.Event;
import eventsim.EventSim;


/**
 * A customer finishes shopping and heads for the checkout with the shortest
 * queue
 *
 * @author evenal
 */
public class EndShoppingEvent extends Event {
    Customer customer;
    Checkout checkout;


    public EndShoppingEvent(Customer customer, Checkout checkout) {
        super(customer.leaveTime);
        this.customer = customer;
        this.checkout = checkout;
        checkout.queue.poll();
    }


    @Override
    public Event happen() {
        customer.leaveTime = customer.checkoutTime + customer.checkoutDuration;
        return null;
    }


    @Override
    public String toString() {
        return "EndShoppingEvent {Current time is " + getTime() + ". (" + customer.name
                + ") has stood in line for " + customer.queueWaitDuration + " time. It took " + customer.checkoutDuration + " time for checkout}";
    }

}
