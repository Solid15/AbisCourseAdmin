package be.abis.unittesting;


import be.abis.courseadmin.repository.MemoryArrayCompanyRepository;
import be.abis.exception.CompanyNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MemoryArrayCompanyRepositoryTest {

    // AAA design   -   Arrange, Act, Assert
    private MemoryArrayCompanyRepository macr;

    @BeforeEach
    public void setUp() {
        macr = new MemoryArrayCompanyRepository();
    }

    @AfterEach
    public void tearDown() {
        macr = null;
    }

    @Test
    public void testTheArrayLength() {
        assertEquals (5, macr.getCompanies().length);
    }

    @Test                                   // STATIC COUNT problem unless testFindCompanyById() goes first
    public void testFindCompanyById() throws CompanyNotFoundException{
            assertEquals(4, macr.findCompany(4).getCompanyNumber());
            assertThrows(CompanyNotFoundException.class , () -> macr.findCompany(10));
       //     assertDoesNotThrow(() -> macr.findCompany(10));    // check it it never throws any kind of Exception
    }

    @Test
    public void testFindCompanyByName() {
        assertEquals("IBM", macr.findCompany("IBM").getCompanyName());
    }
/*
    @Test
    public void testFindCompanyByNonexistentName() {                   // MUST CATCH NullPointerException first
        assertNull(macr.findCompany("Colruyt").getCompanyName());
    }

 */
}