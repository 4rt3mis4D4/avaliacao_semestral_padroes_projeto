package leilao;

// 3. Registro de um lance aceito (participante + valor) - RF02
public class Lance {
    private final ObservadorLote autor;
    private final double valor;

    public Lance(ObservadorLote autor, double valor) {
        this.autor = autor;
        this.valor = valor;
    }

    public ObservadorLote getAutor() { return autor; }
    public double getValor() { return valor; }
}