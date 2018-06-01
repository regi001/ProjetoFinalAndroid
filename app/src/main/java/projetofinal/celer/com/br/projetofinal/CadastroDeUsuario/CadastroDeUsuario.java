package projetofinal.celer.com.br.projetofinal.CadastroDeUsuario;

import projetofinal.celer.com.br.projetofinal.CadastroDeGrupo.CadastroDeGrupo;

/**
 * Created by regia on 01/06/2018.
 */

public class CadastroDeUsuario {

    private  Long id;
    private CadastroDeGrupo cadastroDeGrupo;
    private  String nome;
    private String endereco;
    private String telefone;
    private String rg;
    private String cpf;
    private String idade;
    private String Escolaridade;
    private String numeroDeNis;

    public static final String ID = "_id";
    public  static final String CADASTRO_DE_GRUPO = "cadastroDeGrupo";
    public  static  final String NOME ="nome";
    public  static  final  String ENDERECO ="endereco";
    public  static final  String TELEFONE = "telefone";
    public  static  final  String RG = "rg";
    public static final  String CPF =   "cpf";
    public  static  final String IDADE="idade";
    public  static  final  String ESCOLARIDADE="escolaridade";
    public  static  final  String NUMERO_DE_NIS="nuemeroDeNis";

    final static String TABELA="tbl_usuario";
    final static String [] COLUNAS = new String []{ID,CADASTRO_DE_GRUPO,NOME,ENDERECO,TELEFONE,RG,CPF,IDADE,ESCOLARIDADE,NUMERO_DE_NIS};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CadastroDeGrupo getCadastroDeGrupo() {
        return cadastroDeGrupo;
    }

    public void setCadastroDeGrupo(CadastroDeGrupo cadastroDeGrupo) {
        this.cadastroDeGrupo = cadastroDeGrupo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEscolaridade() {
        return Escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        Escolaridade = escolaridade;
    }

    public String getNumeroDeNis() {
        return numeroDeNis;
    }

    public void setNumeroDeNis(String numeroDeNis) {
        this.numeroDeNis = numeroDeNis;
    }
}
