package com.test.example.search.application.web.response;

import com.test.example.search.domain.model.Address;

public record AddressResponse(
        String zipCode,
        String StreetAddress,
        String complement,
        String district,
        String locality,
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
