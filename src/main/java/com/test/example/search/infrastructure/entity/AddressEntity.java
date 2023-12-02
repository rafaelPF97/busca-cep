package com.test.example.search.infrastructure.entity;

import com.test.example.search.domain.model.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "tb_endereco")
public class AddressEntity implements Serializable {
    @Id
    @Column(name = "id_endereco")
    private String id;
    @Column(name = "ds_cep")
    private String zipCode;
    @Column(name = "ds_logradouro")
    private String streetAddress;
    @Column(name = "ds_complemento")
    private String complement;
    @Column(name = "ds_bairro")
    private String district;
    @Column(name = "ds_localidade")
    private String locality;
    @Column(name = "ds_uf")
    private String uf;
    @Column(name = "nr_views")
    private Long views;

    public AddressEntity(
            String id,
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
    }

    public AddressEntity() {
    }

    public Address toDomain() {
        return Address.create(
                this.zipCode,
                this.streetAddress,
                this.complement,
                this.district,
                this.locality,
                this.uf,
                this.views
        );
    }

    public static AddressEntity fromDomain(Address address) {
        return new AddressEntity(
                address.getId().toString(),
                address.getZipCode(),
                address.getStreetAddress(),
                address.getComplement(),
                address.getDistrict(),
                address.getLocality(),
                address.getUf(),
                address.getViews()
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long views) {
        this.views = views;
    }
}
