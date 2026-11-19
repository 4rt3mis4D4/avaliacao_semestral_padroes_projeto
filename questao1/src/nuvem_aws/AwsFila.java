package nuvem_aws;
// 4.2 Concrete Product - família Aws

import recursos.Fila;

public class AwsFila implements Fila {
    public static final double CUSTO_MENSAL = 0.40;
    private final String id;

    public AwsFila(int numero) { this.id = "sqs-" + numero; }

    @Override public String getId() { return id; }
    @Override public double getCustoMensal() { return CUSTO_MENSAL; }
}