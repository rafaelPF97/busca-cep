package com.test.example.search.infrastructure.client;

import com.test.example.search.domain.model.Address;


public class AddressViaCepDTO {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private Boolean erro = false;

    public AddressViaCepDTO(String cep,
                            String logradouro,
                            String complemento,
                            String bairro,
                            String localidade,
                            String uf,
                            Boolean erro) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.erro = erro;

    }


    public AddressViaCepDTO() {
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

    public Boolean getErro() {
        return erro;
    }

    public Address toDomain() {
        return Address.create(this.getCep(),
                this.getLogradouro(),
                this.getComplemento(),
                this.getBairro(),
                this.getLocalidade(),
                this.getUf(),
                0L);
    }

}
