package com.test.example.search.application.web;


import com.test.example.search.application.web.request.AddressRequest;
import com.test.example.search.application.web.response.AddressResponse;
import com.test.example.search.application.web.response.AddressViewResponse;
import com.test.example.search.domain.usecase.getAll.GetAllAddresses;
import com.test.example.search.domain.usecase.getByCep.GetAddressByCep;
import com.test.example.search.domain.usecase.getByCep.input.GetEnderecoByCepInput;
import com.test.example.search.domain.usecase.shared.NoParams;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/enderecos")
public class AddressController {

    private final GetAddressByCep getAddressByCep;
    private final GetAllAddresses getAllAddresses;


    public AddressController(GetAddressByCep getAddressByCep, GetAllAddresses getAllAddresses) {
        this.getAddressByCep = getAddressByCep;
        this.getAllAddresses = getAllAddresses;
    }

    @GetMapping("/consulta/{request}")
    public AddressResponse getCep(@PathVariable AddressRequest request) {
        var input = GetEnderecoByCepInput.create(request.zipCode());

        var domain = getAddressByCep.execute(input);

        return AddressResponse.fromDomain(domain);
    }

    @GetMapping("/consulta")
    public List<AddressViewResponse> getAll() {
        var addresses = getAllAddresses.execute(new NoParams());

        return addresses.stream()
                .map(AddressViewResponse::fromDomain)
                .toList();
    }
}
