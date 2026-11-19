package nuvem_aws;
// 4.1 Concrete Product - família Aws

import recursos.Armazenamento;

public class AwsArmazenamento implements Armazenamento {
    public static final double CUSTO_POR_GB = 0.023;
    private final String id;

    public AwsArmazenamento(int numero) { this.id = "s3://" + numero; }

    @Override public String getId() { return id; }
    @Override public double getCustoPorGb() { return CUSTO_POR_GB; }
}