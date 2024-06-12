package com.mercado;

public class Produto {
    private String codigo;
    private String nome;
    private double precoVenda;
    private double custo;
    private int quantidade;
    private int quantidadeVendida;

    public Produto(String codigo, String nome, double precoVenda, double custo, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.precoVenda = precoVenda;
        this.custo = custo;
        this.quantidade = quantidade;
        this.quantidadeVendida = 0;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidadeVendida() {
        return quantidadeVendida;
    }

    public void incrementarQuantidadeVendida(int quantidadeVendida) {
        this.quantidadeVendida += quantidadeVendida;
    }
}
