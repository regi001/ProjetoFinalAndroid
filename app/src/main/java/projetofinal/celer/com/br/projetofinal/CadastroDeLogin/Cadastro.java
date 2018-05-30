package projetofinal.celer.com.br.projetofinal.CadastroDeLogin;

/**
 * Created by regia on 28/05/2018.
 */

public class Cadastro {

    public String usuario,email, senha;


    final  static  String USUARIO = "usuario";
    final  static  String EMAIL = "email";
    final  static  String SENHA = "senha";

    final static String TABELA = "tbl_cadastro";
    final static String [] COLUNAS = new String []{USUARIO,EMAIL,SENHA};


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
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
