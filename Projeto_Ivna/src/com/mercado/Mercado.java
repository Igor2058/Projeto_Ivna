package com.mercado;
import java.util.ArrayList;
public class Mercado {
	    private ArrayList<Produto> produtos;
	    private double renda;

	    
	    public Mercado() {
	        this.produtos = new ArrayList<>();
	        this.renda = 0;
	    }

	    public void adicionarProduto(Produto produto) {
	        produtos.add(produto);
	    }

	    public void deletarProduto(String nome) {
	        produtos.removeIf(produto -> produto.getNome().equals(nome));
	    }

	    public void alterarProduto(String nome, double novoPreco, int novaQuantidade) {
	        for (Produto produto : produtos) {
	            if (produto.getNome().equals(nome)) {
	                produto.setPreco(novoPreco);
	                produto.setQuantidade(novaQuantidade);
	                return;
	            }
	        }
	        System.out.println("Produto não encontrado.");
	    }

	    public void buscarProduto(String nome) {
	        for (Produto produto : produtos) {
	            if (produto.getNome().equals(nome)) {
	                System.out.println("Nome: " + produto.getNome() + ", Preço: " + produto.getPreco() +
	                        ", Quantidade: " + produto.getQuantidade());
	                return;
	            }
	        }
	        System.out.println("Produto não encontrado.");
	    }

	    public void relatorioEstoque() {
	        for (Produto produto : produtos) {
	            if (produto.getQuantidade() < 5) {
	                System.out.println("Produto " + produto.getNome() + " com quantidade baixa.");
	            } else if (produto.getQuantidade() > 20) {
	                System.out.println("Produto " + produto.getNome() + " com quantidade excessiva.");
	            }
	        }
	    }

	    public void gerarVenda(String nome, int quantidade) {
	        for (Produto produto : produtos) {
	            if (produto.getNome().equals(nome) && produto.getQuantidade() >= quantidade) {
	                produto.setQuantidade(produto.getQuantidade() - quantidade);
	                renda += produto.getPreco() * quantidade;
	                return;
	            }
	        }
	        System.out.println("Produto não encontrado ou quantidade insuficiente.");
	    }

	    public double getRenda() {
	        return renda;
	    }
	}


