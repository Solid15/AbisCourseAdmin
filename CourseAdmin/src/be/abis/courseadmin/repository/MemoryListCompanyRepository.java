package be.abis.courseadmin.repository;

import be.abis.courseadmin.model.Company;
import be.abis.exception.CompanyNotFoundException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemoryListCompanyRepository implements CompanyRepository {

    private List<Company> companies = new ArrayList<>();

    public MemoryListCompanyRepository() {
        companies.add(new Company("ABIS"));
        companies.add(new Company("SMALS"));
        companies.add(new Company("EGOV SELECT"));
        companies.add(new Company("TTL"));
        companies.add(new Company("IBM"));
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        return companies.get(id);
    }

    @Override
    public Company findCompany(String name) {
        Iterator<Company> iteration = companies.iterator();             // Iterator better than for-loop
        while (iteration.hasNext()) {
            if (iteration.next().getCompanyName().equals(name)) {
                return iteration.next();
            }
        }
        System.out.println("Please throw a company-not-found exception");
        return null;
    }

    @Override
    public void addCompany(Company company) {
        companies.add(company);
    }

    @Override
    public void updateCompany(Company company) throws CompanyNotFoundException {
        findCompany(company.getCompanyNumber()).setCompanyName(company.getCompanyName());
    }                                               // weird - isn't this companies name already modified ???

    @Override
    public void deleteCompany(int id) throws CompanyNotFoundException {
        companies.remove(findCompany(id));
    }


    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
