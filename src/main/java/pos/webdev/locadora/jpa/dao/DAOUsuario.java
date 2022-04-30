package pos.webdev.locadora.jpa.dao;

import java.util.List;

import pos.webdev.locadora.jpa.IRepositorioUsuario;
import pos.webdev.locadora.model.Cliente;
import pos.webdev.locadora.model.Usuario;

public class DAOUsuario {
    private IRepositorioUsuario rc;

    public DAOUsuario(IRepositorioUsuario rc) {
        this.rc = rc;
    }

    public IRepositorioUsuario getRc() {
        return rc;
    }

    public void setRc(IRepositorioUsuario rc) {
        this.rc = rc;
    }

    public void inserirUsuario(Usuario c) {
        this.rc.save(c);
    }

    public List<Usuario> buscarUsuarios() {
        return (List<Usuario>)this.rc.findAll();
    }

    public Usuario buscarUsuarioPorLogin(String login) {
        return (Usuario) this.rc.findUsuarioByLogin(login);
    };

    public Usuario buscarUsuarioPorId(Long id) {
        return (Usuario) this.rc.findUsuarioById(id);
    };

    public void editarUsuario(Usuario c) {
        this.rc.save(c);
    }

    public void delete(Usuario usuario){
        this.rc.delete(usuario);
    }

    
}
