package ambiente;
import java.util.ArrayList;
import java.util.List;

import recursos.Armazenamento;
import recursos.Fila;
import recursos.MaquinaVirtual;

public class Ambiente {
    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas = new ArrayList<>();
    private Armazenamento armazenamento;
    private Fila fila;
    private double custoMensal;

    public Ambiente(String nome, String provedor, String regiao) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
    }

    public void adicionarMaquina(MaquinaVirtual m) { maquinas.add(m); }
    public void setArmazenamento(Armazenamento a) { this.armazenamento = a; }
    public void setFila(Fila f) { this.fila = f; }
    public void setCustoMensal(double custo) { this.custoMensal = custo; }

    // RF06 - monta o texto inteiro e imprime de uma vez, para não misturar linhas entre threads
    public void imprimirResumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Ambiente aceito: ").append(nome).append(" ---\n");
        sb.append("Provedor: ").append(provedor).append("\n");
        sb.append("Região: ").append(regiao).append("\n");
        for (MaquinaVirtual m : maquinas) {
            sb.append("Máquina virtual: ").append(m.getId()).append("\n");
        }
        sb.append("Armazenamento: ").append(armazenamento.getId()).append("\n");
        sb.append("Fila: ").append(fila.getId()).append("\n");
        sb.append(String.format("Custo mensal estimado: R$ %.2f%n", custoMensal));
        System.out.println(sb);
    }
}