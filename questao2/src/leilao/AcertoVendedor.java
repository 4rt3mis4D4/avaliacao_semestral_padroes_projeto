package leilao;

// 5. RF10 - Acerto com o vendedor: valor de venda, comissão e líquido
public class AcertoVendedor {
    public static void imprimir(Lote lote) {
        if (lote.getStatus() != StatusLote.VENDIDO) {
            System.out.println("Lote '" + lote.getNome() + "' não foi vendido: não há acerto com o vendedor.\n");
            return;
        }
        double liquido = lote.getValorVenda() - lote.getComissao();
        System.out.println("=== ACERTO DO VENDEDOR - " + lote.getNome() + " ===");
        System.out.println(String.format("Valor de venda: R$ %.2f", lote.getValorVenda()));
        System.out.println(String.format("Comissão cobrada [%s]: R$ %.2f", lote.getEstrategiaComissao().getDescricao(), lote.getComissao()));
        System.out.println(String.format("Valor líquido a repassar: R$ %.2f%n", liquido));
    }
}