package com.test.example.search.application.web;


import com.test.example.search.application.web.request.AddressRequest;
import com.test.example.search.application.web.response.AddressResponse;
import com.test.example.search.application.web.response.AddressViewResponse;
import com.test.example.search.domain.usecase.getAll.GetAllAddresses;
import com.test.example.search.domain.usecase.getByCep.GetAddressByZipCode;
import com.test.example.search.domain.usecase.getByCep.input.GetAddressByZipCodeInput;
import com.test.example.search.domain.usecase.shared.NoParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {

    private final GetAddressByZipCode getAddressByZipCode;
    private final GetAllAddresses getAllAddresses;


    public AddressController(GetAddressByZipCode getAddressByZipCode, GetAllAddresses getAllAddresses) {
        this.getAddressByZipCode = getAddressByZipCode;
        this.getAllAddresses = getAllAddresses;
    }

    @GetMapping("/search/{request}")
    public AddressResponse getZipCode(@PathVariable AddressRequest request) {
        var input = GetAddressByZipCodeInput.create(request.zipCode());

        var domain = getAddressByZipCode.execute(input);

        return AddressResponse.fromDomain(domain);
    }

    @GetMapping("/search")
    public List<AddressViewResponse> getAll() {
        var addresses = getAllAddresses.execute(new NoParams());

        return addresses.stream()
                .map(AddressViewResponse::fromDomain)
                .toList();
    }
}
