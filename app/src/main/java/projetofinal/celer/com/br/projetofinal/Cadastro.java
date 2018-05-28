package projetofinal.celer.com.br.projetofinal;

/**
 * Created by regia on 28/05/2018.
 */

public class Cadastro {
    private Long id;
    public String nome,email, senha;


    final  static  String NOME = "nome";
    final  static  String EMAIL = "email";
    final  static  String SENHA = "senha";

    final static String TABELA = "tbl_cadastro";
    final static String [] COLUNAS = new String []{NOME,EMAIL,SENHA};



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
