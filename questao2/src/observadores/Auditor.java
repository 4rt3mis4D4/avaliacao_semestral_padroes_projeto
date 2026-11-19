package observadores;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import leilao.Lance;
import leilao.Lote;
import leilao.ObservadorLote;

// 4.2 Concrete Observer 3 - Auditor: registra todos os lances aceitos com data e hora
public class Auditor extends ObservadorLote {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final List<String> registros = new ArrayList<>();

    public Auditor() {
        super("Auditor");
    }

    @Override
    public void atualizar(Lote lote) {
        Lance lance = lote.getUltimoLance();
        registros.add(String.format("[%s] Lote '%s' | %s | R$ %.2f",
                LocalDateTime.now().format(FORMATO), lote.getNome(), lance.getAutor().getNome(), lance.getValor()));
    }

    public void imprimirRegistros() {
        System.out.println("=== REGISTRO DO AUDITOR (" + registros.size() + " lances aceitos) ===");
        for (String r : registros) {
            System.out.println(r);
        }
    }
}