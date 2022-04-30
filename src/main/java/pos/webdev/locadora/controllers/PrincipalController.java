package pos.webdev.locadora.controllers;

import javax.servlet.http.HttpSession;

import pos.webdev.locadora.ProjetofinalwebdevApplication;
import pos.webdev.locadora.jpa.IRepositorioUsuario;
import pos.webdev.locadora.jpa.dao.DAOUsuario;
import pos.webdev.locadora.model.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalController {
    
    public static void main(String[] args) {
        SpringApplication.run(ProjetofinalwebdevApplication.class, args);
    }
    @Autowired
    private ApplicationContext context;
    
    @RequestMapping("/")
    public String index() {
        return "login";
    }    

    @RequestMapping("/logout")
    public String usuarioLogado(HttpSession session) {
        session.invalidate();
        return "login";
    }

    @RequestMapping("/home")
    public ModelAndView efetuarLogin(@RequestParam(value="login", required=false) String login, @RequestParam(value="senha", required=false) String senha, HttpSession session, Usuario usuario) {

        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") != null) {
            modelView.setViewName("home");
        } else {
            IRepositorioUsuario repoUsuario = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repoUsuario);
            Usuario userObject = daoUsuario.buscarUsuarioPorLogin(String.valueOf(login));
            String user = null;
            String password = null;
            String userName = null;
            Long userId = null;

            if (userObject == null) {
                modelView.setViewName("login");
            } else {
                user = userObject.getLogin();
                password = userObject.getSenha();
                userName = userObject.getNome();
                userId = userObject.getId();

                if(user.equals(login) && password.equals(senha)) {
                    session.setAttribute("usuarioLogado", userName);
                    session.setAttribute("idUsuarioLogado", userId);

                    modelView.setViewName("home");
                } else {
                    modelView.setViewName("login");
                }
            }
        }
        return modelView;
    }
}