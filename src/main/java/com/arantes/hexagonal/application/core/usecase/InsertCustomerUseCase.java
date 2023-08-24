package com.arantes.hexagonal.application.core.usecase;
import com.arantes.hexagonal.application.core.domain.Address;
import com.arantes.hexagonal.application.core.domain.Customer;
import com.arantes.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.arantes.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.arantes.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputport;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase (
            InsertCustomerOutputPort insertCustomerOutputport,
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort){

        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputport = insertCustomerOutputport;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode){
        Address address = findAddressByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputport.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }
}
