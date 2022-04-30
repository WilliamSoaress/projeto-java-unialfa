package pos.webdev.locadora.model;

import javax.persistence.*;

@Entity
public class Aluguel {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL)
    private Usuario usuario;

    @OneToOne(cascade = CascadeType.ALL)
    private Veiculo veiculo;
    
    public Aluguel() {
        super();
    }

    public Aluguel(Cliente cliente, Usuario usuario, Veiculo veiculo) {
        this.setCliente(cliente);
        this.setVeiculo(veiculo);
        this.setUsuario(usuario);        
    }   

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() { return cliente; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Veiculo getVeiculo() { return veiculo; }

    public void setVeiculo(Veiculo veiculo) { this.veiculo = veiculo; }
}
