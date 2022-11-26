package test.org.fpij.jitakyoei.model.validator;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Rg;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;

import main.java.org.fpij.jitakyoei.model.validator.RgValidator;

public class RgValidatorTest {

    private static Rg rg;
    private static Rg rgTest;

    private static RgValidator rgValidator;

    @BeforeAll
	public static void setUp(){
        DatabaseManager.setEnviroment(DatabaseManager.TEST);

		rgValidator = new RgValidator();

        rg = new Rg();
		rg.setNumero("123456789");
		rg.setOrgaoExpedidor("Secretária de Expedição de RGs");
    }

	@Test
	public static void rgValidatorAllFieldsCompletedTest(){
		rgTest = rg;
		
		assertEquals(true, rgValidator.validate(rgTest));
	}

	@Test
	public static void rgValidatorEmptyNumeroTest(){
		rgTest = rg;

		rgTest.setNumero("");
		
		assertEquals(false, rgValidator.validate(rgTest));
	}

	@Test
	public static void rgValidatorEmptyOrgaoExpedidorTest(){
		rgTest = rg;

		rgTest.setOrgaoExpedidor("");
		
		assertEquals(false, rgValidator.validate(rgTest));
	}

}
