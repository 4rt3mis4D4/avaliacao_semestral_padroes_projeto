package servicos;

// 6.4 Concrete Decorator - certificado de autenticidade: R$ 300,00 fixos
public class CertificadoAutenticidade extends ServicoAdicional {
    public CertificadoAutenticidade(ItemFatura item) { super(item); }

    @Override protected String getNomeServico() { return "Certificado de autenticidade"; }
    @Override protected double getCustoServico() { return 300.00; }
}