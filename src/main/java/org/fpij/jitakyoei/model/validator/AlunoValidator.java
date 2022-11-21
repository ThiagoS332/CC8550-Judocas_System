package main.java.org.fpij.jitakyoei.model.validator;

import main.java.org.fpij.jitakyoei.model.beans.Aluno;

public class AlunoValidator implements Validator<Aluno>{

	private RgValidator rg = new RgValidator();

	// private void init(){
	// 	rg = new RgValidator();
	// }

	// rg.validate(aluno.getFiliado().getRg())

	public boolean validate(Aluno aluno) {
		if(!aluno.getFiliado().getCpf().isEmpty() &&
			aluno.getFiliado().getCpf().length() == 11 &&
			aluno.getFiliado().getDataNascimento() != null &&
			!aluno.getFiliado().getEmail().isEmpty() &&
			!aluno.getFiliado().getNome().isEmpty() &&
			!aluno.getFiliado().getTelefone1().isEmpty() &&
			(aluno.getFiliado().getTelefone1().length() == 13 ||
			aluno.getFiliado().getTelefone1().length() == 14))
		{
			return true;
		}
		return false;
	}
}