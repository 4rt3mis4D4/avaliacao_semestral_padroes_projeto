package servicos;

// 6.1 Concrete Component - a venda do lote, sem nenhum serviço adicional
public class VendaLote implements ItemFatura {
    private final String nomeLote;
    private final double valorVenda;

    public VendaLote(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String getDescricao() {
        return "Lote: " + nomeLote + "\n" + String.format("Valor de venda: R$ %.2f", valorVenda);
    }

    @Override
    public double getValorVenda() {
        return valorVenda;
    }

    @Override
    public double getTotal() {
        return valorVenda;
    }
}