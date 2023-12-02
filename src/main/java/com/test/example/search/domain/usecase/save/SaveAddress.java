package com.test.example.search.domain.usecase.save;

import com.test.example.search.domain.model.Address;
import com.test.example.search.domain.reposity.AddressRepository;
import com.test.example.search.domain.usecase.save.input.SaveAddressInput;
import com.test.example.search.domain.usecase.shared.UseCaseVoidReturn;

public class SaveAddress extends UseCaseVoidReturn<SaveAddressInput> {

    private final AddressRepository addressRepository;

    public SaveAddress(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void execute(SaveAddressInput saveAddressInput) {
        var enderecoOptional = addressRepository.findByZipCode(saveAddressInput.zipCode());
        if (enderecoOptional.isPresent()) {
            return;
        }
        var address = Address.create(
                saveAddressInput.zipCode(),
                saveAddressInput.streetAddress(),
                saveAddressInput.complement(),
                saveAddressInput.district(),
                saveAddressInput.locality(),
                saveAddressInput.uf(),
                saveAddressInput.views()
        );

        addressRepository.save(address);
    }

}
