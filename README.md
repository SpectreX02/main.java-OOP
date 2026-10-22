PART 1

public class Car {

    private String brand;
    private String model;
    private String color;
    private int year;
    private double price;
    private int speed;
    private boolean engineStatus;

    public Car() {
        brand = "Toyota";
        model = "Vios";
        color = "White";
        year = 2020;
        price = 50000.00;
        speed = 0;
        engineStatus = false;
    }

    public Car(String brand, String model, String color, int year, double price, int speed, boolean engineStatus) {

        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.price = price;
        this.speed = speed;
        this.engineStatus = engineStatus;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }

    public boolean getEngineStatus() {
        return engineStatus;
    }

    public void setEngineStatus(boolean engineStatus) {
        this.engineStatus = engineStatus;
    }

    public void startEngine() {
        engineStatus = true;
        System.out.println("Car engine started.");
    }

    public void accelerate() {
        if (engineStatus) {
            speed += 10;
            System.out.println("Car speed: " + speed + " km/h");
        } else {
            System.out.println("Please start the engine first.");
        }
    }

    public void brake() {
        if (speed >= 10) {
            speed -= 10;
        } else {
            speed = 0;
        }

        System.out.println("Car speed after braking: " + speed + " km/h");
    }
}




PART 2

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Car car1 = new Car();
        Car car2 = new Car("Honda", "Civic", "Black",
                2023, 95000.00, 0, false);

        System.out.println("=== Car Management System ===");

        System.out.println("\nCar 1 Details:");
        displayCar(car1);

        System.out.println("\nCar 2 Details:");
        displayCar(car2);

        System.out.println("\nChoose a car:");
        System.out.println("1. Toyota Vios");
        System.out.println("2. Honda Civic");
        System.out.print("Enter your choice: ");
        int carChoice = input.nextInt();

        Car selectedCar;

        switch (carChoice) {
            case 1:
                selectedCar = car1;
                System.out.println("You selected Toyota Vios.");
                break;

            case 2:
                selectedCar = car2;
                System.out.println("You selected Honda Civic.");
                break;

            default:
                selectedCar = car1;
                System.out.println("Invalid choice. Toyota Vios selected.");
        }

        int choice;

        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Show car details");
            System.out.println("2. Start engine");
            System.out.println("3. Accelerate");
            System.out.println("4. Brake");
            System.out.println("5. Accelerate three times");
            System.out.println("6. Change car details");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    displayCar(selectedCar);
                    break;

                case 2:
                    selectedCar.startEngine();
                    break;

                case 3:
                    selectedCar.accelerate();
                    break;

                case 4:
                    selectedCar.brake();
                    break;

                case 5:
                    for (int i = 1; i <= 3; i++) {
                        System.out.println("Acceleration " + i);
                        selectedCar.accelerate();
                    }
                    break;

                case 6:
                    input.nextLine();

                    System.out.print("Enter new colour: ");
                    String colour = input.nextLine();
                    selectedCar.setColor(colour);

                    System.out.print("Enter new price: RM");
                    double price = input.nextDouble();

                    if (price >= 0) {
                        selectedCar.setPrice(price);
                        System.out.println("Car details updated.");
                    } else {
                        System.out.println("Price cannot be negative.");
                    }

                    System.out.println("New colour: "
                            + selectedCar.getColor());
                    System.out.printf("New price: RM%.2f%n",
                            selectedCar.getPrice());
                    break;

                case 7:
                    System.out.println("Thank you. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 7);

        input.close();
    }

    public static void displayCar(Car car) {

        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Colour: " + car.getColor());
        System.out.println("Year: " + car.getYear());
        System.out.printf("Price: RM%.2f%n", car.getPrice());
        System.out.println("Speed: " + car.getSpeed() + " km/h");

        if (car.getEngineStatus()) {
            System.out.println("Engine: Running");
        } else {
            System.out.println("Engine: Stopped");
        }
    }
}
