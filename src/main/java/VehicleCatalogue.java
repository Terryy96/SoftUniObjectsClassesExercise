import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    public static class Vehicle {

        private String type;
        private String model;
        private String color;
        private double horsepower;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public double getHorsepower() {
            return horsepower;
        }

        public void setHorsepower(double horsepower) {
            this.horsepower = horsepower;
        }

        public Vehicle(String type, String model, String color, double horsepower) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.horsepower = horsepower;
        }


        @Override
        public String toString() {
            String vehicleType = type.equalsIgnoreCase("car") ? "Car" : "Truck";
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %.0f",
                    vehicleType, model, color, horsepower);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();

        while (!command.equals("End")) {

            String[] elements = command.split(" ");
            String type = elements[0];
            String model = elements[1];
            String color = elements[2];
            double horsepower = Double.parseDouble(elements[3]);

            Vehicle vehicle = new Vehicle(type, model, color, horsepower);
            vehicles.add(vehicle);

            command = scanner.nextLine();

        }

        command = scanner.nextLine();
        while (!command.equals("Close the Catalogue")) {
            String requestedModel = command;

            for (Vehicle vehicle : vehicles) {
                if (vehicle.getModel().equals(requestedModel)) {
                    System.out.println(vehicle);
                    break;
                }
            }

            command = scanner.nextLine();
        }

        printAverageHorsepower(vehicles, "car");
        printAverageHorsepower(vehicles, "truck");
    }

    // Helper method to calculate and print average horsepower
    private static void printAverageHorsepower(List<Vehicle> vehicles, String type) {
        double totalHorsepower = 0;
        int count = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equalsIgnoreCase(type)) {
                totalHorsepower += vehicle.getHorsepower();
                count++;
            }
        }

        if (count > 0) {
            double averageHorsepower = totalHorsepower / count;
            System.out.printf("%s have average horsepower of: %.2f.%n",
                    type.equalsIgnoreCase("car") ? "Cars" : "Trucks", averageHorsepower);
        } else {
            System.out.printf("%s have average horsepower of: 0.00.%n",
                    type.equalsIgnoreCase("car") ? "Cars" : "Trucks");
        }
    }
}