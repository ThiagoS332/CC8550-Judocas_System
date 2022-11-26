package test.org.fpij.jitakyoei.model.validator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;

import main.java.org.fpij.jitakyoei.model.validator.EnderecoValidator;

public class EnderecoValidatorTest {

    private static Endereco endereco;
    private static Endereco enderecoTest;

    private static EnderecoValidator enderecoValidator;

    @BeforeAll
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);

		enderecoValidator = new EnderecoValidator();

		endereco = new Endereco();
		endereco.setBairro("Entidade");
		endereco.setCep("04078213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setNumero("20");
		endereco.setRua("Rua Entidade");

    }

    @Test
	public static void enderecoValidatorAllFieldsCompletedTest(){
		enderecoTest = endereco;
		
		assertEquals(true, enderecoValidator.validate(enderecoTest));
	}


    @Test
	public static void enderecoValidatorEmptyBairroTest(){
		enderecoTest = endereco;

		enderecoTest.setBairro("");
		
		assertEquals(false, enderecoValidator.validate(enderecoTest));
	}

	@Test
	public static void enderecoValidatorEmptyCepTest(){
		enderecoTest = endereco;

		enderecoTest.setCep("");
		
		assertEquals(false, enderecoValidator.validate(enderecoTest));
	}

	@Test
	public static void enderecoValidatorEmptyCidadeTest(){
		enderecoTest = endereco;

		enderecoTest.setCidade("");
		
		assertEquals(false, enderecoValidator.validate(enderecoTest));
	}

	@Test
	public static void enderecoValidatorEmptyEstadoTest(){
		enderecoTest = endereco;

		enderecoTest.setEstado("");
		
		assertEquals(false, enderecoValidator.validate(enderecoTest));
	}

	@Test
	public static void enderecoValidatorEmptyNumeroTest(){
		enderecoTest = endereco;

		enderecoTest.setNumero("");
		
		assertEquals(false, enderecoValidator.validate(enderecoTest));
	}

	@Test
	public static void enderecoValidatorEmptyRuaTest(){
		enderecoTest = endereco;

		enderecoTest.setRua("");
		
		assertEquals(false, enderecoValidator.validate(enderecoTest));
	}

    
}
