package pos.webdev.locadora.jpa.dao;

import pos.webdev.locadora.jpa.IRepositorioAluguel;
import pos.webdev.locadora.model.Aluguel;
import pos.webdev.locadora.model.Veiculo;

import java.util.List;

public class DAOAluguel {
    private IRepositorioAluguel rc;

    public DAOAluguel(IRepositorioAluguel rc) {
        this.rc = rc;
    }

    public IRepositorioAluguel getRc() {
        return rc;
    }

    public void setRc(IRepositorioAluguel rc) {
        this.rc = rc;
    }

    public void inserirAluguel(Aluguel c) {
        this.rc.save(c);
    }

    public List<Aluguel> buscarAluguel() {
        return (List<Aluguel>) this.rc.findAll();
    }

    public Aluguel buscarAluguelPorId(Long id) {
        return (Aluguel) this.rc.findAluguelById(id);
    };

    public void delete(Aluguel c){
        this.rc.delete(c);
    }
}
