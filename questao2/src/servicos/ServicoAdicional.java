package servicos;

// 6.2 Decorator - embrulha outro ItemFatura e acrescenta descrição e custo (RF08)
public abstract class ServicoAdicional implements ItemFatura {
    protected final ItemFatura item;

    protected ServicoAdicional(ItemFatura item) {
        this.item = item;
    }

    protected abstract String getNomeServico();
    protected abstract double getCustoServico();

    @Override
    public String getDescricao() {
        return item.getDescricao() + "\n"
                + String.format("  + %-30s R$ %.2f", getNomeServico(), getCustoServico());
    }

    @Override
    public double getValorVenda() {
        return item.getValorVenda();
    }

    @Override
    public double getTotal() {
        return item.getTotal() + getCustoServico();
    }
}