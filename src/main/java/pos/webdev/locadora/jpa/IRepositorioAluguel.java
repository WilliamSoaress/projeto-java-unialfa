package pos.webdev.locadora.jpa;

import pos.webdev.locadora.model.Aluguel;
import org.springframework.data.repository.CrudRepository;

public interface IRepositorioAluguel extends CrudRepository<Aluguel, Long>{
    public Aluguel findAluguelById(Long id);
}

