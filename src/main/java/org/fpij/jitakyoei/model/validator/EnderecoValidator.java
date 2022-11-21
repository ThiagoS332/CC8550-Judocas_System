package main.java.org.fpij.jitakyoei.model.validator;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;

public class EnderecoValidator implements Validator<Endereco> {
    public boolean validate(Endereco endereco) {
		if(!endereco.getBairro().isEmpty() && 
        !endereco.getCep().isEmpty() &&
        endereco.getCep().length() == 8 &&
        !endereco.getCidade().isEmpty() &&
        !endereco.getEstado().isEmpty() &&
        !endereco.getNumero().isEmpty() &&
        !endereco.getRua().isEmpty()){
			return true;
		}
		return false;
	}
}