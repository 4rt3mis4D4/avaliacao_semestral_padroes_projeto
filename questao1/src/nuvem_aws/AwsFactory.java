package nuvem_aws;
import java.util.concurrent.atomic.AtomicInteger;

import fabrica.NuvemFactory;
import recursos.Armazenamento;
import recursos.Fila;
import recursos.MaquinaVirtual;

// 7. Concrete Factory - cria a família Aws
public class AwsFactory implements NuvemFactory {
    private final AtomicInteger seqVm = new AtomicInteger();
    private final AtomicInteger seqArmazenamento = new AtomicInteger();
    private final AtomicInteger seqFila = new AtomicInteger();

    @Override public String getNome() { return "Aws"; }

    @Override public MaquinaVirtual criarMaquinaVirtual() { return new AwsMaquinaVirtual(seqVm.incrementAndGet()); }
    @Override public Armazenamento criarArmazenamento() { return new AwsArmazenamento(seqArmazenamento.incrementAndGet()); }
    @Override public Fila criarFila() { return new AwsFila(seqFila.incrementAndGet()); }

    @Override public double getCustoHoraMaquina() { return AwsMaquinaVirtual.CUSTO_POR_HORA; }
    @Override public double getCustoGbArmazenamento() { return AwsArmazenamento.CUSTO_POR_GB; }
    @Override public double getCustoFila() { return AwsFila.CUSTO_MENSAL; }
}