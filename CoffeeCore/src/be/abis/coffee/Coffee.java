package be.abis.coffee;

public class Coffee implements Fillable {

    private final String typeOfCoffee;
    private boolean milkAdded;
    private boolean sugarAdded;

    public Coffee(String typeOfCoffee, boolean milkAdded, boolean sugarAdded) {
        this.typeOfCoffee = typeOfCoffee;
        this.milkAdded = milkAdded;
        this.sugarAdded = sugarAdded;
    }

    @Override
    public void drink(Person person, Fillable coffee) {
            System.out.println(person.getName() + " is drinking coffee.");
            destroyItself(coffee);
    }


    public void addMilk() {
        milkAdded = true;
    }

    public void addSugar() {
        sugarAdded = true;
    }

    public String getTypeOfCoffee() {
        return typeOfCoffee;
    }

    public boolean isMilkAdded() {
        return milkAdded;
    }

    public boolean isSugarAdded() {
        return sugarAdded;
    }

}

