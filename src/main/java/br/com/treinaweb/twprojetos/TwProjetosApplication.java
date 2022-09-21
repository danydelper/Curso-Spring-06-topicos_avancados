package br.com.treinaweb.twprojetos;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.treinaweb.twprojetos.entidades.Cargo;
import br.com.treinaweb.twprojetos.entidades.Endereco;
import br.com.treinaweb.twprojetos.entidades.Funcionario;
import br.com.treinaweb.twprojetos.enums.UF;
import br.com.treinaweb.twprojetos.servicos.CargoServico;
import br.com.treinaweb.twprojetos.servicos.FuncionarioServico;

@SpringBootApplication
public class TwProjetosApplication implements CommandLineRunner{

	@Autowired
	private FuncionarioServico funcionarioServico;

	@Autowired
	private CargoServico cargoServico;

	public static void main(String[] args) {
		SpringApplication.run(TwProjetosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if (cargoServico.buscarTodos().isEmpty()) {
			Cargo cargo = new Cargo();
			cargo.setNome("Gerente");

			cargo = cargoServico.cadastrar(cargo);

			Endereco endereco = new Endereco();
			endereco.setUf(UF.RS);
			endereco.setCidade("Porto Alegre");
			endereco.setBairro("Camaquã");
			endereco.setLogradouro("Travessa Escobar");
			endereco.setNumero("666");
			endereco.setCep("91910-400");

			Funcionario funcionario = new Funcionario();
			funcionario.setNome("Usuario Padrão - Apagar depois");
			funcionario.setCpf("800.280.619-00");
			funcionario.setEmail("padrao@gmail.com");
			funcionario.setSenha("senha@123");
			funcionario.setDataNascimento(LocalDate.of(2000, 1, 1));
			funcionario.setDataAdmissao(LocalDate.of(2022, 9, 20));
			funcionario.setTelefone("(51) 99263-2030");
			funcionario.setCargo(cargo);
			funcionario.setEndereco(endereco);

			funcionarioServico.cadastrar(funcionario);




		}	
	}

}
