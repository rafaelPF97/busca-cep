package com.test.example.search.domain.usecase.update.input;

public class UpdateViewsInput {
    private final String cep;
    private final String logradouro;
    private final String complemento;
    private final String bairro;
    private final String localidade;
    private final String uf;
    private Long views;

    public UpdateViewsInput(String cep, String logradouro, String complemento, String bairro, String localidade, String uf, Long views) {
        this.cep = cep;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.localidade = localidade;
        this.uf = uf;
        this.views = views;
    }

    protected void incrementViews() {
        this.views++;
    }

    public Long getViews() {
        return views;
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
}
