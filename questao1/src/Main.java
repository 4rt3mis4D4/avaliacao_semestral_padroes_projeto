// 11. Main (RF08) - único ponto que conhece as fábricas concretas

import ambiente.MontadorAmbiente;
import ambiente.SolicitacaoAmbiente;
import fabrica.NuvemFactory;
import nuvem_aws.AwsFactory;
import nuvem_azure.AzureFactory;
import singleton.RegistroAuditoria;

public class Main {
    private static final NuvemFactory AWS = new AwsFactory();
    private static final NuvemFactory AZURE = new AzureFactory();

    // Componente que escolhe o provedor (RNF03: para incluir o Gcp, só este método muda)
    private static NuvemFactory escolherFabrica(String provedor) {
        switch (provedor) {
            case "Aws":   return AWS;
            case "Azure": return AZURE;
            default: throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
        }
    }

    private static Thread disparar(SolicitacaoAmbiente s) {
        Thread t = new Thread(() -> new MontadorAmbiente(escolherFabrica(s.getProvedor())).provisionar(s));
        t.start();
        return t;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== PROVISIONAMENTO MULTINUVEM ===\n");

        Thread[] threads = {
            disparar(new SolicitacaoAmbiente("ambiente-vendas",    "Aws",   2, 100)),   
            disparar(new SolicitacaoAmbiente("ambiente-relatorios","Aws",   1, 500)),   
            disparar(new SolicitacaoAmbiente("ambiente-financeiro","Azure", 3, 200)),  
            disparar(new SolicitacaoAmbiente("ambiente-gigante",   "Aws",  10, 1000))   
        };

        for (Thread t : threads) {
            t.join(); 
        }

        RegistroAuditoria.getInstancia().imprimirHistorico();
    }
}