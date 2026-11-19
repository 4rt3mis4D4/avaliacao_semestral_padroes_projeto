package ambiente;
// 8. RF03 - Dados da solicitação de um ambiente
public class SolicitacaoAmbiente {
    private final String nome;
    private final String provedor;
    private final int qtdMaquinas;
    private final int gbArmazenamento;

    public SolicitacaoAmbiente(String nome, String provedor, int qtdMaquinas, int gbArmazenamento) {
        this.nome = nome;
        this.provedor = provedor;
        this.qtdMaquinas = qtdMaquinas;
        this.gbArmazenamento = gbArmazenamento;
    }

    public String getNome() { return nome; }
    public String getProvedor() { return provedor; }
    public int getQtdMaquinas() { return qtdMaquinas; }
    public int getGbArmazenamento() { return gbArmazenamento; }
}