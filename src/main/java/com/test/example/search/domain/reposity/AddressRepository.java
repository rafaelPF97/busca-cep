package com.test.example.search.domain.reposity;

import com.test.example.search.domain.entity.Address;

import java.util.List;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepository {

    List<Address> findAll();

    Optional<Address> findById(UUID id);

    Optional<Address> findByZipCode(String zipCode);

    void save(Address address);

    void delete(Address address);
}
