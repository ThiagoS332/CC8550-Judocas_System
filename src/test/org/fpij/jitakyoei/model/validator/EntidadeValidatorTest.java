package test.org.fpij.jitakyoei.model.validator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;

import main.java.org.fpij.jitakyoei.model.validator.EntidadeValidator;

public class EntidadeValidatorTest {

    private static Entidade entidade;
    private static Entidade entidadeTest;
	private static Endereco enderecoEntidade;

    private static EntidadeValidator entidadeValidator;

    @BeforeAll
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);

		entidadeValidator = new EntidadeValidator();

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

    }

    @Test
	public static void entidadeValidatorAllFieldsCompletedTest(){
		entidadeTest = entidade;
		
		assertEquals(true, entidadeValidator.validate(entidadeTest));
	}

    @Test
	public static void entidadeValidatorEmptyCnpjTest(){
		entidadeTest = entidade;

		entidadeTest.setCnpj("");

		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEmptyNomeTest(){
		entidadeTest = entidade;

		entidadeTest.setNome("");

		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEmptyTelefone1Test(){
		entidadeTest = entidade;

		entidadeTest.setTelefone1("");

		assertEquals(true, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEmptyTelefone2Test(){
		entidadeTest = entidade;

		entidadeTest.setTelefone2("");

		assertEquals(true, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEmptyBothTelefoneTest(){
		entidadeTest = entidade;

		entidadeTest.setTelefone1("");
		entidadeTest.setTelefone2("");

		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEnderecoEmptyBairroTest(){
		entidadeTest = entidade;

		entidadeTest.getEndereco().setBairro("");
		
		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEnderecoEmptyCepTest(){
		entidadeTest = entidade;

		entidadeTest.getEndereco().setCep("");
		
		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEnderecoEmptyCidadeTest(){
		entidadeTest = entidade;

		entidadeTest.getEndereco().setCidade("");
		
		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEnderecoEmptyEstadoTest(){
		entidadeTest = entidade;

		entidadeTest.getEndereco().setEstado("");
		
		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEnderecoEmptyNumeroTest(){
		entidadeTest = entidade;

		entidadeTest.getEndereco().setNumero("");
		
		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

	@Test
	public static void entidadeValidatorEnderecoEmptyRuaTest(){
		entidadeTest = entidade;

		entidadeTest.getEndereco().setRua("");
		
		assertEquals(false, entidadeValidator.validate(entidadeTest));
	}

    
}
