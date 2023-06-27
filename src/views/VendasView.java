package views;

import services.VendasService;

import java.util.Scanner;

public class VendasView {
    public Scanner scanner;
    public VendasService vendasService;

    public VendasView() {
        this.scanner = new Scanner(System.in);
        this.vendasService = new VendasService();
    }

    public void exibirMenu() {
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
                    registrarVenda();
                    break;
                case 2:
                    gerarRelatorio();
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

    private void registrarVenda() {
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

    private void gerarRelatorio() {
        double valorTotal = vendasService.calcularValorTotalVendas();
        double valorMedio = vendasService.calcularValorMedioVendas();

        System.out.println("=== Relatório de Vendas ===");
        System.out.println("Valor total vendido: R$" + valorTotal);
        System.out.println("Valor médio por venda: R$" + valorMedio);
    }
}
