package com.test.example.search.infrastructure.gateway;

import com.test.example.search.domain.model.Address;
import com.test.example.search.domain.gateway.AddressGateway;
import com.test.example.search.infrastructure.client.ViaCepClient;
import com.test.example.search.infrastructure.entity.AddressEntity;
import com.test.example.search.infrastructure.repository.jpa.AddressJpa;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AddressGatewayImpl implements AddressGateway {

    private final AddressJpa addressJpa;
    private final ViaCepClient client;

    public AddressGatewayImpl(AddressJpa addressJpa, ViaCepClient client) {
        this.addressJpa = addressJpa;
        this.client = client;
    }

    @Cacheable("address")
    @Override
    public Optional<Address> findByCep(String cep) {
        System.out.println("Buscando no banco");
        var addressDTO = client.buscarEndereco(cep);
        if (addressDTO.getErro()) {
            return Optional.empty();
        }
        return Optional.of(addressDTO.toDomain());

    }
    @Override
    public void saveSearch(Address address) {
        var addressFound = addressJpa.findByZipCode(address.getZipCode());
        if(addressFound.isPresent()) {
            var addressDomain = addressFound.get().toDomain();
            addressDomain.incrementViews();
            addressJpa.save(AddressEntity.fromDomain(addressDomain));
        }
        else {
            address.incrementViews();
            addressJpa.save(AddressEntity.fromDomain(address));
        }

    }
}
