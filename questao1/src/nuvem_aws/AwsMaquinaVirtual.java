package nuvem_aws;
// 4. Concrete Product - família Aws

import recursos.MaquinaVirtual;

public class AwsMaquinaVirtual implements MaquinaVirtual {
    public static final double CUSTO_POR_HORA = 0.10;
    private final String id;

    public AwsMaquinaVirtual(int numero) { this.id = "i-" + numero; }

    @Override public String getId() { return id; }
    @Override public double getCustoPorHora() { return CUSTO_POR_HORA; }
}