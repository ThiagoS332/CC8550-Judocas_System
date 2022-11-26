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

import main.java.org.fpij.jitakyoei.model.validator.AlunoValidator;

public class AlunoValidatorTest {

    private static DAO<Aluno> alunoDao;
	private static Aluno aluno;
	private static Aluno alunoTest;
	private static Endereco enderecoAluno;
	private static Rg rgAluno;
	private static Filiado filiadoAluno;

	private static Entidade entidade;
	private static Endereco enderecoEntidade;
	private static Entidade entidade_1;
	private static Endereco enderecoEntidade_1;
	// private static Entidade entidade_2;
	// private static Endereco enderecoEntidade_2;
	
	private static Professor professor;
	private static Endereco enderecoProfessor;
	private static Rg rgProfessor;
	private static Faixa faixaProfessor_1;
    private static Faixa faixaProfessor_2;
	private static Faixa faixaProfessor_3;
    private static List<Faixa> faixasProfessor;
	private static Filiado filiadoProf;
	private static List<Entidade> entidades;

	private static AlunoValidator alunoValidator;

	@BeforeAll
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);

		alunoValidator = new AlunoValidator();

        // Entidades
		// Entidade
		enderecoEntidade = new Endereco();
		enderecoEntidade.setBairro("Entidade");
		enderecoEntidade.setCep("04078213");
		enderecoEntidade.setCidade("Teresina");
		enderecoEntidade.setEstado("PI");
		enderecoEntidade.setNumero("20");
		enderecoEntidade.setRua("Rua Entidade");

		entidade = new Entidade();
		entidade.setCnpj("80641845000178");
		entidade.setEndereco(enderecoEntidade);
		entidade.setNome("Academia 1");
		entidade.setTelefone1("(086)1111-0001");
		entidade.setTelefone2("(086)1111-0002");

		// Entidade 1
		enderecoEntidade_1 = new Endereco();
		enderecoEntidade_1.setBairro("Vila Entidade");
		enderecoEntidade_1.setCep("14078213");
		enderecoEntidade_1.setCidade("Teresina");
		enderecoEntidade_1.setEstado("PI");
		enderecoEntidade_1.setNumero("21");
		enderecoEntidade_1.setRua("Rua Entidade 1");

		entidade_1 = new Entidade();
		entidade_1.setCnpj("12345678000101");
		entidade_1.setEndereco(enderecoEntidade_1);
		entidade_1.setNome("Academia 2");
		entidade_1.setTelefone1("(086)2222-1101");
		entidade_1.setTelefone2("");

		// Entidade 2
		// enderecoEntidade_2 = new Endereco();
		// enderecoEntidade_2.setBairro("Morro Entidade");
		// enderecoEntidade_2.setCep("24078213");
		// enderecoEntidade_2.setCidade("Teresina");
		// enderecoEntidade_2.setEstado("PI");
		// enderecoEntidade_2.setNumero("22");
		// enderecoEntidade_2.setRua("Rua Entidade 2");

		// entidade_2 = new Entidade();
		// entidade_2.setCnpj("87654321000298");
		// entidade_2.setEndereco(enderecoEntidade_2);
		// entidade_2.setNome("Academia 3");
		// entidade_2.setTelefone1("");
		// entidade_2.setTelefone2("(086)3333-2202");
		
		// Professor
		enderecoProfessor = new Endereco();
		enderecoProfessor.setBairro("Bairro");
		enderecoProfessor.setCep("12345678");
		enderecoProfessor.setCidade("Cidade");
		enderecoProfessor.setEstado("PI");
		enderecoProfessor.setNumero("007");
		enderecoProfessor.setRua("Rua Professor Algébrio");

		rgProfessor = new Rg();
		rgProfessor.setNumero("987654321");
		rgProfessor.setOrgaoExpedidor("Secretária de Expedição de RGs");

		faixaProfessor_1 = new Faixa();
        faixaProfessor_1.setCor(CorFaixa.BRANCA);
        faixaProfessor_1.setDataEntrega(new Date());

		faixaProfessor_2 = new Faixa();
        faixaProfessor_2.setCor(CorFaixa.VERDE);
        faixaProfessor_2.setDataEntrega(new Date());

		faixaProfessor_3 = new Faixa();
        faixaProfessor_3.setCor(CorFaixa.PRETA2DAN);
        faixaProfessor_3.setDataEntrega(new Date());

		faixasProfessor = new ArrayList<>();
        faixasProfessor.add(faixaProfessor_1);
        faixasProfessor.add(faixaProfessor_2);
		faixasProfessor.add(faixaProfessor_3);
		
		filiadoProf = new Filiado();
		filiadoProf.setCpf("03646445327");
		filiadoProf.setDataCadastro(new Date());
		filiadoProf.setDataNascimento(new Date());
		filiadoProf.setEmail("professor@email.com");
		filiadoProf.setEndereco(enderecoProfessor);
		filiadoProf.setFaixas(faixasProfessor);
		filiadoProf.setId(3332L);
		filiadoProf.setNome("Roberto");
		filiadoProf.setObservacoes("");
		filiadoProf.setRegistroCbj("13");
		filiadoProf.setRg(rgProfessor);
		filiadoProf.setTelefone1("(086)1234-9876");
		filiadoProf.setTelefone2("(086)98524-3614");

		entidades = new ArrayList<>();
        entidades.add(entidade);
        entidades.add(entidade_1);
        // entidades.add(entidade_2);
		
		professor = new Professor();
		professor.setFiliado(filiadoProf);
		professor.setEntidades(entidades);

		// Aluno
		enderecoAluno = new Endereco();
		enderecoAluno.setBairro("Amambai");
		enderecoAluno.setCep("79005671");
		enderecoAluno.setCidade("Campo Grande");
		enderecoAluno.setEstado("MS");
		enderecoAluno.setNumero("12");
		enderecoAluno.setRua("Avenida das Bandeiras");

		rgAluno = new Rg();
		rgAluno.setNumero("123456789");
		rgAluno.setOrgaoExpedidor("Secretária de Expedição de RGs");

		filiadoAluno = new Filiado();
		filiadoAluno.setCpf("03646445327");
		filiadoAluno.setDataCadastro(new Date());
		filiadoAluno.setDataNascimento(new Date());
		filiadoAluno.setEmail("null@email.com");
		filiadoAluno.setEndereco(enderecoAluno);
		filiadoAluno.setFaixas(null);
		filiadoAluno.setId(1332L);
		filiadoAluno.setNome("Aécio");
		filiadoAluno.setObservacoes("Aluno iniciante");
		filiadoAluno.setRegistroCbj("12");
		filiadoAluno.setRg(rgAluno);
		filiadoAluno.setTelefone1("(086)1234-9876");
		filiadoAluno.setTelefone2("");
		
		aluno = new Aluno();
		aluno.setEntidade(entidade);
		aluno.setFiliado(filiadoAluno);
		aluno.setProfessor(professor);
		
		alunoDao = new DAOImpl<Aluno>(Aluno.class);

		alunoDao.save(aluno);
	}

	public static void clearDatabase(){
		List<Aluno> all = alunoDao.list();
		for (Aluno each : all) {
			alunoDao.delete(each);
		}
		assertEquals(0, alunoDao.list().size());
	}

	@Test
	public static void alunoValidatorAllFieldsCompletedTest(){
		alunoTest = aluno;

		assertEquals(true, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEmptyCnpjTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().setCnpj("");

		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEmptyNomeTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().setNome("");

		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEmptyTelefone1Test(){
		alunoTest = aluno;

		alunoTest.getEntidade().setTelefone1("");

		assertEquals(true, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEmptyTelefone2Test(){
		alunoTest = aluno;

		alunoTest.getEntidade().setTelefone2("");

		assertEquals(true, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEmptyBothTelefoneTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().setTelefone1("");
		alunoTest.getEntidade().setTelefone2("");

		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEnderecoEmptyBairroTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().getEndereco().setBairro("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEnderecoEmptyCepTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().getEndereco().setCep("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEnderecoEmptyCidadeTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().getEndereco().setCidade("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEnderecoEmptyEstadoTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().getEndereco().setEstado("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEnderecoEmptyNumeroTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().getEndereco().setNumero("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorEntidadeEnderecoEmptyRuaTest(){
		alunoTest = aluno;

		alunoTest.getEntidade().getEndereco().setRua("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyCpfTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setCpf("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyDataCadastroTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setDataCadastro(null);
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyDataNascimentoTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setDataNascimento(null);
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyEmailTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setEmail("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyIdTest(){
		// ?????????????????
		alunoTest = aluno;

		alunoTest.getFiliado().setId(null);
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyNomeTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setNome("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyObservacaoTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setObservacoes("");
		
		assertEquals(true, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyRegistroCbjTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setRegistroCbj("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyTelefone1Test(){
		alunoTest = aluno;

		alunoTest.getFiliado().setTelefone1("");
		
		assertEquals(true, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyTelefone2Test(){
		alunoTest = aluno;

		alunoTest.getFiliado().setTelefone2("");
		
		assertEquals(true, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyBothTelefoneTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setTelefone1("");
		alunoTest.getFiliado().setTelefone2("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEnderecoEmptyBairroTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().getEndereco().setBairro("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEnderecoEmptyCepTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().getEndereco().setCep("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEnderecoEmptyCidadeTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().getEndereco().setCidade("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEnderecoEmptyEstadoTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().getEndereco().setEstado("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEnderecoEmptyNumeroTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().getEndereco().setNumero("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEnderecoEmptyRuaTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().getEndereco().setRua("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoRgEmptyNumeroTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().getRg().setNumero("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoRgEmptyOrgaoExpedidorTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().getRg().setOrgaoExpedidor("");
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorFiliadoEmptyFaixasTest(){
		alunoTest = aluno;

		alunoTest.getFiliado().setFaixas(null);
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorProfessorEmptyEntidadesTest(){
		alunoTest = aluno;

		alunoTest.getProfessor().setEntidades(null);
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}

	@Test
	public static void alunoValidatorProfessorEmptyFiliadoTest(){
		alunoTest = aluno;

		alunoTest.getProfessor().setFiliado(null);
		
		assertEquals(false, alunoValidator.validate(alunoTest));
	}
    
	@AfterAll
	public static void closeDatabase(){
		clearDatabase();
		DatabaseManager.close();
	}

}
