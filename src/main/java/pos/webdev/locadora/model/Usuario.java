package pos.webdev.locadora.model;

import javax.persistence.*;

@Entity
public class Usuario {

    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String login;
    private String senha;
    private String telefone;

    public Usuario() { super(); }    

    public Usuario(String nome, String login, String senha, String telefone) {
        this.setNome(nome);
        this.setLogin(login);
        this.setSenha(senha);
        this.setTelefone(telefone);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    
    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }    
}