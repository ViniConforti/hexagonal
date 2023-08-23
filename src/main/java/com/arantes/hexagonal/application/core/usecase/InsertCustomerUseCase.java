package com.arantes.hexagonal.application.core.usecase;
import com.arantes.hexagonal.application.core.domain.Address;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputport;

    public InsertCustomerUseCase (
            InsertCustomerOutputPort insertCustomerOutputport,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort){

        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputport = insertCustomerOutputport;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputport.insert(customer);
    }
}
