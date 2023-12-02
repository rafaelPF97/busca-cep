package com.test.example.search.infrastructure.repository.jpa;

import com.test.example.search.domain.entity.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;


@Entity
@Table(name = "tb_endereco")
public class EnderecoEntity implements Serializable {
    @Id
    @Column(name = "ds_cep")
    private String cep;
    @Column(name = "ds_logradouro")
    private String logradouro;
    @Column(name = "ds_complemento")
    private String complemento;
    @Column(name = "ds_bairro")
    private String bairro;
    @Column(name = "ds_localidade")
    private String localidade;
    @Column(name = "ds_uf")
    private String uf;
    @Column(name = "nr_views")
    private Long views;

    public EnderecoEntity(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, Long views) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.views = views;
    }

    public EnderecoEntity() {
    }

    public Address toDomain() {
        return Address.create(
                this.cep,
                this.logradouro,
                this.complemento,
                this.bairro,
                this.localidade,
                this.uf,
                this.views
        );
    }

    public static EnderecoEntity fromDomain(Address address) {
        return new EnderecoEntity(
                address.getZipCode(),
                address.getStreetAddress(),
                address.getComplement(),
                address.getDistrict(),
                address.getLocality(),
                address.getUf(),
                address.getViews()
        );
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public Long getViews() {
        return views;
    }
}
