package com.test.example.search.domain.usecase.getByCep.input;

public record GetAddressByZipCodeInput(
        String cep
) {

    public static GetAddressByZipCodeInput create(String cep) {
        return new GetAddressByZipCodeInput(cep);
    }
}
