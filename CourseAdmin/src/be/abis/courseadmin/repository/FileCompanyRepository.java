package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Company;
import be.abis.exception.CompanyNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCompanyRepository implements  CompanyRepository {

    private static final FileCompanyRepository repository = new FileCompanyRepository();      // singleton
                                                                // static variable of class, private constructor, getter
                                                                // lazy initialization: new when getter is called (if == null)
                                                                // @Component above class will make singleton in Spring
    private final String pathWay =  "company.txt";
    private final String companyNotFound = "Company not found";
    private List<Company> companies = new ArrayList<>();


    public FileCompanyRepository() {
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        for (Company company : companies) {
            if (id == company.getCompanyNumber()) return company;
        }
        throw new CompanyNotFoundException("Company not found by ID");
    }

    @Override
    public Company findCompany(String name) throws CompanyNotFoundException {
        try (BufferedReader reader = new BufferedReader(new FileReader(pathWay))) {
            String companyName;
            while ((companyName = reader.readLine()) != null) {     // readline can only be used once
                if (companyName.equalsIgnoreCase(name)) {           // every next use of readline, reads the next line
                    return new Company(companyName);                // messes up the company numbering system outside of DB
                }
            }
            } catch(IOException e){
                System.out.println(e.getMessage());
            }
        throw new CompanyNotFoundException(companyNotFound);
    }

    @Override
    public void addCompany(Company newCompany) {
        int numberOfCompanies = companies.size();
            try (PrintWriter writer = new PrintWriter(new PrintWriter(pathWay))) {
                for (Company company : companies) {
                    writer.write(company.getCompanyName() + "\n");
                }
                writer.append(newCompany.getCompanyName());                // .append and .write do similar things
                companies.add(newCompany);
         //       System.out.println("Number of companies: " + numberOfCompanies);

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

    }

    @Override
    public void updateCompany(Company company) throws CompanyNotFoundException {   // find by ID
        throw new CompanyNotFoundException(companyNotFound);
    }

    @Override
    public void deleteCompany(int id) throws CompanyNotFoundException {     // reset static COUNT
        throw new CompanyNotFoundException(companyNotFound);
    }


    public static FileCompanyRepository getRepository() {
        return repository;
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
