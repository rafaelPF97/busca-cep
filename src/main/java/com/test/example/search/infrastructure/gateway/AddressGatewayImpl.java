package com.test.example.search.infrastructure.gateway;

import com.test.example.search.domain.entity.Address;
import com.test.example.search.domain.gateway.AddressGateway;
import com.test.example.search.infrastructure.client.ViaCepClient;
import com.test.example.search.infrastructure.repository.jpa.EnderecoEntity;
import com.test.example.search.infrastructure.repository.jpa.EnderecoJpa;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AddressGatewayImpl implements AddressGateway {

    private final EnderecoJpa enderecoJpa;
    private final ViaCepClient client;

    public AddressGatewayImpl(EnderecoJpa enderecoJpa, ViaCepClient client) {
        this.enderecoJpa = enderecoJpa;
        this.client = client;
    }

    @Cacheable("endereco")
    @Override
    public Optional<Address> findByCep(String cep) {
        System.out.println("Buscando no banco");
        var enderecoDTO = client.buscarEndereco(cep);
        if (enderecoDTO.getErro()) {
            return Optional.empty();
        }
        return Optional.of(enderecoDTO.toDomain());

    }
    @Override
    public void saveSearch(Address address) {
        var enderecoFound = enderecoJpa.findByCep(address.getZipCode());
        if(enderecoFound.isPresent()) {
            var enderecoDomain = enderecoFound.get().toDomain();
            enderecoDomain.incrementViews();
            enderecoJpa.save(EnderecoEntity.fromDomain(enderecoDomain));
        }
        else {
            address.incrementViews();
            enderecoJpa.save(EnderecoEntity.fromDomain(address));
        }

    }
}
