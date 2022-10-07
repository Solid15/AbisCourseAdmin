package be.abis.coffee;

public class Instructor  extends Person {

    public Instructor(String name) {
        super(name);
    }

    public void teach() {
        System.out.println("Instructor is teaching.");
    }
}
