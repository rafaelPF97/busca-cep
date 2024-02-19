package com.test.example.search.application.web;


import com.test.example.search.application.web.response.AddressResponse;
import com.test.example.search.application.web.response.AddressViewResponse;
import com.test.example.search.domain.usecase.getAll.GetAllAddresses;
import com.test.example.search.domain.usecase.getByCep.GetAddressByZipCode;
import com.test.example.search.domain.usecase.getByCep.input.GetAddressByZipCodeInput;
import com.test.example.search.domain.usecase.shared.NoParams;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/addresses")
@Tag(name = "Address", description = "Address API")
public class AddressController {

    private final GetAddressByZipCode getAddressByZipCode;
    private final GetAllAddresses getAllAddresses;


    public AddressController(GetAddressByZipCode getAddressByZipCode, GetAllAddresses getAllAddresses) {
        this.getAddressByZipCode = getAddressByZipCode;
        this.getAllAddresses = getAllAddresses;
    }

    @GetMapping("/search/{request}")
    @Operation(tags = "Address",
            summary = "Get address by zip code",
            description = "Get address by zip code")
    public AddressResponse getZipCode(@PathVariable String request) {
        var input = GetAddressByZipCodeInput.create(request);

        var domain = getAddressByZipCode.execute(input);

        return AddressResponse.fromDomain(domain);
    }

    @GetMapping("/search")
    @Operation(tags = "Address",
            summary = "Get all addresses",
            description = "Get all addresses")
    public List<AddressViewResponse> getAll() {
        var addresses = getAllAddresses.execute(new NoParams());

        return addresses.stream()
                .map(AddressViewResponse::fromDomain)
                .toList();
    }
}
