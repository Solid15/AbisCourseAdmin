package be.abis.syntax;

public class Syntax2 {

    public static void main(String[] args) {

            int i = 1;
            if (++i == 1) {System.out.println("one");
            } else if (i==2) {
                System.out.println("two");
            } else System.out.println("other");

            boolean b = false;
            if (b=true) System.out.println("true"); else System.out.println("false");

            String name = "Lion";
            int score = 100;
            if (!name.equals("Lion")) score = 200; name = "Larry";
        System.out.println(name + " has score " + score);   // Larry has score 100

      //  int i = 0; if (i=10) {System.out.println("ten"); }
        System.out.println();

        short x = 5;
        switch (x) {
            case 4: System.out.println("four");
            case 5: System.out.println("five");
            case 6: System.out.println("six");
            default: System.out.println("other");     // five six other
        }

        /*
        String x1 = "5";
        switch (x1) {
            case 4: System.out.println("four");
            case 5: System.out.println("five");
            case 6: System.out.println("six");
            default: System.out.println("other");
        }        */

        System.out.println();
        String x1 = "five";
        switch (x1) {
            case "four": System.out.println("four"); break;
            case "five": System.out.println("five"); break;
            case "six": System.out.println("six"); break;
            default: System.out.println("other"); break;
            }
        System.out.println();
        switch (x1) {
            case "four": System.out.println("four"); break;
            default: System.out.println("other"); break;
            case "five": System.out.println("five"); break;
            case "six": System.out.println("six"); break;
        }
        System.out.println();

        x= 5; i = 6;     // (short x; int i)
        switch (x) {                                            // five six short  ==>> compile error int into short
            case 4: System.out.println("four");
            case 5: System.out.println("five");
  //          case i: System.out.println("six");
            default: System.out.println("other");
        }


    }
}
