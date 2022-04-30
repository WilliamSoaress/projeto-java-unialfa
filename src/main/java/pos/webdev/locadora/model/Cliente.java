package pos.webdev.locadora.model;

import javax.persistence.*;

@Entity
public class Cliente {
    
    @Id
    @GeneratedValue
    private Long id;    
    private String nome;
    private String cpf;
    private String telefone;
    
    public Cliente() { super(); }

    public Cliente(String nome, String cpf, String telefone) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setTelefone(telefone);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }    
}
