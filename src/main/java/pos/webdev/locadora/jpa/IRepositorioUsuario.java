package pos.webdev.locadora.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pos.webdev.locadora.model.Usuario;

public interface IRepositorioUsuario extends CrudRepository<Usuario, Long> {
    public List<Usuario> findUsuarioByNome(String nome);
    public Usuario findUsuarioByLogin(String login);
    public Usuario findUsuarioById(Long id);
}
