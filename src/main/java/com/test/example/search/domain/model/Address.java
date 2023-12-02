package com.test.example.search.domain.model;

import java.io.Serializable;
import java.util.UUID;

public class Address implements Serializable {
    private final UUID id;
    private final String zipCode;
    private final String streetAddress;
    private final String complement;
    private final String district;
    private final String locality;
    private final String uf;
    private Long views;

    private Address(UUID id,
                    String zipCode,
                    String streetAddress,
                    String complement,
                    String district,
                    String locality,
                    String uf,
                    Long views) {
        this.id = id;
        this.zipCode = zipCode;
        this.streetAddress = streetAddress;
        this.complement = complement;
        this.district = district;
        this.locality = locality;
        this.uf = uf;
        this.views = views;
        validate();
    }

    public static Address create(String zipCode,
                                 String streetAddress,
                                 String complement,
                                 String district,
                                 String locality,
                                 String uf,
                                 Long views) {
        return new Address(UUID.randomUUID(),
                zipCode,
                streetAddress,
                complement,
                district,
                locality,
                uf,
                views);

    }

    public static Address create(UUID id,
                                 String cep,
                                 String streetAddress,
                                 String complemento,
                                 String bairro,
                                 String localidade,
                                 String uf,
                                 Long views) {
        return new Address(id,
                cep,
                streetAddress,
                complemento,
                bairro,
                localidade,
                uf,
                views);
    }

    private void validate() {
        if (zipCode == null || zipCode.isBlank()) {
            throw new IllegalArgumentException("'zipCode' cannot be null or blank");
        }
        if (streetAddress == null || streetAddress.isBlank()) {
            throw new IllegalArgumentException("'streetAddress' cannot be null or blank");
        }

        if (district == null || district.isBlank()) {
            throw new IllegalArgumentException("'district' cannot be null or blank");
        }
        if (locality == null || locality.isBlank()) {
            throw new IllegalArgumentException("'locality' cannot be null or blank");
        }
        if (uf == null || uf.isBlank()) {
            throw new IllegalArgumentException("'UF' cannot be null or blank");
        }
    }

    public void incrementViews() {
        this.views++;
    }

    public UUID getId() {
        return id;
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

    public Long getViews() {
        return views;
    }
}
