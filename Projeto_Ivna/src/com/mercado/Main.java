package com.mercado;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mercado mercado = new Mercado();

        mercado.adicionarProduto(new Produto("Arroz", 10.0, 50));
        mercado.adicionarProduto(new Produto("Feijão", 8.0, 40));

        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Deletar produto");
            System.out.println("3 - Alterar produto");
            System.out.println("4 - Buscar produto");
            System.out.println("5 - Relatório de estoque");
            System.out.println("6 - Gerar venda");
            System.out.println("7 - Ver renda");
            System.out.println("0 - Sair");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); 
            } catch (InputMismatchException e) {
                opcao = -1;
                scanner.nextLine(); 
            }

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do produto:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o preço do produto:");
                    double preco = scanner.nextDouble();
                    System.out.println("Digite a quantidade do produto:");
                    int quantidade = scanner.nextInt();
                    mercado.adicionarProduto(new Produto(nome, preco, quantidade));
                    break;
                case 2:
                    System.out.println("Digite o nome do produto a ser deletado:");
                    nome = scanner.nextLine();
                    mercado.deletarProduto(nome);
                    break;
                case 3:
                    System.out.println("Digite o nome do produto a ser alterado:");
                    nome = scanner.nextLine();
                    System.out.println("Digite o novo preço do produto:");
                    preco = scanner.nextDouble();
                    System.out.println("Digite a nova quantidade do produto:");
                    quantidade = scanner.nextInt();
                    mercado.alterarProduto(nome, preco, quantidade);
                    break;
                case 4:
                    System.out.println("Digite o nome do produto a ser buscado:");
                    nome = scanner.nextLine();
                    mercado.buscarProduto(nome);
                    break;
                case 5:
                    mercado.relatorioEstoque();
                    break;
                case 6:
                    System.out.println("Digite o nome do produto a ser vendido:");
                    nome = scanner.nextLine();
                    System.out.println("Digite a quantidade do produto a ser vendida:");
                    quantidade = scanner.nextInt();
                    mercado.gerarVenda(nome, quantidade);
                    break;
                case 7:
                    System.out.println("Renda total: " + mercado.getRenda());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
