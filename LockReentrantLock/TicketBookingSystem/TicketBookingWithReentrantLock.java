package LockReentrantLock.TicketBookingSystem;

import java.util.concurrent.locks.ReentrantLock;

public class TicketBookingWithReentrantLock {
    private int availableTickets;
    private final ReentrantLock lock = new ReentrantLock();

    public TicketBookingWithReentrantLock(int initialTickets){
        this.availableTickets = initialTickets;
    }

    public boolean bookTicket(String agentName){
        lock.lock();
        try{
            if (availableTickets > 0) {
                availableTickets--;
                System.out.println(agentName + " booked a ticket. Tickets left: "+ availableTickets);
                return true;
            } else{
                System.out.println(agentName + " tried to boook a ticket, but there are no available tickets.");
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
