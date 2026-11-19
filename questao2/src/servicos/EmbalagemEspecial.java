package servicos;

// 6.5 Concrete Decorator - embalagem especial: R$ 180,00 fixos
public class EmbalagemEspecial extends ServicoAdicional {
    public EmbalagemEspecial(ItemFatura item) { super(item); }

    @Override protected String getNomeServico() { return "Embalagem especial"; }
    @Override protected double getCustoServico() { return 180.00; }
}