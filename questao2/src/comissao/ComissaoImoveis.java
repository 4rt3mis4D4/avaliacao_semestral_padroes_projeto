package comissao;

// 1.3 Concrete Strategy - Imóveis: 3% do valor mais R$ 1.500,00 fixos
public class ComissaoImoveis implements EstrategiaComissao {
    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.03 + 1500.00;
    }

    @Override
    public String getDescricao() {
        return "Imóveis (3% do valor + R$ 1.500,00 fixos)";
    }
}