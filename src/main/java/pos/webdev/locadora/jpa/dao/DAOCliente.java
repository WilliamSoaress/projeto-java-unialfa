package pos.webdev.locadora.jpa.dao;

import java.util.List;

import pos.webdev.locadora.jpa.IRepositorioCliente;
import pos.webdev.locadora.model.Cliente;

public class DAOCliente {
    private IRepositorioCliente rc;

    public DAOCliente(IRepositorioCliente rc) {
        this.rc = rc;
    }

    public IRepositorioCliente getRc() {
        return rc;
    }

    public void setRc(IRepositorioCliente rc) {
        this.rc = rc;
    }

    public void inserirCliente(Cliente c) {
        this.rc.save(c);
    }

    public List<Cliente> buscarClientes() {
        return (List<Cliente>)this.rc.findAll();
    }
    
    public Cliente buscaClientePorId(Long id) {
        return (Cliente) this.rc.findClienteById(id);
    }

    public void delete(Cliente cliente){
        this.rc.delete(cliente);
    }

    public void editarCliente(Cliente cliente){
        this.rc.save(cliente);
    }
}
