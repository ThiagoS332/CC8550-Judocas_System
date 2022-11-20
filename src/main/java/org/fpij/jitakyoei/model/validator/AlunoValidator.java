package main.java.org.fpij.jitakyoei.model.validator;

import main.java.org.fpij.jitakyoei.model.beans.Aluno;

public class AlunoValidator implements Validator<Aluno>{
	public boolean validate(Aluno aluno) {
		if(!aluno.getFiliado().getCpf().isEmpty() ||
			aluno.getFiliado().getDataCadastro() != null || 
			aluno.getFiliado().getDataNascimento() != null ||
			!aluno.getFiliado().getEmail().isEmpty() ||
			!aluno.getFiliado().getNome().isEmpty()){
			return true;
		}
		return false;
	}
}