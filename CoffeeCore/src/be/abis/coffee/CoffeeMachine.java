package be.abis.coffee;

public class CoffeeMachine {

    String[] coffeeTypes;
    boolean milkAvailable;
    boolean sugarAvailable;

    public CoffeeMachine(String[] coffeeTypes, boolean milkAvailable, boolean sugarAvailable) {
        this.coffeeTypes = coffeeTypes;
        this.milkAvailable = milkAvailable;
        this.sugarAvailable = sugarAvailable;
    }

    public Coffee makeCoffee(String typeOfCoffee, boolean milkWanted, boolean sugarWanted) {
        boolean coffeeTypeAvailable = false;
        for (String coffeeType :  coffeeTypes) {
            if (coffeeType.equals(typeOfCoffee.toLowerCase())) {
                coffeeTypeAvailable = true; break;
            }
        }

        if (!coffeeTypeAvailable) {
            System.out.println("This coffeetype is not available. Coffee cannot be made.");
            return null;
        }

        if (!milkAvailable) { milkWanted = false;
            System.out.println("No milk available"); }
        if (!sugarAvailable) { sugarWanted = false;
            System.out.println("No sugar available"); }

        return new Coffee(typeOfCoffee, milkWanted, sugarWanted);
    }

    public String[] getCoffeeTypes() {
        return coffeeTypes;
    }

    public void setCoffeeTypes(String[] coffeeTypes) {
        this.coffeeTypes = coffeeTypes;
    }

    public boolean isMilkAvailable() {
        return milkAvailable;
    }

    public void setMilkAvailable(boolean milkAvailable) {
        this.milkAvailable = milkAvailable;
    }

    public boolean isSugarAvailable() {
        return sugarAvailable;
    }

    public void setSugarAvailable(boolean sugarAvailable) {
        this.sugarAvailable = sugarAvailable;
    }
}
