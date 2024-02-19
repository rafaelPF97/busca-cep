package com.test.example.search.domain.usecase.getByCep.input;

public record GetAddressByZipCodeInput(
        String zipCode
) {

    public static GetAddressByZipCodeInput create(String cep) {
        return new GetAddressByZipCodeInput(cep);
    }
}
