package negocio;

public class Programa {

	public static void main (String[] args) {
		
		//Instaciando Novos Ojbetos do tipo Usuario
		Usuarios c1 = new Usuarios();
		Usuarios p1 = new Usuarios();
				
		// cadastrando novo cliente
		c1.cadastrarUsuarioCliente();
		
		// registrando novo processo
		c1.registrarProcesso();
		
		// cadastrando novo profissional
		p1.cadastrarUsuarioProfissional();
		
		// Analisando novo processo
		p1.analisarProcesso();
		
		c1.acompanharProcesso();
		c1.emitirCertificado();
		
		
	}
	
}
