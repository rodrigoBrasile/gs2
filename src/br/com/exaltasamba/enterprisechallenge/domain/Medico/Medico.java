package br.com.exaltasamba.enterprisechallenge.domain.Medico;

/**
 * A classe `Medico` representa a entidade médico no sistema, contendo informações essenciais como nome, CRM (Conselho
 * Regional de Medicina) e idUsuario. Neste contexto, a restrição de tempo para a entrega do projeto influenciou na
 * decisão de manter a classe de forma enxuta, focando apenas nos atributos fundamentais para a funcionalidade
 * imediata do sistema.
 *
 * ## Atributos:
 * - `nome`: Uma string que armazena o nome do médico.
 * - `crm`: Uma string que representa o número do CRM do médico.
 * - `idUsuario`: Um identificador associado ao médico no sistema.
 *
 * A decisão de manter a classe simplificada se deve à necessidade de atender às demandas do projeto dentro de um
 * cronograma restrito. Ao se concentrar nos atributos cruciais para as operações básicas do sistema, como inserção e
 * recuperação de médicos, busca-se otimizar o tempo disponível, priorizando a entrega funcional do projeto.
 *
 * Vale ressaltar que, embora a classe esteja enxuta, é importante considerar futuras expansões e requisitos do
 * sistema. A modularidade e a flexibilidade devem ser mantidas para facilitar ajustes e adições no código conforme
 * necessário.
 */

public class Medico {

    private int id;
    private String nome;
    private String crm;
    private int idUsuario;

    public Medico(int id, String nome, String crm, int idUsuario) {
        this.id = id;
        this.nome = nome;
        this.crm = crm;
        this.idUsuario = idUsuario;
    }

    public Medico(String nome, String crm, int idUsuario) {
        this.nome = nome;
        this.crm = crm;
        this.idUsuario = idUsuario;
    }

    public Medico() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
