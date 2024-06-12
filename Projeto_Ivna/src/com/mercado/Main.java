package com.mercado;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Mercado mercado = new Mercado();

        mercado.adicionarProduto(new Produto("001", "Arroz", 10, 6, 50));
        mercado.adicionarProduto(new Produto("002", "Feijão", 8, 4, 40));

        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Deletar produto");
            System.out.println("3 - Alterar produto");
            System.out.println("4 - Buscar produto");
            System.out.println("5 - Gerar venda");
            System.out.println("6 - Ver renda");
            System.out.println("7 - Gerar relatório completo");
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
                    String codigo;
                    do {
                        System.out.println("Digite o código do produto:");
                        codigo = scanner.nextLine();
                        if (mercado.codigoExiste(codigo)) {
                            System.out.println("Erro: Código do produto já existe. Digite um código diferente.");
                        }
                    } while (mercado.codigoExiste(codigo));

                    String nome;
                    do {
                        System.out.println("Digite o nome do produto:");
                        nome = scanner.nextLine();
                        if (mercado.nomeExiste(nome)) {
                            System.out.println("Erro: Nome do produto já existe. Digite um nome diferente.");
                        }
                    } while (mercado.nomeExiste(nome));

                    System.out.println("Digite o preço de venda do produto:");
                    double precoVenda = scanner.nextDouble();
                    System.out.println("Digite o custo do produto:");
                    double custo = scanner.nextDouble();
                    System.out.println("Digite a quantidade do produto:");
                    int quantidade = scanner.nextInt();
                    mercado.adicionarProduto(new Produto(codigo, nome, precoVenda, custo, quantidade));
                    break;
                case 2:
                    System.out.println("Digite o nome ou código do produto a ser deletado:");
                    String identificador = scanner.nextLine();
                    mercado.deletarProduto(identificador);
                    break;
                case 3:
                    System.out.println("Digite o nome ou código do produto a ser alterado:");
                    identificador = scanner.nextLine();

                    String novoCodigo;
                    do {
                        System.out.println("Digite o novo código do produto:");
                        novoCodigo = scanner.nextLine();
                        if (mercado.codigoExiste(novoCodigo) && !novoCodigo.equals(identificador)) {
                            System.out.println("Erro: Código do produto já existe. Digite um código diferente.");
                        }
                    } while (mercado.codigoExiste(novoCodigo) && !novoCodigo.equals(identificador));

                    String novoNome;
                    do {
                        System.out.println("Digite o novo nome do produto:");
                        novoNome = scanner.nextLine();
                        if (mercado.nomeExiste(novoNome) && !novoNome.equals(identificador)) {
                            System.out.println("Erro: Nome do produto já existe. Digite um nome diferente.");
                        }
                    } while (mercado.nomeExiste(novoNome) && !novoNome.equals(identificador));

                    System.out.println("Digite o novo preço de venda do produto:");
                    double novoPrecoVenda = scanner.nextDouble();
                    System.out.println("Digite o novo custo do produto:");
                    double novoCusto = scanner.nextDouble();
                    System.out.println("Digite a nova quantidade do produto:");
                    int novaQuantidade = scanner.nextInt();
                    mercado.alterarProduto(identificador, novoCodigo, novoNome, novoPrecoVenda, novoCusto, novaQuantidade);
                    break;
                case 4:
                    System.out.println("Digite o nome ou código do produto a ser buscado:");
                    identificador = scanner.nextLine();
                    mercado.buscarProduto(identificador);
                    break;
                case 5:
                    System.out.println("Digite o nome ou código do produto a ser vendido:");
                    identificador = scanner.nextLine();
                    System.out.println("Digite a quantidade do produto a ser vendida:");
                    int quantidadeVendida = scanner.nextInt();
                    mercado.gerarVenda(identificador, quantidadeVendida);
                    break;
                case 6:
                    System.out.println("Renda total: " + mercado.getRenda());
                    break;
                case 7:
                    mercado.gerarRelatorioCompleto();
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
