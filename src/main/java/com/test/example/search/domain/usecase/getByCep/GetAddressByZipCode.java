package com.test.example.search.domain.usecase.getByCep;

import com.test.example.search.domain.model.Address;
import com.test.example.search.domain.exception.ZipCodeNotFoundException;
import com.test.example.search.domain.gateway.AddressGateway;
import com.test.example.search.domain.usecase.getByCep.input.GetAddressByZipCodeInput;
import com.test.example.search.domain.usecase.shared.UseCase;

public class GetAddressByZipCode extends UseCase<GetAddressByZipCodeInput, Address> {

    private final AddressGateway gateway;

    public GetAddressByZipCode(AddressGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Address execute(GetAddressByZipCodeInput getAddressByZipCodeInput) {
        Address address = gateway.findByZipCode(getAddressByZipCodeInput.zipCode()).orElseThrow(
                () -> new ZipCodeNotFoundException(getAddressByZipCodeInput.zipCode())
        );

        gateway.saveSearch(address);
        return address;
    }


}
