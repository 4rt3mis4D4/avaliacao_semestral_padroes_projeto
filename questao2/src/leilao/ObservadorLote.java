package leilao;

// 2. Abstração Observer (RNF01)
public abstract class ObservadorLote {
    private final String nome;

    protected ObservadorLote(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // Recebe o lote como parâmetro porque o mesmo observador pode acompanhar vários lotes
    public abstract void atualizar(Lote lote);
}