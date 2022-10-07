package be.abis.unittesting;

import be.abis.coffee.CoffeeMachine;
import be.abis.coffee.Cup;
import be.abis.coffee.Instructor;
import be.abis.coffee.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person person;
    private CoffeeMachine coffeeMachine;
    private String coffeeType;
    String[] coffeeTypes = {"black", "latté", "latte", "strong", "basic", "tea"};

    @BeforeEach
    public void setup() throws Exception {
        person = new Instructor("Sandy");
        coffeeMachine = new CoffeeMachine(coffeeTypes, true, true);
        coffeeType = "BLaCk";
    }

    @AfterEach
    public void tearDown() throws Exception {
        person = null;
        coffeeMachine = null;
        coffeeType = null;
    }

    @Test
    public void testOrderCoffee() {
  //      assertEquals();
    }


}