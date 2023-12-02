package com.test.example.search.domain.usecase.getAll;

import com.test.example.search.domain.entity.Address;
import com.test.example.search.domain.reposity.AddressRepository;
import com.test.example.search.domain.usecase.shared.NoParams;
import com.test.example.search.domain.usecase.shared.UseCase;

import java.util.List;


public class GetAllAddresses extends UseCase<NoParams, List<Address>> {

    private final AddressRepository addressRepository;

    public GetAllAddresses(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> execute(NoParams noParams) {
        return addressRepository.findAll();
    }
}

