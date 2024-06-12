package com.mercado;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Mercado {
    private ArrayList<Produto> produtos;
    private double renda;
    private int totalProdutosVendidos;

    public Mercado() {
        this.produtos = new ArrayList<>();
        this.renda = 0;
        this.totalProdutosVendidos = 0;
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void deletarProduto(String identificador) {
        produtos.removeIf(produto -> produto.getNome().equals(identificador) || produto.getCodigo().equals(identificador));
    }

    public void alterarProduto(String identificador, String novoCodigo, String novoNome, double novoPrecoVenda, double novoCusto, int novaQuantidade) {
    for (Produto produto : produtos) {
        if (produto.getNome().equals(identificador) || produto.getCodigo().equals(identificador)) {
            for (Produto p : produtos) {
                if (p.getCodigo().equals(novoCodigo) && !p.getCodigo().equals(produto.getCodigo())) {
                    System.out.println("Erro: Código do produto já existe.");
                    return;
                }
                if (p.getNome().equals(novoNome) && !p.getNome().equals(produto.getNome())) {
                    System.out.println("Erro: Nome do produto já existe.");
                    return;
                }
            }
            produto.setCodigo(novoCodigo);
            produto.setNome(novoNome);
            produto.setPrecoVenda(novoPrecoVenda);
            produto.setCusto(novoCusto);
            produto.setQuantidade(novaQuantidade);
            System.out.println("Produto alterado com sucesso.");
            return;
        }
    }
    System.out.println("Produto não encontrado.");
}

    public void buscarProduto(String identificador) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(identificador) || produto.getCodigo().equals(identificador)) {
                System.out.println("Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Preço de Venda: " + produto.getPrecoVenda() +
                        ", Custo: " + produto.getCusto() + ", Quantidade: " + produto.getQuantidade() + ", Quantidade Vendida: " + produto.getQuantidadeVendida());
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    public void gerarVenda(String identificador, int quantidade) {
        for (Produto produto : produtos) {
            if ((produto.getNome().equals(identificador) || produto.getCodigo().equals(identificador)) && produto.getQuantidade() >= quantidade) {
                produto.setQuantidade(produto.getQuantidade() - quantidade);
                produto.incrementarQuantidadeVendida(quantidade);
                double lucro = (produto.getPrecoVenda() - produto.getCusto()) * quantidade;
                renda += lucro;
                totalProdutosVendidos += quantidade;
                registrarVenda(produto, quantidade, lucro);
                return;
            }
        }
        System.out.println("Produto não encontrado ou quantidade insuficiente.");
    }

    private void registrarVenda(Produto produto, int quantidade, double lucro) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_vendas.txt", true))) {
            writer.write("Venda: Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Quantidade: " + quantidade +
                    ", Preço de Venda: " + produto.getPrecoVenda() + ", Custo: " + produto.getCusto() +
                    ", Lucro: " + lucro + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void gerarRelatorioCompleto() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("relatorio_completo.txt"))) {
            writer.write("Relatório Completo de Vendas e Estoque:\n\n");
            writer.write("Produtos em Estoque:\n");
            for (Produto produto : produtos) {
                writer.write("Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + ", Preço de Venda: " + produto.getPrecoVenda() +
                        ", Custo: " + produto.getCusto() + ", Quantidade: " + produto.getQuantidade() + ", Quantidade Vendida: " + produto.getQuantidadeVendida() + "\n");
                if (produto.getQuantidade() < 5) {
                    writer.write(" -> Produto " + produto.getNome() + " com quantidade baixa.\n");
                } else if (produto.getQuantidade() > 20) {
                    writer.write(" -> Produto " + produto.getNome() + " com quantidade excessiva.\n");
                }
            }

            writer.write("\nTotal de Produtos Vendidos: " + totalProdutosVendidos + "\n");
            writer.write("Renda Total: " + renda + "\n");

            writer.write("\nProdutos que não foram vendidos:\n");
            for (Produto produto : produtos) {
                if (produto.getQuantidadeVendida() == 0) {
                    writer.write("Código: " + produto.getCodigo() + ", Nome: " + produto.getNome() + "\n");
                }
            }

            System.out.println("Relatório completo gerado em 'relatorio_completo.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double getRenda() {
        return renda;
    }

    public boolean codigoExiste(String codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

    public boolean nomeExiste(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return true;
            }
        }
        return false;
    }
}

