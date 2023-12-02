package com.test.example.search.domain.usecase.getByCep;

import com.test.example.search.domain.entity.Address;
import com.test.example.search.domain.exception.CepNotFoundException;
import com.test.example.search.domain.gateway.AddressGateway;
import com.test.example.search.domain.usecase.getByCep.input.GetEnderecoByCepInput;
import com.test.example.search.domain.usecase.shared.UseCase;

public class GetAddressByCep extends UseCase<GetEnderecoByCepInput, Address> {

    private final AddressGateway gateway;

    public GetAddressByCep(AddressGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public Address execute(GetEnderecoByCepInput getEnderecoByCepInput) {
        Address address = gateway.findByCep(getEnderecoByCepInput.getCep()).orElseThrow(
                () -> new CepNotFoundException(getEnderecoByCepInput.getCep())
        );

        gateway.saveSearch(address);
        return address;
    }


}
