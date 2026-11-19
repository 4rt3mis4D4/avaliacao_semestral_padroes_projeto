package nuvem_azure;
import java.util.concurrent.atomic.AtomicInteger;

import fabrica.NuvemFactory;
import recursos.Armazenamento;
import recursos.Fila;
import recursos.MaquinaVirtual;

// 7.1 Concrete Factory - cria a família Azure
public class AzureFactory implements NuvemFactory {
    private final AtomicInteger seqVm = new AtomicInteger();
    private final AtomicInteger seqArmazenamento = new AtomicInteger();
    private final AtomicInteger seqFila = new AtomicInteger();

    @Override public String getNome() { return "Azure"; }

    @Override public MaquinaVirtual criarMaquinaVirtual() { return new AzureMaquinaVirtual(seqVm.incrementAndGet()); }
    @Override public Armazenamento criarArmazenamento() { return new AzureArmazenamento(seqArmazenamento.incrementAndGet()); }
    @Override public Fila criarFila() { return new AzureFila(seqFila.incrementAndGet()); }

    @Override public double getCustoHoraMaquina() { return AzureMaquinaVirtual.CUSTO_POR_HORA; }
    @Override public double getCustoGbArmazenamento() { return AzureArmazenamento.CUSTO_POR_GB; }
    @Override public double getCustoFila() { return AzureFila.CUSTO_MENSAL; }
}