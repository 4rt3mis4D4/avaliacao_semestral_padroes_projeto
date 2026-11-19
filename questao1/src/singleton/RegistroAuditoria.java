package singleton;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// 2. Singleton - Histórico de auditoria (RNF05)
public class RegistroAuditoria {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private final List<String> historico = new ArrayList<>();

    private RegistroAuditoria() { }

    private static class Holder {
        private static final RegistroAuditoria INSTANCIA = new RegistroAuditoria();
    }

    public static RegistroAuditoria getInstancia() {
        return Holder.INSTANCIA;
    }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        String linha = "[" + LocalDateTime.now().format(FORMATO) + "] ambiente=" + ambiente
                + " | provedor=" + provedor + " | resultado=" + resultado;
        historico.add(linha);
    }

    public synchronized void imprimirHistorico() {
        System.out.println("=== HISTÓRICO DE AUDITORIA (" + historico.size() + " registros) ===");
        for (String linha : historico) {
            System.out.println(linha);
        }
    }
}