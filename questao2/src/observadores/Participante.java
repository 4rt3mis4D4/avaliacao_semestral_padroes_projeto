package observadores;

import leilao.Lote;
import leilao.ObservadorLote;

// 4. Concrete Observer 1 - Participante (também dá lances)
public class Participante extends ObservadorLote {
    public Participante(String nome) {
        super(nome);
    }

    public boolean darLance(Lote lote, double valor) {
        return lote.receberLance(this, valor);
    }

    @Override
    public void atualizar(Lote lote) {
        System.out.println(String.format("   [Participante %s] Lote '%s': novo lance de R$ %.2f (por %s)",
                getNome(), lote.getNome(), lote.getLanceAtual(), lote.getUltimoLance().getAutor().getNome()));
    }
}