package servicos;

// 6.7 RF09 / RNF04 - imprime a fatura sem verificar quais serviços foram contratados
public class Fatura {
    public static void imprimir(ItemFatura item) {
        System.out.println("=== FATURA DO COMPRADOR ===");
        System.out.println(item.getDescricao());
        System.out.println(String.format("TOTAL A PAGAR: R$ %.2f%n", item.getTotal()));
    }
}