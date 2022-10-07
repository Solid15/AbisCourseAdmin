package be.abis.original;

public class Person {

    String firstName;
    int age;
    Company company;

    public void walk(int km){
        System.out.println(firstName + " is walking for " + km + " kms.");
    }

    public Coffee getCoffee(String type) {
      return new Coffee();
    }

    public void drinkCoffee(Coffee c) {

    }
}
