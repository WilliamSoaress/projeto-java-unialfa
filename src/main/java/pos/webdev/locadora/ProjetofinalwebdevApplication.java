package pos.webdev.locadora;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pos.webdev.locadora.jpa.IRepositorioCliente;
import pos.webdev.locadora.jpa.IRepositorioUsuario;
import pos.webdev.locadora.jpa.IRepositorioVeiculo;
import pos.webdev.locadora.jpa.dao.DAOCliente;
import pos.webdev.locadora.jpa.dao.DAOUsuario;
import pos.webdev.locadora.jpa.dao.DAOVeiculo;
import pos.webdev.locadora.model.Cliente;
import pos.webdev.locadora.model.Usuario;
import pos.webdev.locadora.model.Veiculo;


@SpringBootApplication
public class ProjetofinalwebdevApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetofinalwebdevApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(IRepositorioCliente repoCliente, IRepositorioUsuario repoUsuario, IRepositorioVeiculo repoVeiculo) {
		return (args) -> {

			DAOUsuario daoUsuario = new DAOUsuario(repoUsuario);
			daoUsuario.inserirUsuario(new Usuario("Usuario inicial", "user", "123", "(00) 0000-0000"));

			DAOCliente daoCliente = new DAOCliente(repoCliente);
			daoCliente.inserirCliente(new Cliente("Jennifer Sueli Jesus", "259.706.756-44", "(95) 99585-5193"));
			daoCliente.inserirCliente(new Cliente("Caroline Betina da Rosa", "283.073.398-39", "(96) 98390-0638"));
			daoCliente.inserirCliente(new Cliente("Giovana Agatha Ayla da Cruz", "717.105.660-00", "(48) 99781-4489"));
			daoCliente.inserirCliente(new Cliente("Fernando Osvaldo Almada", "257.711.419-25", "(69) 98563-2784"));
			daoCliente.inserirCliente(new Cliente("Davi Augusto Thiago Lima", "224.440.023-93", "(43) 99292-9599"));

			DAOVeiculo daoVeiculo = new DAOVeiculo(repoVeiculo);
			daoVeiculo.inserirVeiculo(new Veiculo("Picanto EX 1.1/ 1.0/ 1.0 Flex Mec", "Kia Motors", "2006", "Preto"));
			daoVeiculo.inserirVeiculo(new Veiculo("Civic Hatch VTi", "Honda", "2020", "Verde"));
			daoVeiculo.inserirVeiculo(new Veiculo("Defender 130 Chassis CD Diesel", "Land Rover", "2019", "Dourado"));
			daoVeiculo.inserirVeiculo(new Veiculo("147 2.0 16V 148cv 4p Semi-Aut.", "Alfa Romeo", "2020", "Cinza"));
			daoVeiculo.inserirVeiculo(new Veiculo("335i 3.0 ActiveHybrid 3", "BMW", "2019", "Preto"));
		};


	}
}
