# Avaliação Semestral — Padrões de Projeto

> Repositório destinado à entrega da **Avaliação Semestral** da disciplina de **Padrões de Projeto**.

---

## 📌 Informações Acadêmicas

| Campo | Detalhe |
| :--- | :--- |
| **Matéria** | Padrões de Projeto |
| **Avaliação** | Avaliação Semestral |
| **Turma** | Turma 2 — QUINTA-FEIRA: 19H |
| **Professor** | Leandro Fabian Almeida Escobar |
| **Aluno(a)** | Gabriela Pedroso dos Santos Pontes |

---

## 🛠️ Solução

### Questão 01 — Provisionamento Multinuvem : **Abstract Factory** e **Singleton**

### Questão 02 — Casa de Leilões Online : **Observer**, **Strategy** e **Decorator**

---

## 📁 Estrutura do Repositório

```
.
├── README.md
├── questao1/
│   ├── diagrama/
│   │   ├── abstract_factory.drawio / .png   ← diagrama do Abstract Factory
│   │   └── singleton.drawio / .png          ← diagrama do Singleton
│   └── src/
│       ├── Main.java
│       ├── config.properties                ← região padrão e orçamento máximo
│       ├── recursos/                        ← Abstract Products (MaquinaVirtual, Armazenamento, Fila)
│       ├── fabrica/                         ← Abstract Factory (NuvemFactory)
│       ├── nuvem_aws/                       ← família Aws (fábrica + 3 produtos)
│       ├── nuvem_azure/                     ← família Azure (fábrica + 3 produtos)
│       ├── singleton/                       ← Configuracao e RegistroAuditoria
│       └── ambiente/                        ← Client (MontadorAmbiente), Ambiente e SolicitacaoAmbiente
└── questao2/
    ├── diagrama/
    │   ├── observer_strategy.drawio / .png  ← diagrama do Observer e do Strategy
    │   └── decorator.drawio / .png          ← diagrama do Decorator
    └── src/
        ├── Main.java
        ├── comissao/                        ← Strategy (regras de comissão)
        ├── leilao/                          ← Subject (Lote), abstração do Observer e domínio
        ├── observadores/                    ← Observers concretos
        └── servicos/                        ← Decorator (serviços adicionais e fatura)
```

---

## ▶️ Como Executar

**Requisito:** JDK instalado (testado com JDK 21 e 25).

Cada questão é independente e deve ser executada a partir da sua pasta `src`.

**Questão 01**

```bash
cd questao1/src
javac -encoding UTF-8 Main.java
java Main
```

> O arquivo `config.properties` é lido do diretório atual (também é encontrado se a execução partir de `questao1` ou da raiz do repositório).

**Questão 02**

```bash
cd questao2/src
javac -encoding UTF-8 Main.java
java Main
```

> O `javac` compila automaticamente todas as classes referenciadas pelo `Main`, nas pastas de pacotes.