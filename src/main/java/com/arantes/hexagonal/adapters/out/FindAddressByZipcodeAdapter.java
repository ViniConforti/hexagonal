package com.arantes.hexagonal.adapters.out;

import com.arantes.hexagonal.adapters.out.client.FindAddressByZipcodeClient;
import com.arantes.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.arantes.hexagonal.adapters.out.client.response.AddressResponse;
import com.arantes.hexagonal.application.core.domain.Address;
import com.arantes.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindAddressByZipcodeAdapter implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipcodeClient findAddressByZipcodeClient;
    private final AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipcode) {
        AddressResponse addressResponse = findAddressByZipcodeClient.find(zipcode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
