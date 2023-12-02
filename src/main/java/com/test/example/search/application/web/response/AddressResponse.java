package com.test.example.search.application.web.response;

import com.test.example.search.domain.model.Address;

public record AddressResponse(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf

) {
    public static AddressResponse fromDomain(Address address
    ) {
        return new AddressResponse(
                address.getZipCode(),
                address.getStreetAddress(),
                address.getComplement(),
                address.getDistrict(),
                address.getLocality(),
                address.getUf()
        );
    }
}
