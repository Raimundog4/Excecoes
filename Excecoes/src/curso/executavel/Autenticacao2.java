package curso.executavel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JOptionPane;

import curso.contantes.StatusAlunos;
import funcoes.heranca.FuncaoAutenticacao;
import subclasses.Aluno;
import subclasses.Diretor;
import subclasses.Disciplina;

public class Autenticacao2 {

	public static void main(String[] args) {
		try {

			String login = JOptionPane.showInputDialog("Informe o seu usuário");
			String senha = JOptionPane.showInputDialog("Informe a sua senha");

			if (new FuncaoAutenticacao(new Diretor(login, senha)).funcaoAutenticar()) {// Nova função recebnedo o objeto
																						// que invoca a função

				List<Aluno> alunos = new ArrayList<Aluno>();
				HashMap<String, List<Aluno>> maps = new HashMap<String, List<Aluno>>();

				String quantidade = JOptionPane.showInputDialog("Quantos alunos?");
				for (int qtd = 1; qtd <= Integer.valueOf(quantidade); qtd++) {

					String nome = JOptionPane.showInputDialog("Qual o nome do aluno " + qtd + "? ");

					Aluno aluno1 = new Aluno();

					aluno1.setNome(nome);

					for (int pos = 1; pos <= 1; pos++) {
						String nomeDisciplina = JOptionPane.showInputDialog("Qual a disciplina " + pos + " ?");
						String notaDisciplina = JOptionPane.showInputDialog("Qual a nota " + pos + " ?");

						Disciplina disciplina = new Disciplina();
						disciplina.setDisciplina(nomeDisciplina);
						disciplina.setNota(Double.valueOf(notaDisciplina));

						aluno1.getDisciplinas().add(disciplina);

					}

					int escolha = JOptionPane.showConfirmDialog(null, "Deseja remover alguma disciplina?");

					if (escolha == 0) {

						int continuarRemover = 0;
						int posicao = 1;

						while (continuarRemover == 0) {

							String disciplinaRemover = JOptionPane
									.showInputDialog("Qual disciplina remover? 1, 2, 3 ou 4");
							aluno1.getDisciplinas().remove(Integer.valueOf(disciplinaRemover).intValue() - posicao);
							continuarRemover = JOptionPane.showConfirmDialog(null, "Deseja remover outra?");
							posicao++;
						}
					}
					alunos.add(aluno1);

				}
				maps.put(StatusAlunos.APROVADO, new ArrayList<Aluno>()); // Inicia/seta a chave para poder recuperar
																			// depois
				maps.put(StatusAlunos.APROVADOGENIO, new ArrayList<Aluno>());
				maps.put(StatusAlunos.RECUPERACAO, new ArrayList<Aluno>());
				maps.put(StatusAlunos.REPROVADO, new ArrayList<Aluno>());

				for (Aluno aluno : alunos) {

					if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAlunos.APROVADO)) {
						maps.get(StatusAlunos.APROVADO).add(aluno);
					} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAlunos.APROVADOGENIO)) {
						maps.get(StatusAlunos.APROVADOGENIO).add(aluno);
					} else if (aluno.getAlunoAprovado2().equalsIgnoreCase(StatusAlunos.RECUPERACAO)) {
						maps.get(StatusAlunos.RECUPERACAO).add(aluno);
					} else {
						maps.get(StatusAlunos.REPROVADO).add(aluno); /* reprovado */
					}

				}
				System.out.println("------------Lista dos Aprovados --------------");
				for (Aluno aluno : maps.get(StatusAlunos.APROVADO)) {
					System.out.println("Alunos: " + aluno.getNome() + " com a média: " + aluno.getMediaNota());
				}
				System.out.println("------------Lista dos Gênios --------------");
				for (Aluno aluno : maps.get(StatusAlunos.APROVADOGENIO)) {
					System.out.println("Alunos: " + aluno.getNome() + " com a média: " + aluno.getMediaNota());
				}
				System.out.println("------------Lista dos Em Recuperação --------------");
				for (Aluno aluno : maps.get(StatusAlunos.RECUPERACAO)) {
					System.out.println("Alunos: " + aluno.getNome() + " com a média: " + aluno.getMediaNota());
				}
				System.out.println("------------Lista dos Reprovados --------------");
				for (Aluno aluno : maps.get(StatusAlunos.REPROVADO)) {
					System.out.println("Alunos: " + aluno.getNome() + " com a média: " + aluno.getMediaNota());
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos!");
			}
		} catch (Exception e) {
			
			StringBuilder saida = new StringBuilder();//Classe do próprio java para trabalhar com o texto
			// Imprime o erro no console Java
			e.printStackTrace();
			
		//Mensagem do erro ou causa
			System.out.println("Mensagem: " +e.getMessage());
			
			for (int ex = 0; ex < e.getStackTrace().length; ex++) {//Imprime a quantidade de acordo com a quantidade de exceptions que tiveras
				
				//A classe StringBuilder com o .append vai somando
				saida.append("\n Classe de erro "+e.getStackTrace()[ex].getClassName());//o \n faz a quebra de linha
				saida.append("\n Linha de erro "+e.getStackTrace()[ex].getLineNumber());
				saida.append("\n Método de erro "+e.getStackTrace()[ex].getMethodName());
				saida.append("\n Método de erro "+e.getClass().getName());
				
//				System.out.println("Classe de erro "+e.getStackTrace()[ex].getClassName());
//				System.out.println("Linha de erro "+e.getStackTrace()[ex].getLineNumber());
//				System.out.println("Método de erro "+e.getStackTrace()[ex].getMethodName());
//				System.out.println("-----------------------------------------------------");
			}
			//JOptionPane.showMessageDialog(null, "Erro ao processar notas." +e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao processar notas." +saida.toString());
		}
	}
}
