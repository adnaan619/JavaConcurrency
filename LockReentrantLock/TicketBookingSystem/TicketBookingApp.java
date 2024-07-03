package LockReentrantLock.TicketBookingSystem;

public class TicketBookingApp {
    public static void main(String[] args){
        TicketBooking ticketBooking = new TicketBooking(10);
        TicketBookingWithReentrantLock reentrantTicketBooking = new TicketBookingWithReentrantLock(10);

        Runnable bookingTask = () -> {
            String agentName = Thread.currentThread().getName();
            for (int i = 0; i < 3; i++){
                ticketBooking.bookTicket(agentName);
                reentrantTicketBooking.bookTicket(agentName);
            }
        };

        Thread agent1 = new Thread(bookingTask, "Agent1");
        Thread agent2 = new Thread(bookingTask, "Agent2");
        Thread agent3 = new Thread(bookingTask, "Agent3");

        agent1.start();
        agent2.start();
        agent3.start();

        try{
            agent1.join();
            agent2.join();
            agent3.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("Final available tickets for lock-based booking: " + ticketBooking.getAvailableTickets());
        System.out.println("Final available tickets for reentrant lock based booking: " + reentrantTicketBooking.getAvailableTickets());
    }
}
