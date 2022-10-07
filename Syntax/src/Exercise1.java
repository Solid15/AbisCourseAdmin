public class Exercise1 {

    public static void main(String[] args) {

        String firstName = "Bob";
        int age = 43;
        double grossMonthlySalary = 3216.54;
        boolean senior = false;
        Gender gender = Gender.MALE;

        String personalPronoun = "";
        String possessivePronoun = "";
        String reflexivePronoun = "";

        switch(gender) {
            case MALE       : personalPronoun = "He"; possessivePronoun = "his"; reflexivePronoun = "himself"; break;
            case FEMALE     : personalPronoun = "She"; possessivePronoun = "her"; reflexivePronoun = "herself"; break;
            case OTHER      : personalPronoun = "They"; possessivePronoun = "their"; reflexivePronoun = "themselve"; break;
     //     default         : personalPronoun = "They";                // used
        }

        System.out.println(firstName + " is " + age + " years old. Gross Salary is " + grossMonthlySalary +
                ". " + personalPronoun + " is " + (senior ? "a senior." : "not a senior."));

        double netSalary =  (grossMonthlySalary/100)*(100-48);
        System.out.println("Net salary is " + netSalary);
        System.out.println("Income-dependant net salary is " + calculateNetSalary(grossMonthlySalary));

        double ageRelatedSalary = 2700.0;
        int startingAge = 23;
        int seniority = -2;

        while (startingAge <= age) {
            System.out.println(firstName + "'s net salary at " + startingAge + " is " + calculateNetSalary(ageRelatedSalary));
            if (seniority <= 35) { ageRelatedSalary = ageRelatedSalary * 1.05; }
            startingAge++; startingAge++;
            seniority++; seniority++;
        }
        System.out.println("Current Seniority is " + seniority);

        System.out.println("\nNow try it with a for!\n");

        ageRelatedSalary = 2700.0;
        seniority = -2;

        for (startingAge=23 ; startingAge <= age ; startingAge= startingAge+2) {
            System.out.println(firstName + "'s net salary at " + startingAge + " is " + calculateNetSalary(ageRelatedSalary));
            if (seniority <= 35) { ageRelatedSalary = ageRelatedSalary * 1.05; }
            seniority++; seniority++;
        }

        System.out.println("Check: current seniority at company is " + seniority);

        int[] numbers = {5, 7, 6};
        String words[] =  new String[5];
        String[] domains = {"ABIS", "Java", "Oracle"};

        for (String domain : domains) {
            System.out.println(domain + " ");
        }
        System.out.println(domains.length);         // length is a variable of an array, a method() of a string





    }

    public static double calculateNetSalary(double grossSalary) {
        double netSalary;
        if (grossSalary*12 < 13870) {                           // make variable taxRate and calculate netSalary seperately
            netSalary = grossSalary/100 * (100-25);
        } else if (grossSalary*12 < 24480) {
            netSalary = grossSalary/100 * (100-40);
        } else if (grossSalary*12 < 42370) {
            netSalary = grossSalary/100 * (100-45);
        } else {
            netSalary = grossSalary/100 * (100-50);
        }
        return netSalary;
    }
}
