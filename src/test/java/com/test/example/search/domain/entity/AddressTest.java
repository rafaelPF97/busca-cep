package com.test.example.search.domain.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


class AddressTest {

    @Test
    @DisplayName("Deve lançar exceção quando cep for nulo ou vazio")
    void deveLancarExcecaoQuandoCepForNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            Address.create(null,"lagradouro", "complemento", "bairro", "localidade", "uf",0L);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            Address.create("","lagradouro", "complemento", "bairro", "localidade", "uf",0L);
        });
    }

}