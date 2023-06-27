package models;

public class Venda {
    public Cliente cliente;
    public String nomeProduto;
    public double valorUnitario;
    public int quantidade;

    public Venda(Cliente cliente, String nomeProduto, double valorUnitario, int quantidade) {
        this.cliente = cliente;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorUnitario * quantidade;
    }
}

