package main.java.org.fpij.jitakyoei.model.validator;

import main.java.org.fpij.jitakyoei.model.beans.Aluno;

public class AlunoValidator implements Validator<Aluno> {

	private RgValidator rgVal = new RgValidator();
	private EnderecoValidator enderecoVal = new EnderecoValidator();
	private FaixaValidator faixaVal = new FaixaValidator();

	public boolean validate(Aluno aluno) {
		if(!aluno.getFiliado().getCpf().isEmpty() &&
			aluno.getFiliado().getCpf().length() == 11 &&
			!aluno.getFiliado().getRegistroCbj().isEmpty() &&
			aluno.getFiliado().getDataNascimento() != null &&
			!aluno.getFiliado().getEmail().isEmpty() &&
			!aluno.getFiliado().getNome().isEmpty() &&
			(!aluno.getFiliado().getTelefone1().isEmpty() || !aluno.getFiliado().getTelefone2().isEmpty()) &&
			rgVal.validate(aluno.getFiliado().getRg()) &&
			enderecoVal.validate(aluno.getFiliado().getEndereco()) &&
			aluno.getFiliado().getFaixas().size() > 0 &&
			faixaVal.validate_list(aluno.getFiliado().getFaixas()))
		{
			return true;
		}
		return false;
	}
}