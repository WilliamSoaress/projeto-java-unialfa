package pos.webdev.locadora;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pos.webdev.locadora.jpa.IRepositorioCliente;
import pos.webdev.locadora.jpa.IRepositorioUsuario;
import pos.webdev.locadora.jpa.IRepositorioVeiculo;


@SpringBootApplication
public class ProjetofinalwebdevApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetofinalwebdevApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(IRepositorioCliente repoCliente, IRepositorioUsuario repoUsuario, IRepositorioVeiculo repoVeiculo) {
		return (args) -> {};
	}
}
