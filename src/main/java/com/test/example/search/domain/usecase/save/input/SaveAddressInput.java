package com.test.example.search.domain.usecase.save.input;

public record SaveAddressInput(
        String zipCode,
        String streetAddress,
        String complement,
        String district,
        String locality,
        String uf,
        Long views
) {
}
