package com.test.example.search.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnderecoJpa extends JpaRepository<EnderecoEntity, UUID> {

    Optional<EnderecoEntity> findByCep(String cep);
}
