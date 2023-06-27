package services;

import models.Cliente;
import models.Venda;

import java.util.ArrayList;
import java.util.List;

public class VendasService {
    public List<Venda> vendas;

    public VendasService() {
        this.vendas = new ArrayList<>();
    }

    public void registrarVenda(String nomeCliente, String tipoCliente, String nomeProduto, double valorUnitario, int quantidade) {
        Cliente cliente = new Cliente(nomeCliente, tipoCliente);
        Venda venda = new Venda(cliente, nomeProduto, valorUnitario, quantidade);
        vendas.add(venda);
    }

    public double calcularValorTotalVendas() {
        double valorTotal = 0;
        for (Venda venda : vendas) {
            valorTotal += venda.getValorTotal();
        }
        return valorTotal;
    }

    public double calcularValorMedioVendas() {
        if (vendas.isEmpty()) {
            return 0;
        }
        double valorTotal = calcularValorTotalVendas();
        return valorTotal / vendas.size();
    }
}

