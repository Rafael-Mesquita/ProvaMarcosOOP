package main;

import services.VendasService;

import java.util.Scanner;

public class GerenciadorVendas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendasService vendasService = new VendasService();

        boolean continuar = true;
        while (continuar) {
            System.out.println("Sistema de Gerenciamento de Vendas");
            System.out.println("1. Registrar nova venda");
            System.out.println("2. Gerar relatório de vendas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    registrarVenda(scanner, vendasService);
                    break;
                case 2:
                    gerarRelatorio(vendasService);
                    break;
                case 3:
                    continuar = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
            System.out.println();
        }
    }

    private static void registrarVenda(Scanner scanner, VendasService vendasService) {
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.next();
        System.out.print("Digite o tipo do cliente (PF/PJ): ");
        String tipoCliente = scanner.next();
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.next();
        System.out.print("Digite o valor unitário do produto: ");
        double valorUnitario = scanner.nextDouble();
        System.out.print("Digite a quantidade vendida: ");
        int quantidade = scanner.nextInt();

        vendasService.registrarVenda(nomeCliente, tipoCliente, nomeProduto, valorUnitario, quantidade);
        System.out.println("Venda registrada com sucesso!");
    }

    private static void gerarRelatorio(VendasService vendasService) {
        double valorTotal = vendasService.calcularValorTotalVendas();
        double valorMedio = vendasService.calcularValorMedioVendas();

        System.out.println("Relatório de Vendas");
        System.out.println("Valor total vendido: R$" + valorTotal);
        System.out.println("Valor médio por venda: R$" + valorMedio);
    }
}
