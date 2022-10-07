package be.abis.courseadmin.service;

import be.abis.courseadmin.model.Company;
import be.abis.courseadmin.repository.MemoryListCompanyRepository;

import java.util.Collections;
import java.util.List;

public class AbisCompanyService implements CompanyService {

    private MemoryListCompanyRepository companyRepository;

    @Override
    public List<Company> sortAllCompaniesByName() {
        List<Company> companies = companyRepository.getCompanies();
        Collections.sort(companies);            //  void return from sort method
        return companies;
    }

    @Override
    public List<Company> sortAllCompaniesByNumber() {
        return null;
    }







    public MemoryListCompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    public void setCompanyRepository(MemoryListCompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }
}
