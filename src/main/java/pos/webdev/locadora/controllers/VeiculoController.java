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
import pos.webdev.locadora.jpa.IRepositorioAluguel;
import pos.webdev.locadora.jpa.IRepositorioCliente;
import pos.webdev.locadora.jpa.IRepositorioUsuario;
import pos.webdev.locadora.jpa.IRepositorioVeiculo;
import pos.webdev.locadora.jpa.dao.DAOAluguel;
import pos.webdev.locadora.jpa.dao.DAOCliente;
import pos.webdev.locadora.jpa.dao.DAOUsuario;
import pos.webdev.locadora.jpa.dao.DAOVeiculo;
import pos.webdev.locadora.model.Aluguel;
import pos.webdev.locadora.model.Cliente;
import pos.webdev.locadora.model.Usuario;
import pos.webdev.locadora.model.Veiculo;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class VeiculoController {

    public static void main(String[] args) {
        SpringApplication.run(ProjetofinalwebdevApplication.class, args);
    }
    @Autowired
    private ApplicationContext context;

    private DAOVeiculo daoVeiculo;
    private IRepositorioVeiculo repositorioVeiculo;

    @RequestMapping("/veiculo/cadastrar")
    public String veiculoCadastrar( HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "login";
        } else { return "veiculo/cadastrar"; }
    }

    @RequestMapping("/veiculo/cadastrado")
    public ModelAndView veiculoCadastrado(@RequestParam String modelo, @RequestParam String fabricante, @RequestParam String ano, @RequestParam String cor, Veiculo veiculoEdicao, HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            Veiculo veiculo = new Veiculo(modelo, fabricante, ano, cor);
            IRepositorioVeiculo repo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repo);
            ArrayList<String> ultimoVeiculoCadastrado = new ArrayList<String>();
            if (veiculoEdicao.getId() == null) {
                ultimoVeiculoCadastrado.add(modelo);
                ultimoVeiculoCadastrado.add(fabricante);
                ultimoVeiculoCadastrado.add(ano);
                ultimoVeiculoCadastrado.add(cor);

                session.setAttribute("ultimoVeiculoCadastrado", ultimoVeiculoCadastrado);
                daoVeiculo.inserirVeiculo(veiculo);

                modelView.setViewName("veiculo/cadastrado");
            } else {
                daoVeiculo.editarVeiculo(veiculoEdicao);
                modelView.setViewName("redirect:/veiculo/relatorio");
            }
        }
        return modelView;
    }

    @RequestMapping("/veiculo/excluir")
    public String excluirVeiculo(Veiculo veiculo, Long id, HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioVeiculo repo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repo);
            daoVeiculo.delete(veiculo);
        }
        return "redirect:/veiculo/relatorio";
    }

    @RequestMapping("/veiculo/editar/{id}")
    public ModelAndView editarVeiculo(@PathVariable("id") Long id, Veiculo veiculo, HttpSession session){
        ModelAndView modelAndView = new ModelAndView("/veiculo/cadastrar");

        if (session.getAttribute("usuarioLogado") == null){
            modelAndView.setViewName("login");
        } else {
            IRepositorioVeiculo repo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repo);
            Veiculo veiculoSelecionado = daoVeiculo.buscarVeiculoPorId(id);
            modelAndView.addObject("veiculo", veiculoSelecionado);
        }
        return modelAndView;
    }

    @RequestMapping("/veiculo/relatorio")
    public ModelAndView veiculoRelatorio(HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioVeiculo repo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repo);
            List<Veiculo> veiculos = daoVeiculo.buscarVeiculos();
            modelView.addObject("veiculos", veiculos);
            modelView.setViewName("veiculo/relatorio");
        }
        return modelView;
    }

    @RequestMapping("/veiculo/alugar")
    public ModelAndView veiculoAlugar(HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioCliente repoCliente = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repoCliente);
            List<Cliente> clientes = daoCliente.buscarClientes();
            modelView.addObject("clientes", clientes);

            IRepositorioVeiculo repoVeiculo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repoVeiculo);
            List<Veiculo> veiculos = daoVeiculo.buscarVeiculos();
            modelView.addObject("veiculos", veiculos);

            modelView.setViewName("veiculo/alugar");
        }
        return modelView;
    }

    @RequestMapping("/veiculo/alugado")
    public ModelAndView veiculoAlugado(@RequestParam Long cliente, @RequestParam Long veiculo, HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioCliente repoCliente = context.getBean(IRepositorioCliente.class);
            DAOCliente daoCliente = new DAOCliente(repoCliente);
            Cliente clienteObj = daoCliente.buscaClientePorId(Long.valueOf(cliente));

            Long usuario = (Long) session.getAttribute("idUsuarioLogado");
            IRepositorioUsuario repoUsuario = context.getBean(IRepositorioUsuario.class);
            DAOUsuario daoUsuario = new DAOUsuario(repoUsuario);
            Usuario usuarioObj = daoUsuario.buscarUsuarioPorId(Long.valueOf(usuario));

            IRepositorioVeiculo repoVeiculo = context.getBean(IRepositorioVeiculo.class);
            DAOVeiculo daoVeiculo = new DAOVeiculo(repoVeiculo);
            Veiculo veiculoObj = daoVeiculo.buscarVeiculoPorId(Long.valueOf(veiculo));

            Aluguel aluguel = new Aluguel(clienteObj, usuarioObj, veiculoObj);
            IRepositorioAluguel repoAluguel = context.getBean(IRepositorioAluguel.class);
            DAOAluguel daoAluguel = new DAOAluguel(repoAluguel);
            daoAluguel.inserirAluguel(aluguel);

            modelView.addObject("clienteObj", clienteObj);
            modelView.addObject("usuarioObj", usuarioObj);
            modelView.addObject("veiculoObj", veiculoObj);

            modelView.setViewName("veiculo/alugado");
        }
        return modelView;
    }

    @RequestMapping("/aluguel/excluir")
    public String excluirCliente(Aluguel aluguel, Long id, HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioAluguel repo = context.getBean(IRepositorioAluguel.class);
            DAOAluguel daoAluguel = new DAOAluguel(repo);
            daoAluguel.delete(aluguel);
        }
        return "redirect:/aluguel/relatorio";
    }

    @RequestMapping("/aluguel/relatorio")
    public ModelAndView aluguelRelatorio(HttpSession session) {
        ModelAndView modelView = new ModelAndView();

        if (session.getAttribute("usuarioLogado") == null) {
            modelView.setViewName("login");
        } else {
            IRepositorioAluguel repo = context.getBean(IRepositorioAluguel.class);
            DAOAluguel daoAluguel = new DAOAluguel(repo);
            List<Aluguel> aluguel = daoAluguel.buscarAluguel();
            modelView.addObject("aluguel", aluguel);
            modelView.setViewName("aluguel/relatorio");
        }
        return modelView;
    }


}
