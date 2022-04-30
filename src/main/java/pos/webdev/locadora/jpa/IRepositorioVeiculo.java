package pos.webdev.locadora.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pos.webdev.locadora.model.Veiculo;

public interface IRepositorioVeiculo extends CrudRepository<Veiculo, Long> {
    public List<Veiculo> findVeiculoByModelo(String modelo);
    public Veiculo findVeiculoById(Long id);
}
