package be.abis.courseadmin.repository;

import be.abis.exception.CompanyAlreadyExistsException;
import be.abis.exception.CompanyNotFoundException;
import be.abis.courseadmin.model.Company;

public interface CompanyRepository {

    Company findCompany(int id) throws CompanyNotFoundException;
    Company findCompany(String name) throws CompanyNotFoundException;
    void addCompany(Company company) throws CompanyAlreadyExistsException;
    void updateCompany(Company company) throws CompanyNotFoundException;
    void deleteCompany(int id) throws CompanyNotFoundException;

}
