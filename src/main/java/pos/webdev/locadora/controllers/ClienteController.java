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
import pos.webdev.locadora.jpa.IRepositorioVeiculo;
import pos.webdev.locadora.jpa.dao.DAOCliente;
import pos.webdev.locadora.jpa.dao.DAOVeiculo;
import pos.webdev.locadora.model.Cliente;
import pos.webdev.locadora.model.Veiculo;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClienteController {
    public static void main(String[] args) {
        SpringApplication.run(ProjetofinalwebdevApplication.class, args);
    }
    @Autowired
    private ApplicationContext context;

    @RequestMapping("/cliente/cadastrar")
    public String clienteCadastrar(HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "login";
        } else {
            return "cliente/cadastrar";
        }
    }

    @RequestMapping("/cliente/cadastrado")
    public ModelAndView clienteCadastrado(@RequestParam String nome, @RequestParam String cpf, @RequestParam String telefone, Cliente clienteEdicao, HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            Cliente cliente = new Cliente(nome, cpf, telefone);
            IRepositorioCliente repo = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repo);
            ArrayList<String> ultimoClienteCadastrado = new ArrayList<String>();
            if (clienteEdicao.getId() == null){
                ultimoClienteCadastrado.add(nome);
                ultimoClienteCadastrado.add(cpf);
                ultimoClienteCadastrado.add(telefone);
                session.setAttribute("ultimoClienteCadastrado", ultimoClienteCadastrado);
                daoCliente.inserirCliente(cliente);

                modelView.setViewName("cliente/cadastrado");
            } else {
                daoCliente.editarCliente(clienteEdicao);
                modelView.setViewName("redirect:/cliente/relatorio");
            }
        }
        return modelView;
    }

    @RequestMapping("/cliente/editar/{id}")
    public ModelAndView editarVeiculo(@PathVariable("id") Long id, Cliente cliente, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/cliente/cadastrar");

        if (session.getAttribute("usuarioLogado") == null){
            modelAndView.setViewName("login");
        } else {
            IRepositorioCliente repo = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repo);
            Cliente clienteSelecionado = daoCliente.buscaClientePorId(id);
            modelAndView.addObject("cliente", clienteSelecionado);
        }
        return modelAndView;
    }

    @RequestMapping("/cliente/relatorio")
    public ModelAndView clienteRelatorio(HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioCliente repo = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repo);
            List<Cliente> clientes = daoCliente.buscarClientes();
            modelView.addObject("clientes", clientes);
            modelView.setViewName("cliente/relatorio");
        }
        return modelView;
    }

    @RequestMapping("/cliente/excluir")
    public String excluirCliente(Cliente cliente, Long id, HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioCliente repo = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repo);
            daoCliente.delete(cliente);
        }
        return "redirect:/cliente/relatorio";
    }
}
