package nuvem_azure;
// 5.2 Concrete Product - família Azure

import recursos.Fila;

public class AzureFila implements Fila {
    public static final double CUSTO_MENSAL = 0.50;
    private final String id;

    public AzureFila(int numero) { this.id = "sb-" + numero; }

    @Override public String getId() { return id; }
    @Override public double getCustoMensal() { return CUSTO_MENSAL; }
}