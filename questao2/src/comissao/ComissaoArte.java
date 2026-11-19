package comissao;

// 1.1 Concrete Strategy - Arte: 20% do valor
public class ComissaoArte implements EstrategiaComissao {
    @Override
    public double calcular(double valorVenda) {
        return valorVenda * 0.20;
    }

    @Override
    public String getDescricao() {
        return "Arte (20% do valor)";
    }
}