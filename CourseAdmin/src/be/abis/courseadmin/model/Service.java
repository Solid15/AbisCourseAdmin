package be.abis.courseadmin.model;

import be.abis.exception.PriceException;

public abstract class Service {

    protected abstract double calculatePrice() throws PriceException;
}
