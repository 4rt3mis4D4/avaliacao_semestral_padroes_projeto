package fabrica;
// 6. Abstract Factory (RNF01, RNF02)

import recursos.Armazenamento;
import recursos.Fila;
import recursos.MaquinaVirtual;

public interface NuvemFactory {
    String getNome();

    MaquinaVirtual criarMaquinaVirtual();
    Armazenamento criarArmazenamento();
    Fila criarFila();

    // Preços do provedor, para estimar o custo ANTES de criar qualquer recurso (RF05)
    double getCustoHoraMaquina();
    double getCustoGbArmazenamento();
    double getCustoFila();
}