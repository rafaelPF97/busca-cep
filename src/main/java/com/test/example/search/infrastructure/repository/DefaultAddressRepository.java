package com.test.example.search.infrastructure.repository;

import com.test.example.search.domain.entity.Address;
import com.test.example.search.domain.reposity.AddressRepository;
import com.test.example.search.infrastructure.repository.jpa.EnderecoEntity;
import com.test.example.search.infrastructure.repository.jpa.EnderecoJpa;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class DefaultAddressRepository implements AddressRepository {

    private final EnderecoJpa enderecoJpa;


    public DefaultAddressRepository(EnderecoJpa enderecoJpa) {
        this.enderecoJpa = enderecoJpa;

    }

    @Override
    public List<Address> findAll() {
        return enderecoJpa.findAll().stream().map(EnderecoEntity::toDomain).toList();
    }

    @Override
    public Optional<Address> findById(UUID id) {
        var entity = enderecoJpa.findById(id);

        if (entity.isPresent()) {
            var endereco = entity.get().toDomain();
            return Optional.of(endereco);
        }
        return Optional.empty();
    }

    @Cacheable("endereco")
    @Override
    public Optional<Address> findByCep(String cep) {
        var entity = enderecoJpa.findByCep(cep);

        if (entity.isPresent()) {
            var endereco = entity.get().toDomain();
            return Optional.of(endereco);
        }
        return Optional.empty();
    }

    @CacheEvict(value = "endereco", allEntries = true)
    @Override
    public void save(Address address) {
        enderecoJpa.save(EnderecoEntity.fromDomain(address));

    }

    @Override
    public void delete(Address address) {
        enderecoJpa.delete(EnderecoEntity.fromDomain(address));
    }

}
