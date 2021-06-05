package curso.interfaces;

//Esse interface será o nosso contrato de autenticação
public interface PermitirAcesso {

	public boolean autenticar();// Apenas declaração do método
	public boolean autenticar(String login, String senha);// Criando parâmetros

}
