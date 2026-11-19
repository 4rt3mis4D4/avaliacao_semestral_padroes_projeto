package servicos;

// 6. Component do Decorator (RNF03, RNF04)
public interface ItemFatura {
    String getDescricao();
    double getValorVenda();
    double getTotal();
}