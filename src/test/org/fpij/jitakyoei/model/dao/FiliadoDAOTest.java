package test.org.fpij.jitakyoei.model.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Faixa;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Rg;
import main.java.org.fpij.jitakyoei.model.dao.DAO;
import main.java.org.fpij.jitakyoei.model.dao.DAOImpl;
import main.java.org.fpij.jitakyoei.util.CorFaixa;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;


public class FiliadoDAOTest {

    private static DAO<Filiado> filiadoDao;
    private static Endereco endereco;
	private static Filiado filiado;
    private static Rg rg;
    private static Faixa faixa_1;
    private static Faixa faixa_2;
	private static Faixa faixa_3;
    private static List<Faixa> faixas;
	private static List<Faixa> faixas_2;
	
	@BeforeAll
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);

        endereco = new Endereco();
		endereco.setBairro("Dirceu");
		endereco.setCep("64078-213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setRua("Rua Des. Berilo Mota");

        rg = new Rg();
        rg.setNumero("227080419");
        rg.setOrgaoExpedidor("Secretaria de Segurança Pública");

        faixa_1 = new Faixa();
        faixa_1.setCor(CorFaixa.BRANCA);
        faixa_1.setDataEntrega(new Date());

        faixa_2 = new Faixa();
		faixa_2.setCor(CorFaixa.CINZA);
        faixa_2.setDataEntrega(new Date());

        faixas = new ArrayList<>();

        faixas.add(faixa_1);
        faixas.add(faixa_2);
		
		filiado = new Filiado();
		filiado.setNome("Dan");
		filiado.setCpf("03646445327");
        filiado.setRg(rg);
		filiado.setDataNascimento(new Date());
		filiado.setDataCadastro(new Date());
		filiado.setId(3332L);
        filiado.setRegistroCbj("");
        filiado.setTelefone1("(86)1122-0406");
        filiado.setTelefone2("(86)90154-8540");
        filiado.setEmail("dan.ific@da.co");
        filiado.setFaixas(faixas);
        filiado.setObservacoes("Observação teste");
		filiado.setEndereco(endereco);
		
		filiadoDao = new DAOImpl<Filiado>(Filiado.class);
	}

	public static void clearDatabase(){
		List<Filiado> all = filiadoDao.list();
		for (Filiado each : all) {
			filiadoDao.delete(each);
		}
		assertEquals(0, filiadoDao.list().size());
	}

    @Test
	public void  testSalvarFiliadoComAssociassoes() throws Exception{
		clearDatabase();
		
		filiadoDao.save(filiado);
		assertEquals("03646445327", filiadoDao.get(filiado).getCpf());
		assertEquals("Dan", filiadoDao.get(filiado).getNome());
        assertEquals("227080419", filiadoDao.get(filiado).getRg().getNumero());
        assertEquals("Cinza", filiadoDao.get(filiado).getFaixas().get(1).getCor().getDescricao());
		assertEquals("Dirceu", filiadoDao.get(filiado).getEndereco().getBairro());
        
	}
	
	@Test
	public void testUpdateFiliado() throws Exception{
		clearDatabase();
		assertEquals(0, filiadoDao.list().size());
		
		filiadoDao.save(filiado);
		assertEquals(1, filiadoDao.list().size());
		assertEquals("Dan", filiadoDao.get(filiado).getNome());

		faixa_3 = new Faixa();
		faixa_3.setCor(CorFaixa.AZUL);
        faixa_3.setDataEntrega(new Date());

		faixas_2 = new ArrayList<>();

		faixas_2.add(faixa_1);
		faixas_2.add(faixa_2);
		faixas_2.add(faixa_3);
		
		Filiado f1 = filiadoDao.get(filiado);
		f1.setNome("TesteUpdate");
        f1.getEndereco().setRua("Rua TesteUpdate");
		f1.setFaixas(faixas_2);
		f1.setObservacoes("TesteObservacao");
		filiadoDao.save(f1);
		
		Filiado f2 = filiadoDao.get(f1);
		assertEquals("TesteUpdate", f2.getNome());
        assertEquals("Rua TesteUpdate", f2.getEndereco().getRua());
		assertEquals("Azul", f2.getFaixas().get(3).getCor().getDescricao());
		assertEquals("TesteObservacao", f2.getObservacoes());
		assertEquals(1, filiadoDao.list().size());
	}

	@Test
	public void testCopyFiliado() throws Exception{
		clearDatabase();
		assertEquals(0, filiadoDao.list().size());
		
		filiadoDao.save(filiado);
		assertEquals(1, filiadoDao.list().size());
		assertEquals("03646445327", filiadoDao.get(filiado).getCpf());
		assertEquals("dan.ific@da.co", filiadoDao.get(filiado).getEmail());
		assertEquals("Cinza", filiadoDao.get(filiado).getFaixas().get(1).getCor().getDescricao());
		assertEquals("Teresina", filiadoDao.get(filiado).getEndereco().getCidade());

		faixa_3 = new Faixa();
		faixa_3.setCor(CorFaixa.AZUL);
        faixa_3.setDataEntrega(new Date());

		faixas_2 = new ArrayList<>();

		faixas_2.add(faixa_1);
		faixas_2.add(faixa_2);
		faixas_2.add(faixa_3);

		Filiado f1 = filiadoDao.get(filiado);
		f1.setCpf("00000001631");
		f1.setEmail("email.email@email.com");
		f1.setFaixas(faixas_2);
		f1.getEndereco().setCidade("TesteCidade");
		filiadoDao.save(f1);

		Filiado f2 = filiadoDao.get(filiado);
		f2.copyProperties(filiadoDao.get(filiado));
		filiadoDao.save(f2);
		assertEquals(1, filiadoDao.list().size());
		assertEquals("03646445327", filiadoDao.get(filiado).getCpf());
		assertEquals("dan.ific@da.co", filiadoDao.get(filiado).getEmail());
		assertEquals("Cinza", filiadoDao.get(filiado).getFaixas().get(1).getCor().getDescricao());
		assertEquals("Teresina", filiadoDao.get(filiado).getEndereco().getCidade());
	}

    @AfterAll
	public static void closeDatabase(){
		clearDatabase();
		DatabaseManager.close();
	}
    
}
