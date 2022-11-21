package main.java.org.fpij.jitakyoei.model.validator;

import main.java.org.fpij.jitakyoei.model.beans.Aluno;

public class AlunoValidator implements Validator<Aluno> {

	private RgValidator rgVal = new RgValidator();
	private EnderecoValidator enderecoVal = new EnderecoValidator();

	public boolean validate(Aluno aluno) {
		if(!aluno.getFiliado().getCpf().isEmpty() &&
			aluno.getFiliado().getCpf().length() == 11 &&
			aluno.getFiliado().getDataNascimento() != null &&
			!aluno.getFiliado().getEmail().isEmpty() &&
			!aluno.getFiliado().getNome().isEmpty() &&
			!aluno.getFiliado().getTelefone1().isEmpty() &&
			rgVal.validate(aluno.getFiliado().getRg()) &&
			enderecoVal.validate(aluno.getFiliado().getEndereco()))
		{
			return true;
		}
		return false;
	}
}