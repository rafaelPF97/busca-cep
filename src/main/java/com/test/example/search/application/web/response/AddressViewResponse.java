package com.test.example.search.application.web.response;

import com.test.example.search.domain.entity.Address;

public record AddressViewResponse(

        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        Long views

) {


    public static AddressViewResponse fromDomain(Address address) {
        return new AddressViewResponse(
                address.getZipCode(),
                address.getStreetAddress(),
                address.getComplement(),
                address.getDistrict(),
                address.getLocality(),
                address.getUf(),
                address.getViews()
        );
    }
}
