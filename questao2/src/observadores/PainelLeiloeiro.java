package observadores;

import leilao.Lote;
import leilao.ObservadorLote;

// 4.1 Concrete Observer 2 - Painel do leiloeiro: maior lance e total de lances
public class PainelLeiloeiro extends ObservadorLote {
    public PainelLeiloeiro() {
        super("Painel do Leiloeiro");
    }

    @Override
    public void atualizar(Lote lote) {
        System.out.println(String.format("   [PAINEL] Lote '%s': maior lance R$ %.2f | total de lances: %d",
                lote.getNome(), lote.getLanceAtual(), lote.getTotalLances()));
    }
}