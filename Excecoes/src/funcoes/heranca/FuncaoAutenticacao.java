package funcoes.heranca;

import curso.interfaces.PermitirAcesso;

//Realmente e somente alguém que tem o contrato da interface de PermitirAcesso e chamar o autenticado
public class FuncaoAutenticacao {

	
	private PermitirAcesso permitirAcesso;
	
//	public boolean funcaoAutenticar (PermitirAcesso acesso) { //Um modo
//		return acesso.autenticar();
//	}
	
	public boolean funcaoAutenticar () {//Outro modo
		return permitirAcesso.autenticar();
	}
	
	public FuncaoAutenticacao(PermitirAcesso acesso) {
		this.permitirAcesso = acesso;
	}
}
