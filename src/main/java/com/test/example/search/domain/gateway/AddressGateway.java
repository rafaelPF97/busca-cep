package com.test.example.search.domain.gateway;

import com.test.example.search.domain.entity.Address;

import java.util.Optional;


public interface AddressGateway {

    Optional<Address> findByCep(String cep);

    void saveSearch(Address address);
}
