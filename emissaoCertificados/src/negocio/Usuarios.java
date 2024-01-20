package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Usuarios
public class Usuarios extends Processos {

	// Declaração das variáveis
	private String cpf, nome, email, matricula;

	// Declaração dos métodos Setters e Getters
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	// Declaração dos métodos da classe

	// Receber dados através do teclado

	Scanner teclado = new Scanner(System.in);

	// Lista de usuários cadastrados
	private static List<Usuarios> usuariosCadastrados = new ArrayList<>();
	private static List<Usuarios> profCadastrados = new ArrayList<>();

	// Método para verificar se um usuário cliente está cadastrado
	public static boolean clienteCadastrado(String cpf) {
		for (Usuarios usuario : usuariosCadastrados) {
			if (usuario.getCpf().equals(cpf)) {
				return true; // Usuário encontrado
			}
		}
		return false; // Usuário não encontrado
	}
	

	// Método para verificar se um usuário Profissional está cadastrado
	public static boolean profissionalCadastrado(String matricula) {
		for (Usuarios usuario : profCadastrados) {
			if (usuario.getMatricula().equals(matricula)) {
				return true; // Usuário encontrado
			}
		}
		return false; // Usuário não encontrado
	}

	// Método Para Cadastrar Usuario Profissional

	public void cadastrarUsuarioCliente() {

		// Entrada de dados do Usuário
		System.out.println("---------------------------------------------");
		System.out.println("-------------Cadastro de Cliente-------------");
		System.out.println("---------------------------------------------");
		System.out.print("Digite seu CPF: ");
		this.setCpf(teclado.nextLine());
		System.out.print("Digite seu NOME: ");
		this.setNome(teclado.nextLine());
		System.out.print("Digite seu E-MAIL: ");
		this.setEmail(teclado.nextLine());

		// Cria um novo objeto Usuarios
		Usuarios novoUsuario = new Usuarios();
		novoUsuario.setCpf(this.getCpf());
		novoUsuario.setNome(this.getNome());
		novoUsuario.setEmail(this.getEmail());

		// Adiciona o novo usuário à lista
		usuariosCadastrados.add(novoUsuario);

		// Confirmação de cadastro de profissional
		System.out.println("---------------------------------------------");
		System.out.println("O Cliente " + this.nome + " foi cadastrado com sucesso!");

	}

	// Método Para Cadastrar Usuario Profissional

	public void cadastrarUsuarioProfissional() {

		// Entrada de dados do Usuário
		System.out.println("---------------------------------------------");
		System.out.println("------------Cadastro de Prossional-----------");
		System.out.println("---------------------------------------------");
		System.out.print("Digite seu CPF: ");
		this.setCpf(teclado.nextLine());
		System.out.print("Digite seu NOME: ");
		this.setNome(teclado.nextLine());
		System.out.print("Digite seu E-MAIL: ");
		this.setEmail(teclado.nextLine());
		System.out.print("Digite sua MATRICULA ");
		this.setMatricula(teclado.nextLine());

		// Cria um novo objeto Usuarios
		Usuarios novoUsuario = new Usuarios();
		novoUsuario.setCpf(this.getCpf());
		novoUsuario.setNome(this.getNome());
		novoUsuario.setEmail(this.getEmail());
		novoUsuario.setMatricula(this.getMatricula());

		// Adiciona o novo usuário à lista
		profCadastrados.add(novoUsuario);

		// Confirmação de cadastro de profissional
		System.out.println("---------------------------------------------");
		System.out.println("O Profissional " + this.getMatricula() + " foi cadastrado com sucesso!");

	}

}
