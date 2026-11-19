package servicos;

// 6.6 Concrete Decorator - entrega expressa: R$ 450,00 fixos
public class EntregaExpressa extends ServicoAdicional {
    public EntregaExpressa(ItemFatura item) { super(item); }

    @Override protected String getNomeServico() { return "Entrega expressa"; }
    @Override protected double getCustoServico() { return 450.00; }
}