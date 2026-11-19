package leilao;

import comissao.EstrategiaComissao;
import java.util.ArrayList;
import java.util.List;

// 3.2 Subject do Observer (RNF01) e Context do Strategy (RNF02)
// Conhece apenas as abstrações ObservadorLote e EstrategiaComissao
public class Lote {
    private final String nome;
    private final String categoria;
    private final double precoReserva;

    private double lanceAtual;                       // RF01: começa no preço inicial
    private StatusLote status = StatusLote.ABERTO;
    private final List<Lance> lances = new ArrayList<>();
    private final List<ObservadorLote> observadores = new ArrayList<>();

    private EstrategiaComissao estrategiaComissao;  // regra de comissão vigente
    private ObservadorLote comprador;
    private double valorVenda;
    private double comissao;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva,
                EstrategiaComissao estrategiaComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.lanceAtual = precoInicial;
        this.precoReserva = precoReserva;
        this.estrategiaComissao = estrategiaComissao;
    }

    // ---------- Observer (RF03) ----------
    public void acompanhar(ObservadorLote observador) {
        observadores.add(observador);
    }

    public void deixarDeAcompanhar(ObservadorLote observador) {
        observadores.remove(observador);
    }

    // Notifica todos, exceto quem deu o lance
    private void notificarObservadores(ObservadorLote autor) {
        for (ObservadorLote o : new ArrayList<>(observadores)) {
            if (o != autor) {
                o.atualizar(this);
            }
        }
    }

    // ---------- Lances (RF02) ----------
    public boolean receberLance(ObservadorLote autor, double valor) {
        if (status != StatusLote.ABERTO) {
            System.out.println("[RECUSADO] Lote '" + nome + "' está encerrado e não aceita novos lances.");
            return false;
        }
        double minimo = lanceAtual * 105 / 100; // pelo menos 5% maior que o lance atual
        if (valor < minimo) {
            System.out.println(String.format(
                    "[RECUSADO] %s: lance de R$ %.2f no lote '%s' precisa ser pelo menos 5%% maior que o atual (mínimo R$ %.2f).",
                    autor.getNome(), valor, nome, minimo));
            return false;
        }
        lanceAtual = valor;
        lances.add(new Lance(autor, valor));
        System.out.println(String.format("[ACEITO] %s deu lance de R$ %.2f no lote '%s'.", autor.getNome(), valor, nome));
        notificarObservadores(autor);
        return true;
    }

    // ---------- Strategy (RF07) ----------
    // Troca a regra em tempo de execução, sem recriar o lote
    public void trocarEstrategiaComissao(EstrategiaComissao nova) {
        if (status != StatusLote.ABERTO) {
            System.out.println("[CAMPANHA] Lote '" + nome + "' já encerrado: regra não pode ser trocada.");
            return;
        }
        System.out.println("[CAMPANHA] Lote '" + nome + "': regra trocada de "
                + estrategiaComissao.getDescricao() + " para " + nova.getDescricao());
        this.estrategiaComissao = nova;
    }

    // ---------- Encerramento (RF05, RF06) ----------
    public void encerrar() {
        if (status != StatusLote.ABERTO) {
            return;
        }
        if (!lances.isEmpty() && lanceAtual >= precoReserva) {
            status = StatusLote.VENDIDO;
            valorVenda = lanceAtual;
            comprador = lances.get(lances.size() - 1).getAutor();
            comissao = estrategiaComissao.calcular(valorVenda); // regra vigente no encerramento
            System.out.println(String.format("[ENCERRADO] Lote '%s' VENDIDO para %s por R$ %.2f.",
                    nome, comprador.getNome(), valorVenda));
        } else {
            status = StatusLote.NAO_VENDIDO;
            System.out.println(String.format("[ENCERRADO] Lote '%s' NÃO VENDIDO (maior lance R$ %.2f abaixo da reserva de R$ %.2f).",
                    nome, lanceAtual, precoReserva));
        }
    }

    // ---------- Consultas ----------
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getLanceAtual() { return lanceAtual; }
    public int getTotalLances() { return lances.size(); }
    public Lance getUltimoLance() { return lances.isEmpty() ? null : lances.get(lances.size() - 1); }
    public StatusLote getStatus() { return status; }
    public ObservadorLote getComprador() { return comprador; }
    public double getValorVenda() { return valorVenda; }
    public double getComissao() { return comissao; }
    public EstrategiaComissao getEstrategiaComissao() { return estrategiaComissao; }
}