package nuvem_azure;
// 5. Concrete Product - família Azure

import recursos.MaquinaVirtual;

public class AzureMaquinaVirtual implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.12;
    private final String id;

    public AzureMaquinaVirtual(int numero) { this.id = "vm-" + numero; }

    @Override public String getId() { return id; }
    @Override public double getCustoPorHora() { return CUSTO_POR_HORA; }
}