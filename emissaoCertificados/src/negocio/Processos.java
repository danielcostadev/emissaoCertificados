package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

//Classe Processos
public class Processos {

	// Declaração de variaveis
	private String tituloDoTrabalho, dataDeProducao, dataDeAnalise, status, nomeDoAutor, cpfDoAutor,
			matriculaDoProfissional;
	private int protocolo;

	// Declaração dos métodos Setters e Getters
	public String getTituloDoTrabalho() {
		return tituloDoTrabalho;
	}

	public void setTituloDoTrabalho(String tituloDoTrabalho) {
		this.tituloDoTrabalho = tituloDoTrabalho;
	}

	public String getDataDeProducao() {
		return dataDeProducao;
	}

	public void setDataDeProducao(String dataDeProducao) {
		this.dataDeProducao = dataDeProducao;
	}

	public String getDataDeAnalise() {
		return dataDeAnalise;
	}

	public void setDataDeAnalise(String dataDeAnalise) {
		this.dataDeAnalise = dataDeAnalise;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNomeDoAutor() {
		return nomeDoAutor;
	}

	public void setNomeDoAutor(String nomeDoAutor) {
		this.nomeDoAutor = nomeDoAutor;
	}

	public String getCpfDoAutor() {
		return cpfDoAutor;
	}

	public void setCpfDoAutor(String cpfDoAutor) {
		this.cpfDoAutor = cpfDoAutor;
	}

	public String getMatriculaDoProfissional() {
		return matriculaDoProfissional;
	}

	public void setMatriculaDoProfissional(String matriculaDoProfissional) {
		this.matriculaDoProfissional = matriculaDoProfissional;
	}

	public int getProtocolo() {
		return protocolo;
	}

	public void setProtocolo(int protocolo) {
		this.protocolo = protocolo;
	}

	// Declaração dos metodos da classe

	// Receber dados através do teclado
	Scanner teclado = new Scanner(System.in);

	// Lista de usuários cadastrados
	private static List<Processos> processosCadastrados = new ArrayList<>();

	// Método para verificar se um processo está cadastrado
	public static boolean processoCadastrado(int protocolo) {
		for (Processos processo : processosCadastrados) {
			if (processo.getProtocolo() == protocolo) {
				return true; // Processo encontrado
			}
		}
		return false; // Processo não encontrado
	}

	// Método para gerar protocoloco randomicamente (aleatoriamente)
	public void gerarProtocolo() {
		Random aleatorio = new Random();
		setProtocolo(100_000_000 + aleatorio.nextInt(900_000_000));
	}

	// Método para registrar processo
	public void registrarProcesso() {

		System.out.println("---------------------------------------------");
		System.out.println("------------Registro de Processos------------");
		System.out.println("---------------------------------------------");

		// Verificar se o usuário está cadastrado, e caso esteja permite registrar
		// processos
		System.out.print("Digite seu CPF: ");
		String cpf = teclado.nextLine();
		if (!Usuarios.clienteCadastrado(cpf)) {
			System.out.println("Usuário não cadastrado. Não autorizado a registrar processos.");
			return;
		}
		this.setCpfDoAutor(cpf);
		System.out.print("Digite seu nome: ");
		this.setNomeDoAutor(teclado.nextLine());
		System.out.print(getNomeDoAutor() + " Digite o titulo do trabalho: ");
		this.setTituloDoTrabalho(teclado.nextLine());
		System.out.print(getNomeDoAutor() + " Digite a data de produção: ");
		this.setDataDeProducao(teclado.nextLine());

		// chama o método que gera protocolo único para processo
		gerarProtocolo();

		// Cria um novo objeto Processo
		Processos novoProcesso = new Processos();
		novoProcesso.setCpfDoAutor(this.getCpfDoAutor());
		novoProcesso.setTituloDoTrabalho(this.getTituloDoTrabalho());
		novoProcesso.setDataDeProducao(this.getDataDeProducao());
		novoProcesso.setProtocolo(this.getProtocolo());
		novoProcesso.setStatus(this.getStatus());

		// Adiciona o novo processo à lista
		processosCadastrados.add(novoProcesso);

		// Confirmação de cadastro de profissional
		System.out.println("---------------------------------------------");
		System.out.println("O Processo " + this.protocolo + " foi cadastrado com sucesso!!");

		// debug
		System.out.println("---------------------------------------------");
		System.out.println(this.getNomeDoAutor());
		System.out.println(this.getCpfDoAutor());
		System.out.println(this.getTituloDoTrabalho());
		System.out.println(this.getDataDeProducao());
		System.out.println(this.getProtocolo());
	}

	// Método para verificar se protocolo existe na lista
	public boolean verificaProtocolo() {

		System.out.print("Por favor, informe o número do protocolo a ser analisado: ");

		// Armazena o número digitado pelo usuario como String na variável temporária pu
		String pu = teclado.nextLine();

		// Converte a String da variável pu em Inteiro e armazena na variável protocolo,
		// isso corrige um bug que estava travando a aplicação por causado do valor
		// inteiro sendo recebido diretamente
		int protocolo = Integer.parseInt(pu);

		// Verificar se processo existe através do protocolo informado
		if (!Processos.processoCadastrado(protocolo)) {
			System.out.println("Processo não localizado. Não é possível analisá-lo!.");
			return false;
		} else {
			// Caso o protocolo esteja correto associa ao processo e continua a aplicação
			this.setProtocolo(protocolo);
			return true;
		}

	}

	// Método para analisar processo
	public void analisarProcesso() {

		System.out.println("---------------------------------------------");
		System.out.println("-------------Análise de Processos------------");
		System.out.println("---------------------------------------------");

		// Verificar se o usuário está cadastrado, e caso esteja permite analisar
		// processos
		System.out.print("Confirme sua matricula: ");
		String matricula = teclado.nextLine();
		if (!Usuarios.profissionalCadastrado(matricula)) {
			System.out.println("Usuário não cadastrado. Não autorizado a analisar processos.");
			return;
		}
		// Caso a matricula esteja correta associa ao profissional e continua a
		// aplicação
		this.setMatriculaDoProfissional(matricula);

		// Verficiar se protocolo existe na lista
		if (verificaProtocolo() == true) {

			System.out.print("Informe a data da análise: ");
			this.setDataDeAnalise(teclado.nextLine());
			System.out.print("Informe o status da análise [Deferido/Indeferido]: ");
			this.setStatus(teclado.nextLine());

			// Atualizar Status do Processo após análise do profissional
			for (Processos processo : processosCadastrados) {
				processo.setStatus(getStatus());
			}
		} else {

			System.out.println("Encerrando a aplicação...");
			System.exit(0);

		}

		// debug
		System.out.println(this.getDataDeAnalise());
		System.out.println(this.getMatriculaDoProfissional());
		System.out.println(this.getStatus());

	}

	// Métodos para cliente acomapanhar análise e resultado do processo submetido
	public void acompanharProcesso() {

		System.out.println("---------------------------------------------");
		System.out.println("---------Acompanhamento de Processos---------");
		System.out.println("---------------------------------------------");

		// Verficiar se protocolo existe na lista
		if (verificaProtocolo() == true) {

			// Recupera a lista e exibe para o usuário
			for (Processos processo : processosCadastrados) {
				System.out.println("CPF do Autor: " + processo.getCpfDoAutor());
				System.out.println("Título do Trabalho: " + processo.getTituloDoTrabalho());
				System.out.println("Data de Produção: " + processo.getDataDeProducao());
				System.out.println("Protocolo: " + processo.getProtocolo());
				System.out.println("Status: " + processo.getStatus());
				System.out.println("--------------");
			}

		} else {

			System.out.println("Encerrando a aplicação...");
			System.exit(0);

		}

	}

	public void emitirCertificado() {

	}

}
