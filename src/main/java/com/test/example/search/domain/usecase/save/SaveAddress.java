package com.test.example.search.domain.usecase.save;

import com.test.example.search.domain.entity.Address;
import com.test.example.search.domain.reposity.AddressRepository;
import com.test.example.search.domain.usecase.save.input.SaveByCepInput;
import com.test.example.search.domain.usecase.shared.UseCaseVoidReturn;

public class SaveAddress extends UseCaseVoidReturn<SaveByCepInput> {

    private final AddressRepository addressRepository;

    public SaveAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void execute(SaveByCepInput saveByCepInput) {
        var enderecoOptional = addressRepository.findByZipCode(saveByCepInput.zipCode());
        if (enderecoOptional.isPresent()) {
            return;
        }
        var address = Address.create(
                saveByCepInput.zipCode(),
                saveByCepInput.streetAddress(),
                saveByCepInput.complement(),
                saveByCepInput.district(),
                saveByCepInput.locality(),
                saveByCepInput.uf(),
                saveByCepInput.views()
        );

        addressRepository.save(address);
    }

}
