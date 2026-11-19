import comissao.ComissaoArte;
import comissao.ComissaoEletronicos;
import leilao.AcertoVendedor;
import leilao.Lote;
import observadores.Auditor;
import observadores.PainelLeiloeiro;
import observadores.Participante;
import servicos.CertificadoAutenticidade;
import servicos.EmbalagemEspecial;
import servicos.EntregaExpressa;
import servicos.Fatura;
import servicos.ItemFatura;
import servicos.SeguroTransporte;
import servicos.VendaLote;

// 7. Main (RF11)
public class Main {
    public static void main(String[] args) {
        System.out.println("=== CASA DE LEILÕES ONLINE ===\n");

        Lote quadro = new Lote("Pintura Abstrata", "Arte", 1000.00, 1500.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletrônicos", 2000.00, 4000.00, new ComissaoEletronicos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        // RF03 - quem acompanha cada lote
        quadro.acompanhar(ana);
        quadro.acompanhar(bruno);
        quadro.acompanhar(carla);
        quadro.acompanhar(painel);
        quadro.acompanhar(auditor);

        notebook.acompanhar(bruno);
        notebook.acompanhar(carla);
        notebook.acompanhar(painel);
        notebook.acompanhar(auditor);

        System.out.println("--- Lances no lote 'Pintura Abstrata' ---");
        ana.darLance(quadro, 1100.00);    
        bruno.darLance(quadro, 1120.00);   
        bruno.darLance(quadro, 1200.00);   

        System.out.println("\n--- Carla deixa de acompanhar a pintura ---");
        quadro.deixarDeAcompanhar(carla);
        ana.darLance(quadro, 1500.00);     

        System.out.println("\n--- Lances no lote 'Notebook Gamer' ---");
        bruno.darLance(notebook, 2200.00); 
        carla.darLance(notebook, 2400.00); 

        System.out.println("\n--- Campanha: pintura passa a usar a regra de Eletrônicos ---");
        quadro.trocarEstrategiaComissao(new ComissaoEletronicos());

        System.out.println("\n--- Encerramento ---");
        quadro.encerrar();     
        notebook.encerrar();   
        carla.darLance(notebook, 3000.00); 
        System.out.println();

        // RF10 - acerto com o vendedor
        AcertoVendedor.imprimir(quadro);
        AcertoVendedor.imprimir(notebook);

        // RF08/RF09 - fatura com serviços, em qualquer ordem, um deles duas vezes
        ItemFatura venda = new VendaLote(quadro.getNome(), quadro.getValorVenda());
        venda = new SeguroTransporte(venda);
        venda = new EmbalagemEspecial(venda);
        venda = new CertificadoAutenticidade(venda);
        venda = new EmbalagemEspecial(venda);   // contratada duas vezes
        venda = new EntregaExpressa(venda);
        Fatura.imprimir(venda);

        // RNF04 - a mesma Fatura trata uma venda sem nenhum serviço
        Fatura.imprimir(new VendaLote(quadro.getNome(), quadro.getValorVenda()));

        auditor.imprimirRegistros();
    }
}