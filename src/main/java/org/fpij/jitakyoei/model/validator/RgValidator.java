package main.java.org.fpij.jitakyoei.model.validator;

import main.java.org.fpij.jitakyoei.model.beans.Rg;

public class RgValidator implements Validator<Rg>{
    public boolean validate(Rg rg) {
		if(!rg.getNumero().isEmpty() || rg.getNumero().length() != 14){
			return true;
		}
		return false;
	}
}
