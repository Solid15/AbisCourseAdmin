package be.abis.coffee;

public class MainMethod {
                                                           // exception handling required
    public static void main(String... args) {

        String[] coffeeTypes = {"black", "latté", "latte", "strong", "basic", "tea"};
        CoffeeMachine coffeeMachine = new CoffeeMachine(coffeeTypes,true, true);

        Instructor instructor = new Instructor("Sandy");
        Student student = new Student("Kim");

        instructor.grabCup();
        instructor.aksForCoffee(instructor, student, coffeeMachine, "Latté", false, true);
        instructor.getCup().getFillable().drink(instructor, instructor.getCup().getFillable());

        System.out.println();
        student.orderCoffee(coffeeMachine, "blAcK", false, true);
        student.orderCoffee(coffeeMachine, "blAcK", false, true);

        System.out.println();
        instructor.aksForCoffee(instructor, student, coffeeMachine, "Starbucks SuperDeluxe", true, true);
        instructor.getCup().getFillable().drink(instructor, instructor.getCup().getFillable());  // NULLPOINTER EXCEPTION handling

    }
}
