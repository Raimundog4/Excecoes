package subclasses;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import curso.contantes.StatusAlunos;
import superclasse.Pessoa;

/* Classe/objeto que representa o Aluno */
public class Aluno extends Pessoa {

	/* Atributos da variável */
	private String dataMatricula;
	private String nomeEscola;
	private String serieMatriculado;

	private List<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public String getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	public String getNomeEscola() {
		return nomeEscola;
	}

	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}

	public String getSerieMatriculado() {
		return serieMatriculado;
	}

	public void setSerieMatriculado(String serieMatriculado) {
		this.serieMatriculado = serieMatriculado;
	}

	/* Método que retorna a média do aluno */
	public double getMediaNota() {

		double somaNotas = 0.0;

		for (Disciplina disciplina : disciplinas) {
			somaNotas += disciplina.getNota();
		}

		return somaNotas / disciplinas.size();
	}

	/* Método que retorna true para aprovado e false para reprovado */
	public boolean getAlunoAprovado() {
		double media = this.getMediaNota();
		if (media >= 5) {
			return true;
		} else {
			return false;
		}
	}

	/* Método que retorna string para aprovado e ou reprovado */
	public String getAlunoAprovado2() {
		double media = this.getMediaNota();
		if (media >= 5) {
			if (media >= 7) {
				if (media >= 9) {
					return StatusAlunos.APROVADOGENIO;
				} else {
					return StatusAlunos.APROVADO;
				}
			} else {
				return StatusAlunos.RECUPERACAO;
			}
		} else {
			return StatusAlunos.REPROVADO;
		}
	}

	public boolean substitucaoAluno(List<Aluno> alunos) {

		String substitua = JOptionPane.showInputDialog("Qual aluno trocar?");

		int index = 0;
		boolean found = false;
		for (Aluno aluno : alunos) {
			if (aluno.getNome().equalsIgnoreCase(substitua)) {
				String novoAluno = JOptionPane.showInputDialog("Qual o novo aluno?");
				String novaDisc = JOptionPane.showInputDialog("Qual disciplina?");
				String novaNota = JOptionPane.showInputDialog("Qual nota?");
				found = true;
				aluno.setNome(novoAluno);

				Disciplina disciplina = new Disciplina();
				disciplina.setDisciplina(novaDisc);
				disciplina.setNota(Double.valueOf(novaNota));

				aluno.getDisciplinas().add(disciplina);

				alunos.set(index, aluno);

				System.out.println("O nome do aluno é: " + aluno.getNome());
				System.out.println("A média do aluno foi: " + aluno.getMediaNota());
				System.out.println("Resultado = " + aluno.getAlunoAprovado2());
			}

			index++;
		}

		return found;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", idade=" + idade + ", dataNascimento=" + dataNascimento + ", registroGeral="
				+ registroGeral + ", numeroCpf=" + numeroCpf + ", nomeMae=" + nomeMae + ", nomePai=" + nomePai
				+ ", dataMatricula=" + dataMatricula + ", nomeEscola=" + nomeEscola + ", serieMatriculado="
				+ serieMatriculado + ", disciplina=";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numeroCpf == null) ? 0 : numeroCpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numeroCpf == null) {
			if (other.numeroCpf != null)
				return false;
		} else if (!numeroCpf.equals(other.numeroCpf))
			return false;
		return true;
	}
	@Override /* Identifica método sobreescrito - um método que já existe na superclasse - só sobreescreve*/
	public boolean pessoaMaiorIdade() {
	
	return idade >= 21; //Pode alterar o método
	}
	
	public String msgMaiorIdade () {
		return this.pessoaMaiorIdade() ? " - O aluno é maior de idade!" : " - Eita!! Menor de Idade!!!";
	}
	@Override
	public double salario() {
		
		return 1000;
	}
}
