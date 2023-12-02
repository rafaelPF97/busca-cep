package com.test.example.search.domain.usecase.update.input;

public record UpdateInput(
        String zipCode,
        String streetAddress,
        String complement,
        String district,
        String locality,
        String uf,
        Long views
) {

}
