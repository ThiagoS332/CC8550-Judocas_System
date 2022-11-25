package main.java.org.fpij.jitakyoei.model.validator;

import java.util.ArrayList;
import java.util.List;

import main.java.org.fpij.jitakyoei.model.beans.Faixa;

public class FaixaValidator implements Validator<Faixa> {
    public boolean validate(Faixa faixa) {
		if(faixa.getCor() != null && faixa.getDataEntrega() != null)
		{
			return true;
		}
		return false;
	}

    public boolean validate_list(List<Faixa> faixas) {

        Faixa faixa;

        List<Boolean> validated_faixas_list = new ArrayList<Boolean>(faixas.size());

        for(int i = 0;i < faixas.size();i++){
            faixa = faixas.get(i);

            validated_faixas_list.add(this.validate(faixa));
        }

        for(int i = 0;i < validated_faixas_list.size();i++){

            if(!validated_faixas_list.get(i)){
                return false;
            }
        }

		return true;
	}
}
