//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RentalAgency agency = new RentalAgency();

        // Create vehicles
        Car car = new Car("CR0353", " Honda HR-V " , 50.0);
        Truck truck = new Truck(50.0, true, 15.0, "TUK002", "Ford F-150", 40.0);
        Motorcycle motorcycle = new Motorcycle("MT2204", "Royal", 30.0);

        // Add vehicles to the agency fleet
        agency.addVehicle(car);
        agency.addVehicle(truck);
        agency.addVehicle(motorcycle);

        // Create a customer
        Customer customer = new Customer("CUS001", "Harrison");
        // Process rentals
        agency.processRental(car, customer, 3);
        agency.processRental(truck, customer, 4);
        agency.processRental(motorcycle, customer, 2);

        // Rental details
        System.out.println("\nRental History for " + customer.getName() + ":");
        for (Vehicle vehicle : customer.getRentalHistory()) {
            System.out.println(vehicle.getModel() + " - Rental Cost: $" + vehicle.calculateRentalCost(5));
        }

        // Return vehicle
        agency.returnVehicle(truck);

        // Availability after return
        System.out.println(
                "\nAvailability after truck has been returned: " + (truck.isAvailableForRental() ? "Available" : "Not Available"));

        // Generating a report
        agency.generateReport();
    }
}