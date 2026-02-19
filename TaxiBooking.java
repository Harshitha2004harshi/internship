import java.util.*;

public class CallTaxiBooking {

    
    static class TaxiNotAvailableException extends Exception {
        TaxiNotAvailableException(String msg) {
            super(msg);
        }
    }

    static class TaxiOneNotAvailableException extends Exception {
        TaxiOneNotAvailableException(String msg) {
            super(msg);
        }
    }
    static class Booking {
        int bookingId, customerId, pickupTime, dropTime, amount;
        char from, to;

        Booking(int bid, int cid, char from, char to, int pt, int dt, int amt) {
            this.bookingId = bid;
            this.customerId = cid;
            this.from = from;
            this.to = to;
            this.pickupTime = pt;
            this.dropTime = dt;
            this.amount = amt;
        }
    }
    static class Taxi {
        int taxiId;
        char currentPoint = 'A';
        int freeTime = 0;
        int totalEarnings = 0;
        List<Booking> bookings = new ArrayList<>();

        Taxi(int id) {
            this.taxiId = id;
        }
    }

    static int bookingId = 1;
    static int calculateFare(char from, char to) {
        int distance = Math.abs(from - to) * 15;
        if (distance <= 5)
            return 100;
        return 100 + (distance - 5) * 10;
    }
    static Taxi bookTaxi(List<Taxi> taxis, int pickupTime, char pickupPoint)
            throws TaxiNotAvailableException, TaxiOneNotAvailableException {

        Taxi selected = null;
        int minDistance = Integer.MAX_VALUE;
        int minEarning = Integer.MAX_VALUE;

        for (Taxi t : taxis) {
            if (t.freeTime <= pickupTime) {
                int distance = Math.abs(t.currentPoint - pickupPoint);

                if (distance < minDistance ||
                        (distance == minDistance && t.totalEarnings < minEarning)) {
                    selected = t;
                    minDistance = distance;
                    minEarning = t.totalEarnings;
                }
            }
        }
        if (selected == null)
            throw new TaxiNotAvailableException("❌ No taxi available at this time");

        if (selected.taxiId == 1 && selected.freeTime > pickupTime)
            throw new TaxiOneNotAvailableException("❌ Taxi-1 is not available");

        return selected;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of taxis: ");
        int n = sc.nextInt();

        List<Taxi> taxis = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            taxis.add(new Taxi(i));

        while (true) {
            System.out.println("\n1. Book Taxi");
            System.out.println("2. Display Taxi Details");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Customer ID: ");
                        int cid = sc.nextInt();

                        System.out.print("Pickup Point: ");
                        char from = sc.next().charAt(0);

                        System.out.print("Drop Point: ");
                        char to = sc.next().charAt(0);

                        System.out.print("Pickup Time: ");
                        int pt = sc.nextInt();

                        Taxi taxi = bookTaxi(taxis, pt, from);

                        int travelTime = Math.abs(from - to);
                        int dropTime = pt + travelTime;
                        int amount = calculateFare(from, to);

                        taxi.freeTime = dropTime;
                        taxi.currentPoint = to;
                        taxi.totalEarnings += amount;

                        taxi.bookings.add(new Booking(
                                bookingId++, cid, from, to, pt, dropTime, amount));

                        System.out.println("✅ Taxi can be allotted");
                        System.out.println("🚕 Taxi-" + taxi.taxiId + " is allotted");

                    } catch (TaxiNotAvailableException | TaxiOneNotAvailableException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    for (Taxi t : taxis) {
                        System.out.println("\nTaxi-" + t.taxiId +
                                " Total Earnings: Rs." + t.totalEarnings);
                        System.out.println("BookingID CustomerID From To Pickup Drop Amount");

                        for (Booking b : t.bookings) {
                            System.out.println(
                                    b.bookingId + "        " +
                                    b.customerId + "        " +
                                    b.from + "    " +
                                    b.to + "   " +
                                    b.pickupTime + "     " +
                                    b.dropTime + "    " +
                                    b.amount);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
