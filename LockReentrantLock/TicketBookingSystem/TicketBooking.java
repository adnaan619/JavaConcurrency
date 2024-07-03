package LockReentrantLock.TicketBookingSystem;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketBooking {
   private int availableTickets;
   private final Lock lock = new ReentrantLock();
   
   public TicketBooking(int initialTickets){
        this.availableTickets = initialTickets;
   }

   public boolean bookTicket(String agentName) {
    lock.lock();
    try{
        if (availableTickets > 0) {
            availableTickets--;
            System.out.println(agentName + " booked a ticket. Tickets left: " + availableTickets);
            return true;
        } else {
            System.out.println(agentName + " tried to book a ticket, but none are available.");
            return false;
        }
    } finally{
        lock.unlock();
    }
   }

   public int getAvailableTickets(){
    return availableTickets;
   }
}
