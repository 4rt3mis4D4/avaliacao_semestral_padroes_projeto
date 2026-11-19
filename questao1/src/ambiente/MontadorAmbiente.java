package ambiente;
// 10. Client do Abstract Factory (RNF02)

import fabrica.NuvemFactory;
import singleton.Configuracao;
import singleton.RegistroAuditoria;

public class MontadorAmbiente {
    private static final int HORAS_MES = 730;

    private final NuvemFactory fabrica;

    public MontadorAmbiente(NuvemFactory fabrica) {
        this.fabrica = fabrica;
    }

    public void provisionar(SolicitacaoAmbiente s) {
        // RF04 - custo estimado ANTES de criar qualquer recurso
        double custo = s.getQtdMaquinas() * fabrica.getCustoHoraMaquina() * HORAS_MES
                + s.getGbArmazenamento() * fabrica.getCustoGbArmazenamento()
                + fabrica.getCustoFila();

        // RF05 - orçamento vem do Singleton Configuracao (sem receber por parâmetro)
        Configuracao config = Configuracao.getInstancia();
        if (custo > config.getOrcamentoMaximo()) {
            String motivo = String.format("RECUSADO (custo R$ %.2f acima do orçamento de R$ %.2f)",
                    custo, config.getOrcamentoMaximo());
            RegistroAuditoria.getInstancia().registrar(s.getNome(), fabrica.getNome(), motivo);
            System.out.println("--- Ambiente recusado: " + s.getNome() + " --- " + motivo + "\n");
            return;
        }

        // Os recursos são criados pela fábrica: todos do mesmo provedor (RNF01)
        Ambiente ambiente = new Ambiente(s.getNome(), fabrica.getNome(), config.getRegiao());
        for (int i = 0; i < s.getQtdMaquinas(); i++) {
            ambiente.adicionarMaquina(fabrica.criarMaquinaVirtual());
        }
        ambiente.setArmazenamento(fabrica.criarArmazenamento());
        ambiente.setFila(fabrica.criarFila());
        ambiente.setCustoMensal(custo);

        ambiente.imprimirResumo();                                                    // RF06
        RegistroAuditoria.getInstancia().registrar(s.getNome(), fabrica.getNome(), "ACEITO"); // RF07
    }
}