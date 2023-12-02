package com.test.example.search.domain.usecase.update;

import com.test.example.search.domain.model.Address;
import com.test.example.search.domain.reposity.AddressRepository;
import com.test.example.search.domain.usecase.shared.UseCaseVoidReturn;
import com.test.example.search.domain.usecase.update.input.UpdateInput;

public class UpdateAddressIfNotInDataBase extends UseCaseVoidReturn<UpdateInput> {

    private final AddressRepository addressRepository;

    public UpdateAddressIfNotInDataBase(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void execute(UpdateInput updateInput) {
        var addressFound = addressRepository.findByZipCode(updateInput.zipCode())
                .orElseGet(() -> Address.create(
                                updateInput.zipCode(),
                                updateInput.streetAddress(),
                                updateInput.complement(),
                                updateInput.district(),
                                updateInput.locality(),
                                updateInput.uf(),
                                updateInput.views()
                        )
                );

        addressRepository.save(addressFound);

    }
}
