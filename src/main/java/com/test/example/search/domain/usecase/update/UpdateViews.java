package com.test.example.search.domain.usecase.update;

import com.test.example.search.domain.model.Address;
import com.test.example.search.domain.reposity.AddressRepository;
import com.test.example.search.domain.usecase.shared.UseCaseVoidReturn;
import com.test.example.search.domain.usecase.update.input.UpdateViewsInput;

public class UpdateViews extends UseCaseVoidReturn<UpdateViewsInput> {

    private final AddressRepository addressRepository;

    public UpdateViews(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void execute(UpdateViewsInput updateViewsInput) {
        var addressFound = addressRepository.findByZipCode(updateViewsInput.getCep())
                .orElseGet(() -> Address.create(
                                updateViewsInput.getCep(),
                                updateViewsInput.getLogradouro(),
                                updateViewsInput.getComplemento(),
                                updateViewsInput.getBairro(),
                                updateViewsInput.getLocalidade(),
                                updateViewsInput.getUf(),
                                updateViewsInput.getViews()
                        )
                );

        addressRepository.save(addressFound);

    }
}
