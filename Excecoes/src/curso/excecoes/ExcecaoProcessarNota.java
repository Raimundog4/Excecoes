package curso.excecoes;

public class ExcecaoProcessarNota extends Exception {//Classe filha

	public ExcecaoProcessarNota(String erro) {//Cria o construtor dela e recebe uma String e depois passa para a classe pai
		super("Erro no processamento do arquivo ao acessar notas do aluno! "+erro);//Implementa o construtor da classe pai
	}

}
