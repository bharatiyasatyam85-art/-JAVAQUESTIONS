class TicketBooking {

    private int availableSeats = 5;

    public synchronized void bookTickets(String userName, int seats) {

        System.out.println(userName + " requested " + seats + " seat(s).");

        if (seats <= availableSeats) {
            availableSeats -= seats;

            System.out.println(
                    "Booking Successful for " + userName
            );

            System.out.println(
                    "Seats Booked: " + seats
            );

            System.out.println(
                    "Remaining Seats: " + availableSeats
            );

        } else {
            System.out.println(
                    "Seats Not Available for " + userName
            );

            System.out.println(
                    "Available Seats: " + availableSeats
            );
        }

        System.out.println("-----------------------------");
    }
}

class UserThread extends Thread {

    private TicketBooking booking;
    private String userName;
    private int seats;

    UserThread(TicketBooking booking, String userName, int seats) {
        this.booking = booking;
        this.userName = userName;
        this.seats = seats;
    }

    @Override
    public void run() {
        booking.bookTickets(userName, seats);
    }
}

public class RailwayTicketBooking {

    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        UserThread user1 = new UserThread(
                booking, "Rahul", 2
        );

        UserThread user2 = new UserThread(
                booking, "Priya", 1
        );

        UserThread user3 = new UserThread(
                booking, "Aman", 2
        );

        UserThread user4 = new UserThread(
                booking, "Neha", 1
        );

        user1.start();
        user2.start();
        user3.start();
        user4.start();
    }
}
