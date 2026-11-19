package nuvem_azure;
// 5.1 Concrete Product - família Azure

import recursos.Armazenamento;

public class AzureArmazenamento implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.02;
    private final String id;

    public AzureArmazenamento(int numero) { this.id = "blob://" + numero; }

    @Override public String getId() { return id; }
    @Override public double getCustoPorGb() { return CUSTO_POR_GB; }
}