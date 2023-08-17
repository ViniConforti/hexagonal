package com.arantes.hexagonal.application.core.usecase;
import com.arantes.hexagonal.application.core.domain.Address;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.InsertCustomerOutputport;

public class InsertCustomerUseCase {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputport insertCustomerOutputport;

    public InsertCustomerUseCase (
            InsertCustomerOutputport insertCustomerOutputport,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort){

        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputport = insertCustomerOutputport;
    }

    public void insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputport.insert(customer);
    }
}
