package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Company;
import be.abis.exception.CompanyNotFoundException;

import java.io.*;

public class FileCompanyRepository implements  CompanyRepository {

    private static final FileCompanyRepository repository = new FileCompanyRepository();      // singleton
                                                                // static variable of class, private constructor, getter
                                                                // lazy initialization: new when getter is called (if == null)
                                                                // @Component above class will make singleton in Spring
    private final String pathWay =  "company.txt";
    private final String companyNotFound = "Company not found";
   // private List<Company> companies;


    public FileCompanyRepository() {
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        boolean b = true;
        try (BufferedReader reader = new BufferedReader(new FileReader(pathWay))) {
            while (b) {
                if (findCompany(reader.readLine()).getCompanyNumber() == id) {
                    b = false;
                    System.out.println("Company ID found");
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        throw new CompanyNotFoundException(companyNotFound);
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
        System.out.println("Company not found by name");
        throw new CompanyNotFoundException(companyNotFound);
    }

    @Override
    public void addCompany(Company company) {
            try (PrintWriter writer = new PrintWriter(new PrintWriter(pathWay))) {

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        boolean b = false;
        String compToAdd = company.getCompanyName();
  /**      Iterator<Company> iteration = companies.iterator();   // how to set companies?
        try (PrintWriter writer = new PrintWriter(new FileWriter(pathWay, true)))  {
        while (iteration.hasNext()) {
            iteration.next();                   // is this correct?
            }
        writer.write(company.getCompanyName());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
 */   }

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
}
