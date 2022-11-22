package test.org.fpij.jitakyoei.model.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.dao.DAO;
import main.java.org.fpij.jitakyoei.model.dao.DAOImpl;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;

public class EnderecoDaoTest {
    
    private static DAO<Endereco> enderecoDao;
    private static Endereco endereco;

    @BeforeAll
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);

        endereco = new Endereco();
		endereco.setBairro("Dirceu");
		endereco.setCep("64078213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setRua("Rua Des. Berilo Mota");
		
		enderecoDao = new DAOImpl<Endereco>(Endereco.class);
	}

	public static void clearDatabase(){
		List<Endereco> all = enderecoDao.list();
		for (Endereco each : all) {
			enderecoDao.delete(each);
		}
		assertEquals(0, enderecoDao.list().size());
	}

    @Test
	public void  testSalvarEnderecoComAssociassoes() throws Exception{
		clearDatabase();
		
		enderecoDao.save(endereco);
		assertEquals("Dirceu", enderecoDao.get(endereco).getBairro());
        assertEquals("64078213", enderecoDao.get(endereco).getCep());
        assertEquals("Teresina", enderecoDao.get(endereco).getCidade());
        assertEquals("PI", enderecoDao.get(endereco).getEstado());
        assertEquals("Rua Des. Berilo Mota", enderecoDao.get(endereco).getRua());
        
	}

    @Test
	public void testEnderecoUpdate() throws Exception{
		clearDatabase();
		assertEquals(0, enderecoDao.list().size());
		
		enderecoDao.save(endereco);
		assertEquals(1, enderecoDao.list().size());
		assertEquals("Dirceu", enderecoDao.get(endereco).getBairro());

        Endereco e1 = enderecoDao.get(endereco);
        e1 = new Endereco();
		e1.setBairro("Amambai");
		e1.setCep("79005671");
		e1.setCidade("Campo Grande");
		e1.setEstado("MS");
		e1.setRua("Avenida das Bandeiras");
		enderecoDao.save(e1);
		
		Endereco e2 = enderecoDao.get(e1);
        assertEquals("Amambai", e2.getBairro());
        assertEquals("79005671", e2.getCep());
        assertEquals("Campo Grande", e2.getCidade());
        assertEquals("MS", e2.getEstado());
        assertEquals("Avenida das Bandeiras", e2.getRua());
		assertEquals(1, enderecoDao.list().size());
        
	}

    // @Test
	// public void testEnderecotoString() throws Exception{
	// 	clearDatabase();
	// 	assertEquals(0, enderecoDao.list().size());
		
	// 	enderecoDao.save(endereco);
	// 	assertEquals(1, enderecoDao.list().size());
	// 	assertEquals("Dirceu", enderecoDao.get(endereco).getBairro());

        
	// }

    @AfterAll
	public static void closeDatabase(){
		clearDatabase();
		DatabaseManager.close();
	}

}
