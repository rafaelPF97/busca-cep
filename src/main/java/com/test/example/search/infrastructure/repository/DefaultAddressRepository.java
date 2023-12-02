package com.test.example.search.infrastructure.repository;

import com.test.example.search.domain.entity.Address;
import com.test.example.search.domain.reposity.AddressRepository;
import com.test.example.search.infrastructure.repository.jpa.AddressEntity;
import com.test.example.search.infrastructure.repository.jpa.AddressJpa;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DefaultAddressRepository implements AddressRepository {

    private final AddressJpa addressJpa;


    public DefaultAddressRepository(AddressJpa addressJpa) {
        this.addressJpa = addressJpa;

    }

    @Override
    public List<Address> findAll() {
        return addressJpa.findAll().stream().map(AddressEntity::toDomain).toList();
    }

    @Override
    public Optional<Address> findById(UUID id) {
        var entity = addressJpa.findById(id.toString());

        if (entity.isPresent()) {
            var address = entity.get().toDomain();
            return Optional.of(address);
        }
        return Optional.empty();
    }

    @Cacheable("address")
    @Override
    public Optional<Address> findByZipCode(String zipCode) {
        var entity = addressJpa.findByZipCode(zipCode);

        if (entity.isPresent()) {
            var address = entity.get().toDomain();
            return Optional.of(address);
        }
        return Optional.empty();
    }

    @CacheEvict(value = "address", allEntries = true)
    @Override
    public void save(Address address) {
        addressJpa.save(AddressEntity.fromDomain(address));

    }

    @Override
    public void delete(Address address) {
        addressJpa.delete(AddressEntity.fromDomain(address));
    }

}
