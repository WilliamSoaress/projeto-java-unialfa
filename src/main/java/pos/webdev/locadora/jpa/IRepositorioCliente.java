package pos.webdev.locadora.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pos.webdev.locadora.model.Cliente;

public interface IRepositorioCliente extends CrudRepository<Cliente, Long> {
    public List<Cliente> findClienteByCpf(String cpf);

    public Cliente findClienteById(Long id);
}
