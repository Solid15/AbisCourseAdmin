package be.abis.original;

public class Executable {

    public static void main(String[] args) {
        System.out.println("Hello from IntelliJ");

        Person p1 = new Person();
        p1.firstName="Sandy";
        p1.age=42;

        p1.walk(5);

        Person p2 = new Person();
        p2.firstName = "James";

        Coffee coffee = p2.getCoffee("black");
        p1.drinkCoffee(coffee);

        Company c1 = new Company();
        c1.name = "Abis";

        p1.company = c1;

        System.out.println(p1.company.name);

        Instructor i1 = new Instructor();

        i1.firstName = "Peter";

        i1.teach();
        System.out.println("-------------");
        i1.walk(5);

        Person[] persons = {p1, i1};
        for (Person p : persons) {
            p.walk(5);
        }

        int km = 40;

        if (p1.firstName.equals("Sandy")) {
            System.out.println("ok");
        } else {
            System.out.println("too far");
        }


    }
}
