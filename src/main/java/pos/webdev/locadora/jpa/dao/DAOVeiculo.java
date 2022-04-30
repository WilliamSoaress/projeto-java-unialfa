package pos.webdev.locadora.jpa.dao;

import java.util.List;

import pos.webdev.locadora.jpa.IRepositorioVeiculo;
import pos.webdev.locadora.model.Veiculo;

public class DAOVeiculo {
    private IRepositorioVeiculo rc;

    public DAOVeiculo(IRepositorioVeiculo rc) {
        this.rc = rc;
    }

    public IRepositorioVeiculo getRc() {
        return rc;
    }

    public void setRc(IRepositorioVeiculo rc) {
        this.rc = rc;
    }

    public void inserirVeiculo(Veiculo c) {
        this.rc.save(c);
    }

    public List<Veiculo> buscarVeiculos() {
        return (List<Veiculo>)this.rc.findAll();
    }

    public Veiculo buscarVeiculoPorId(Long id) {
        return (Veiculo) this.rc.findVeiculoById(id);
    };

    public void delete(Veiculo c){
        this.rc.delete(c);
    }

    public void editarVeiculo(Veiculo c){
        this.rc.save(c);
    }

}
