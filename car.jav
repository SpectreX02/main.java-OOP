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

    public Car(String brand, String model, String color, int year,
               double price, int speed, boolean engineStatus) {
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