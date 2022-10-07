package be.abis.original;

public class Instructor extends Person {

    double salary;

    public void teach() {
        System.out.println(firstName + " is teaching.");
    }

    public void walk(int km) {
        super.walk(km);
        System.out.println("Teacher is walking an extra mile.");
    }
}
