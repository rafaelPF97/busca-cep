package com.test.example.search.infrastructure.repository.jpa;

import com.test.example.search.infrastructure.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressJpa extends JpaRepository<AddressEntity, String> {

    Optional<AddressEntity> findByZipCode(String zipCode);
}
