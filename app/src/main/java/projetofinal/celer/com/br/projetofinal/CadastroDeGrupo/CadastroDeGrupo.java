package projetofinal.celer.com.br.projetofinal.CadastroDeGrupo;

/**
 * Created by regia on 30/05/2018.
 */

public class CadastroDeGrupo {
    private Long id;
    private String nomeDoGrupo;
    private String monitorResponsavel;
    private String localDeAtuacao;
    private Integer idadeInicialDeEntrada;
    private Integer idadeFinalDeSaida;

    final  static  String ID = "_id";
    final  static  String NOME_DO_GRUPO = "nomeDoGrupo";
    final  static  String MONITOR_RESPONSAVEL = "monitorResponsavel";
    final static String LOCAL_DE_ATUACAO = "localDeAtuacao";
    final static  String IDADE_INICIAL_DE_ENTRADA = "idadeInicialDeEntrada";
    final static  String IDADE_FINAL_DE_SAIDA = "idadeFinalDeSaida";

    final static String TABELA = "tbl_grupo";
    final static String [] COLUNAS = new String []{ID,NOME_DO_GRUPO,MONITOR_RESPONSAVEL,LOCAL_DE_ATUACAO,IDADE_INICIAL_DE_ENTRADA,IDADE_FINAL_DE_SAIDA};


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoGrupo() {
        return nomeDoGrupo;
    }

    public void setNomeDoGrupo(String nomeDoGrupo) {
        this.nomeDoGrupo = nomeDoGrupo;
    }

    public String getMonitorResponsavel() {
        return monitorResponsavel;
    }

    public void setMonitorResponsavel(String monitorResponsavel) {
        this.monitorResponsavel = monitorResponsavel;
    }

    public String getLocalDeAtuacao() {
        return localDeAtuacao;
    }

    public void setLocalDeAtuacao(String localDeAtuacao) {
        this.localDeAtuacao = localDeAtuacao;
    }

    public Integer getIdadeInicialDeEntrada() {
        return idadeInicialDeEntrada;
    }

    public void setIdadeInicialDeEntrada(Integer idadeInicialDeEntrada) {
        this.idadeInicialDeEntrada = idadeInicialDeEntrada;
    }

    public Integer getIdadeFinalDeSaida() {
        return idadeFinalDeSaida;
    }

    public void setIdadeFinalDeSaida(Integer idadeFinalDeSaida) {
        this.idadeFinalDeSaida = idadeFinalDeSaida;
    }
}
