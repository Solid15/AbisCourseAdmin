package be.abis.courseadmin.model;

public class Company implements Comparable<Company> {

    private static int count;

    private String companyName;
    private int companyNumber;

    public Company(String companyName) {
        this.companyName = companyName;
        count++;
        companyNumber = count;
    }

    @Override
    public int compareTo(Company company) {
        // company.getCompanyName().compareTo(this.getCompanyName());           // reverse alphabetical order
        return this.getCompanyName().compareTo(company.getCompanyName());       // alphabetical order
    }

    @Override
    public String toString() {
        return getCompanyName();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Company.count = count;
    }

    public int getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(int companyNumber) {
        this.companyNumber = companyNumber;
    }
}
