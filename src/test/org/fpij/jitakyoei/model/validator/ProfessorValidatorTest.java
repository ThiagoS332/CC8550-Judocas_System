package test.org.fpij.jitakyoei.model.validator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.model.beans.Faixa;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Professor;
import main.java.org.fpij.jitakyoei.model.beans.Rg;
import main.java.org.fpij.jitakyoei.util.CorFaixa;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;

import main.java.org.fpij.jitakyoei.model.validator.ProfessorValidator;

public class ProfessorValidatorTest {

    private static Entidade entidade;
	private static Endereco enderecoEntidade;
	private static Entidade entidade_1;
	private static Endereco enderecoEntidade_1;
	private static Entidade entidade_2;
	private static Endereco enderecoEntidade_2;
	
	private static Professor professor;
    private static Professor professorTest;
	private static Endereco enderecoProfessor;
	private static Rg rgProfessor;
	private static Faixa faixaProfessor_1;
    private static Faixa faixaProfessor_2;
	private static Faixa faixaProfessor_3;
    private static List<Faixa> faixasProfessor;
	private static Filiado filiadoProf;
	private static List<Entidade> entidades;

    private static ProfessorValidator professorValidator;

    @BeforeAll
	public static void setUp(){
        DatabaseManager.setEnviroment(DatabaseManager.TEST);

		professorValidator = new ProfessorValidator();

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
		enderecoEntidade_2 = new Endereco();
		enderecoEntidade_2.setBairro("Morro Entidade");
		enderecoEntidade_2.setCep("24078213");
		enderecoEntidade_2.setCidade("Teresina");
		enderecoEntidade_2.setEstado("PI");
		enderecoEntidade_2.setNumero("22");
		enderecoEntidade_2.setRua("Rua Entidade 2");

		entidade_2 = new Entidade();
		entidade_2.setCnpj("87654321000298");
		entidade_2.setEndereco(enderecoEntidade_2);
		entidade_2.setNome("Academia 3");
		entidade_2.setTelefone1("");
		entidade_2.setTelefone2("(086)3333-2202");
		
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
        entidades.add(entidade_2);
		
		professor = new Professor();
		professor.setFiliado(filiadoProf);
		professor.setEntidades(entidades);

    }

    @Test
	public static void professorValidatorAllFieldsCompletedTest(){
		professorTest = professor;

		assertEquals(true, professorValidator.validate(professorTest));
	}

    @Test
	public static void professorValidatorFiliadoEmptyCpfTest(){
		professorTest = professor;

		professorTest.getFiliado().setCpf("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyDataCadastroTest(){
		professorTest = professor;

		professorTest.getFiliado().setDataCadastro(null);
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyDataNascimentoTest(){
		professorTest = professor;

		professorTest.getFiliado().setDataNascimento(null);
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyEmailTest(){
		professorTest = professor;

		professorTest.getFiliado().setEmail("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyIdTest(){
		// ?????????????????
		professorTest = professor;

		professorTest.getFiliado().setId(null);
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyNomeTest(){
		professorTest = professor;

		professorTest.getFiliado().setNome("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyObservacaoTest(){
		professorTest = professor;

		professorTest.getFiliado().setObservacoes("");
		
		assertEquals(true, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyRegistroCbjTest(){
		professorTest = professor;

		professorTest.getFiliado().setRegistroCbj("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyTelefone1Test(){
		professorTest = professor;

		professorTest.getFiliado().setTelefone1("");
		
		assertEquals(true, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyTelefone2Test(){
		professorTest = professor;

		professorTest.getFiliado().setTelefone2("");
		
		assertEquals(true, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyBothTelefoneTest(){
		professorTest = professor;

		professorTest.getFiliado().setTelefone1("");
		professorTest.getFiliado().setTelefone2("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEnderecoEmptyBairroTest(){
		professorTest = professor;

		professorTest.getFiliado().getEndereco().setBairro("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEnderecoEmptyCepTest(){
		professorTest = professor;

		professorTest.getFiliado().getEndereco().setCep("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEnderecoEmptyCidadeTest(){
		professorTest = professor;

		professorTest.getFiliado().getEndereco().setCidade("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEnderecoEmptyEstadoTest(){
		professorTest = professor;

		professorTest.getFiliado().getEndereco().setEstado("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEnderecoEmptyNumeroTest(){
		professorTest = professor;

		professorTest.getFiliado().getEndereco().setNumero("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEnderecoEmptyRuaTest(){
		professorTest = professor;

		professorTest.getFiliado().getEndereco().setRua("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoRgEmptyNumeroTest(){
		professorTest = professor;

		professorTest.getFiliado().getRg().setNumero("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoRgEmptyOrgaoExpedidorTest(){
		professorTest = professor;

		professorTest.getFiliado().getRg().setOrgaoExpedidor("");
		
		assertEquals(false, professorValidator.validate(professorTest));
	}

	@Test
	public static void professorValidatorFiliadoEmptyFaixasTest(){
        professorTest = professor;

		professorTest.getFiliado().setFaixas(null);
		
		assertEquals(false, professorValidator.validate(professor));
	}
    
}
