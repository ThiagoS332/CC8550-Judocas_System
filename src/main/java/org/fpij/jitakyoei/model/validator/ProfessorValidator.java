package main.java.org.fpij.jitakyoei.model.validator;

import main.java.org.fpij.jitakyoei.model.beans.Professor;

public class ProfessorValidator implements Validator<Professor> {

    private RgValidator rgVal = new RgValidator();
	private EnderecoValidator enderecoVal = new EnderecoValidator();
	private EntidadeValidator entidadeVal = new EntidadeValidator();
	private FaixaValidator faixaVal = new FaixaValidator();

    public boolean validate(Professor professor) {
		if(!professor.getFiliado().getCpf().isEmpty() &&
            professor.getFiliado().getCpf().length() == 11 &&
            professor.getFiliado().getDataNascimento() != null &&
			!professor.getFiliado().getEmail().isEmpty() &&
			!professor.getFiliado().getNome().isEmpty() &&
			!professor.getFiliado().getRegistroCbj().isEmpty() &&
			(!professor.getFiliado().getTelefone1().isEmpty() || !professor.getFiliado().getTelefone2().isEmpty()) &&
			rgVal.validate(professor.getFiliado().getRg()) &&
			enderecoVal.validate(professor.getFiliado().getEndereco()) &&
			professor.getEntidades().size() > 0 &&
			entidadeVal.validate_list(professor.getEntidades()) &&
			professor.getFiliado().getFaixas().size() > 0 &&
			faixaVal.validate_list(professor.getFiliado().getFaixas()))
		{
			return true;
		}
		return false;
	}
    
}
