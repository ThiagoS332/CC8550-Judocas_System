package test.org.fpij.jitakyoei.model.validator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Aluno;
import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.model.beans.Faixa;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Professor;
import main.java.org.fpij.jitakyoei.model.beans.Rg;
import main.java.org.fpij.jitakyoei.model.dao.DAO;
import main.java.org.fpij.jitakyoei.model.dao.DAOImpl;
import main.java.org.fpij.jitakyoei.util.CorFaixa;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;


public class AlunoValidatorTest {

    private static DAO<Aluno> alunoDao;
	private static Aluno aluno;
	private static Endereco enderecoAluno;
	private static Rg rgAluno;
	private static Filiado filiadoAluno;

	private static Entidade entidade;
	private static Endereco enderecoEntidade;
	private static Entidade entidade_1;
	private static Endereco enderecoEntidade_1;
	private static Entidade entidade_2;
	private static Endereco enderecoEntidade_2;
	
	private static Professor professor;
	private static Endereco enderecoProfessor;
	private static Rg rgProfessor;
	private static Faixa faixaProfessor_1;
    private static Faixa faixaProfessor_2;
	private static Faixa faixaProfessor_3;
    private static List<Faixa> faixasProfessor;
	private static Filiado filiadoProf;
	private static List<Entidade> entidades;
    
}
