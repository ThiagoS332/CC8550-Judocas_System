package main.java.org.fpij.jitakyoei.business;

import java.util.List;

import main.java.org.fpij.jitakyoei.model.beans.Entidade;

public interface EntidadeBO {
	public void createEntidade(Entidade entidade) throws Exception;
	public void updateEntidade(Entidade entidade) throws Exception;
	public List<Entidade> searchEntidade(Entidade entidade) throws Exception;
	public List<Entidade> listAll() throws Exception;
}
