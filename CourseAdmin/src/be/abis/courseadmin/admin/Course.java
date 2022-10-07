package be.abis.courseadmin.admin;

public class Course {

    private String title;
    private int numberOfDays;
    private double pricePerDay;

    public Course(String title, int numberOfDays, double pricePerDay) {
        this.title = title;
        this.numberOfDays = numberOfDays;
        this.pricePerDay = pricePerDay;
    }

    public void printInfo() {
        System.out.println("be.abis.course.Course: " + title + "\nDuration: " + numberOfDays + " days\nPrice per day: " + pricePerDay);
    }

    public double calculateTotalPrice() {
        return numberOfDays*pricePerDay;
    }

    public double calculateTotalPrice(int reductionPercentage) {
        if (reductionPercentage > 100)  { reductionPercentage = 100; }
        if (reductionPercentage < 0)     { reductionPercentage = 0; }
        return calculateTotalPrice()*(100-reductionPercentage)/100;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}



// varargs  - variable multiple arguments