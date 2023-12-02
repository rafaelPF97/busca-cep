package com.test.example.search.application.config;

import com.test.example.search.domain.gateway.AddressGateway;
import com.test.example.search.domain.reposity.AddressRepository;
import com.test.example.search.domain.usecase.getAll.GetAllAddresses;
import com.test.example.search.domain.usecase.getByCep.GetAddressByZipCode;
import com.test.example.search.domain.usecase.save.SaveAddress;
import com.test.example.search.domain.usecase.update.UpdateAddressIfNotInDataBase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DIConfig {

    @Bean
    public GetAddressByZipCode getAddressByZipCode(AddressGateway feignAbstraction) {
        return new GetAddressByZipCode(feignAbstraction);
    }

    @Bean
    public SaveAddress saveAddress(AddressRepository addressRepository) {
        return new SaveAddress(addressRepository);
    }

    @Bean
    public GetAllAddresses getAllAddresses(AddressRepository addressRepository) {
        return new GetAllAddresses(addressRepository);
    }

    @Bean
    public UpdateAddressIfNotInDataBase updateViews(AddressRepository addressRepository) {
        return new UpdateAddressIfNotInDataBase(addressRepository);
    }
}
