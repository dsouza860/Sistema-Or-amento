package br.com.sistema.mgs.model;

import java.io.InputStream;

public class Orcamento {

    private String nome;
    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;
    private String cep;
    private String estado;
    private String cnpj;
    private String cpf;
    private String inscricao_estadual;
    private String email;
    private String telefone;
    private String celular;
    private String equipamento;
    private String marca;
    private String modelo;
    private String descricao;
    private String servico_prestado;
    private double valor;
    private String data_servico;
  

    public Orcamento() {
    }

    
    
    public Orcamento(String nome, String logradouro, int numero, String bairro, String cidade, String cep, String estado, String cnpj, String cpf, String inscricao_estadual, String email, String telefone, String celular, String equipamento, String marca, String modelo, String descricao, String servico_prestado, double valor, String data_servico) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.estado = estado;
        this.cnpj = cnpj;
        this.cpf = cpf;
        this.inscricao_estadual = inscricao_estadual;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.equipamento = equipamento;
        this.marca = marca;
        this.modelo = modelo;
        this.descricao = descricao;
        this.servico_prestado = servico_prestado;
        this.valor = valor;
        this.data_servico = data_servico;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getInscricao_estadual() {
        return inscricao_estadual;
    }

    public void setInscricao_estadual(String inscricao_estadual) {
        this.inscricao_estadual = inscricao_estadual;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(String equipamento) {
        this.equipamento = equipamento;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getServico_prestado() {
        return servico_prestado;
    }

    public void setServico_prestado(String servico_prestado) {
        this.servico_prestado = servico_prestado;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData_servico() {
        return data_servico;
    }

    public void setData_servico(String data_servico) {
        this.data_servico = data_servico;
    }

   

   
}
