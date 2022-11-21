package main.java.org.fpij.jitakyoei.model.validator;

import main.java.org.fpij.jitakyoei.model.beans.Rg;

public class RgValidator implements Validator<Rg>{
    public boolean validate(Rg rg) {
		if(!rg.getNumero().isEmpty() || rg.getNumero().length() == 9 || !rg.getOrgaoExpedidor().isEmpty()){
			return true;
		}
		return false;
	}
}
