package servicos;

// 6.3 Concrete Decorator - seguro de transporte: 1,5% do valor de venda
public class SeguroTransporte extends ServicoAdicional {
    public SeguroTransporte(ItemFatura item) { super(item); }

    @Override protected String getNomeServico() { return "Seguro de transporte"; }
    @Override protected double getCustoServico() { return getValorVenda() * 0.015; }
}