package com.test.example.search.domain.gateway;

import com.test.example.search.domain.model.Address;

import java.util.Optional;


public interface AddressGateway {

    Optional<Address> findByZipCode(String zipCode);

    void saveSearch(Address address);
}
