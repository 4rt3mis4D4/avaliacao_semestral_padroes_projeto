package singleton;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// 1. Singleton - Configuração (RNF04)
public class Configuracao {
    private static final String[] CAMINHOS = {
        "config.properties",                 
        "src/config.properties",             
        "questao1/src/config.properties"     
    };

    private final String regiao;
    private final double orcamentoMaximo;

    private Configuracao() {
        Properties props = new Properties();
        boolean lido = false;
        for (String caminho : CAMINHOS) {
            try (FileInputStream in = new FileInputStream(caminho)) {
                props.load(in);
                lido = true;
                break;
            } catch (IOException e) {
                
            }
        }
        if (!lido) {
            throw new IllegalStateException("config.properties não encontrado. Diretório atual: "
                    + System.getProperty("user.dir"));
        }
        this.regiao = props.getProperty("regiao");
        this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento"));
        System.out.println("[Configuracao] config.properties lido (somente uma vez)\n");
    }

    private static class Holder {
        private static final Configuracao INSTANCIA = new Configuracao();
    }

    public static Configuracao getInstancia() {
        return Holder.INSTANCIA;
    }

    public String getRegiao() { return regiao; }
    public double getOrcamentoMaximo() { return orcamentoMaximo; }
}