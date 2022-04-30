package pos.webdev.locadora.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pos.webdev.locadora.ProjetofinalwebdevApplication;
import pos.webdev.locadora.jpa.IRepositorioCliente;
import pos.webdev.locadora.jpa.IRepositorioUsuario;
import pos.webdev.locadora.jpa.dao.DAOCliente;
import pos.webdev.locadora.jpa.dao.DAOUsuario;
import pos.webdev.locadora.model.Cliente;
import pos.webdev.locadora.model.Usuario;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UsuarioController {


    public static void main(String[] args) {
        SpringApplication.run(ProjetofinalwebdevApplication.class, args);
    }

    @Autowired
    private ApplicationContext context;

    @RequestMapping("/usuario/cadastrar")
    public String usuarioCadastrar(HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "login";
        } else {
            return "usuario/cadastrar";
        }
    }

    @RequestMapping("/usuario/editar/{id}")
    public ModelAndView editarUsuario (@PathVariable("id") Long id, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/usuario/cadastrar");

        if (session.getAttribute("usuarioLogado") == null) {
            modelAndView.setViewName("login");
        } else {
            IRepositorioUsuario repo = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repo);
            Usuario usuarioSelecionado = daoUsuario.buscarUsuarioPorId(id);
            modelAndView.addObject("usuario", usuarioSelecionado);
        }
        return modelAndView;
    }

    @RequestMapping("/usuario/cadastrado")
    public ModelAndView usuarioCadastrado(@RequestParam String nome, @RequestParam String telefone, @RequestParam String login, @RequestParam String senha, Usuario usuarioEdicao, HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            ArrayList<String> ultimoUsuarioCadastrado = new ArrayList<String>();
            Usuario usuario = new Usuario(nome, login, senha, telefone);
            IRepositorioUsuario repo = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repo);

            if (usuarioEdicao.getId() == null) {
                ultimoUsuarioCadastrado.add(nome);
                ultimoUsuarioCadastrado.add(telefone);
                ultimoUsuarioCadastrado.add(login);
                ultimoUsuarioCadastrado.add(senha);

                session.setAttribute("ultimoUsuarioCadastrado", ultimoUsuarioCadastrado);

                daoUsuario.inserirUsuario(usuario);
                modelView.setViewName("usuario/cadastrado");
            } else {
                daoUsuario.editarUsuario(usuarioEdicao);
                modelView.setViewName("redirect:/usuario/relatorio");
            }
        }
        return modelView;
    }

        @RequestMapping("/usuario/relatorio")
        public ModelAndView usuarioRelatorio (HttpSession session){
            ModelAndView modelView = new ModelAndView();

            if (session.getAttribute("usuarioLogado") == null) {
                modelView.setViewName("login");
            } else {
                IRepositorioUsuario repo = context.getBean(IRepositorioUsuario.class);
                DAOUsuario daoUsuario = new DAOUsuario(repo);
                List<Usuario> usuarios = daoUsuario.buscarUsuarios();
                modelView.addObject("usuarios", usuarios);
                modelView.setViewName("usuario/relatorio");
            }
            return modelView;
        }

    @RequestMapping("/usuario/excluir")
    public String excluirUsuario(Usuario usuario, Long id, HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioUsuario repo = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repo);
            daoUsuario.delete(usuario);
        }
        return "redirect:/usuario/relatorio";
    }
    }
