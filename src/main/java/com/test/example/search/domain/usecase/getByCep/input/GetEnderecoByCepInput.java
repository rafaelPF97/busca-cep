package com.test.example.search.domain.usecase.getByCep.input;

public class GetEnderecoByCepInput {

    private final String cep;

    public GetEnderecoByCepInput(String cep) {
        this.cep = cep;
    }

    public static GetEnderecoByCepInput create(String cep) {
        return new GetEnderecoByCepInput(cep);
    }

    public String getCep() {
        return cep;
    }
}
