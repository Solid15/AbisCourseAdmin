package be.abis.coffee;

public abstract class Person {

    private String name;
    private Cup cup;

    public Person(String name) {
        this.name = name;
    }

    public Cup orderCoffee(CoffeeMachine coffeeMachine, String coffeeType, boolean milk, boolean sugar) {
        if (getCup() == null) {
            grabCup();
        }
        if (getCup().getFillable() != null) {
            getCup().getFillable().destroyItself(getCup().getFillable());
            System.out.println("Pouring content of cup away so that some new coffee can be ordered.");
        }
        getCup().setFillable(coffeeMachine.makeCoffee(coffeeType, milk, sugar));
        if (getCup().getFillable() != null) {
            System.out.println(getName() + " orders a coffee from the coffee machine and pours it into a cup.");
        }
        return cup;
    }

    public void aksForCoffee(Person myself, Person anotherPerson, CoffeeMachine coffeeMachine, String coffeeType, boolean milk, boolean sugar) {
        System.out.println(myself.getName() + " asks " + anotherPerson.getName() + " for coffee: " + coffeeType + ".");
        System.out.println("Milk wanted: " + milk + ". Sugar wanted: " + sugar + ".");
        anotherPerson.orderCoffee(coffeeMachine, coffeeType, milk, sugar);
        anotherPerson.giveCupTo(anotherPerson.getCup(), myself);
    }

    public void grabCup() {
        System.out.println(getName() + " takes a new cup.");
        setCup(new Cup());
    }

    public void giveCupTo(Cup cup, Person anotherPerson) {
        if (anotherPerson.getCup() != null) {
            System.out.println(anotherPerson.getName() + " throws existing cup away in order to receive a new cup from " + this.getName() +".");
        }
        System.out.println(this.getName() + " gives cup to " + anotherPerson.getName() +".");
        anotherPerson.setCup(cup);
        this.setCup(null);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Cup getCup() {
        return cup;
    }

    public void setCup(Cup cup) {
        this.cup = cup;
    }
}
