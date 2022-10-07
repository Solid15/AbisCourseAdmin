package be.abis.courseadmin.repository;

import be.abis.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

public class MemoryArrayCompanyRepository implements CompanyRepository {

    private Company[] companies = new Company[5];

    public MemoryArrayCompanyRepository() {
        companies[0] = new Company("SMALS");
        companies[1] = new Company("Egov Select");
        companies[2] = new Company("ABIS");
        companies[3] = new Company("IBM");
        companies[4] = new Company("TTL");
    }

    @Override
    public Company findCompany(int id) throws CompanyNotFoundException {
        for (Company company: companies) {
            if (company.getCompanyNumber() == id) {
                return company;
            }
        }
        throw new CompanyNotFoundException("Company noy found");
    }

    @Override
    public Company findCompany(String name) {
        for (Company company: companies) {
            if (company.getCompanyName().equals(name)) {
                return company;
            }
        }
        System.out.println("Company not found"); return null;
    }

    @Override
    public void addCompany(Company company) {

    }

    @Override
    public void updateCompany(Company company) {

    }

    @Override
    public void deleteCompany(int id) {

    }

    public Company[] getCompanies() {
        return companies;
    }

    public void setCompanies(Company[] companies) {
        this.companies = companies;
    }
}
