package comissao;

// 1. Strategy (RNF02)
public interface EstrategiaComissao {
    double calcular(double valorVenda);
    String getDescricao();
}