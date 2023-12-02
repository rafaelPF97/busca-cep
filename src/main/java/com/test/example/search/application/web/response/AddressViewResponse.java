package com.test.example.search.application.web.response;

import com.test.example.search.domain.model.Address;

public record AddressViewResponse(
        String zipCode,
        String streetAddress,
        String complement,
        String district,
        String locality,
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
