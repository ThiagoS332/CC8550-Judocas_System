package main.java.org.fpij.jitakyoei.model.validator;

import java.util.ArrayList;
import java.util.List;

import main.java.org.fpij.jitakyoei.model.beans.Entidade;

public class EntidadeValidator implements Validator<Entidade> {

    private EnderecoValidator enderecoVal = new EnderecoValidator();

    public boolean validate(Entidade entidade) {
		if(!entidade.getCnpj().isEmpty() &&
        !entidade.getNome().isEmpty() &&
        (!entidade.getTelefone1().isEmpty() || !entidade.getTelefone2().isEmpty()) &&
        enderecoVal.validate(entidade.getEndereco()))
		{
			return true;
		}
		return false;
	}

    public boolean validate_list(List<Entidade> entidades) {

        Entidade entidade;

        List<Boolean> validated_entidades_list = new ArrayList<Boolean>(entidades.size());

        for(int i = 0;i < entidades.size();i++){
            entidade = entidades.get(i);

            validated_entidades_list.add(this.validate(entidade));
        }

        for(int i = 0;i < validated_entidades_list.size();i++){

            if(!validated_entidades_list.get(i)){
                return false;
            }
        }

		return true;
	}
}
