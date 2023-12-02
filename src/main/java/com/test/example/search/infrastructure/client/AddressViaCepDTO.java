package com.test.example.search.infrastructure.client;

import com.test.example.search.domain.entity.Address;


public class AddressViaCepDTO {

    private String zipCode;
    private String streetAddress;
    private String complement;
    private String district;
    private String locality;
    private String uf;
    private Boolean erro = false;

    public AddressViaCepDTO(String zipCode,
                            String streetAddress,
                            String complement,
                            String district,
                            String locality,
                            String uf,
                            Boolean erro) {
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.complement = complement;
        this.district = district;
        this.locality = locality;
        this.uf = uf;
        this.erro = erro;

    }


    public AddressViaCepDTO() {
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getComplement() {
        return complement;
    }

    public String getDistrict() {
        return district;
    }

    public String getLocality() {
        return locality;
    }

    public String getUf() {
        return uf;
    }

    public Boolean getErro() {
        return erro;
    }

    public Address toDomain() {
        return Address.create(this.getZipCode(),
                this.getStreetAddress(),
                this.getComplement(),
                this.getDistrict(),
                this.getLocality(),
                this.getUf(),
                0L);
    }

}
