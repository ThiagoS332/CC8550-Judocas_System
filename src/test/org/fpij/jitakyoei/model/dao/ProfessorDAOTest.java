package test.org.fpij.jitakyoei.model.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Professor;
import main.java.org.fpij.jitakyoei.model.dao.DAO;
import main.java.org.fpij.jitakyoei.model.dao.DAOImpl;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;

public class ProfessorDAOTest {

    private static DAO<Professor> professorDao;
	private static Entidade entidade;
    private static Entidade entidade_1;
    private static Entidade entidade_2;
    private static List<Entidade> entidades;
	private static Endereco endereco;
    private static Endereco endereco_1;
    private static Endereco endereco_2;
	private static Filiado filiadoProf;
	private static Professor professor;
	
	@BeforeAll
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);
		
		endereco = new Endereco();
		endereco.setBairro("Dirceu");
		endereco.setCep("64078-213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setRua("Rua Des. Berilo Mota");
		
		filiadoProf = new Filiado();
		filiadoProf.setNome("Professor");
		filiadoProf.setCpf("036.464.453-27");
		filiadoProf.setDataNascimento(new Date());
		filiadoProf.setDataCadastro(new Date());
		filiadoProf.setId(3332L);
		filiadoProf.setEndereco(endereco);

        entidade = new Entidade();
		entidade.setEndereco(endereco);
		entidade.setNome("Academia 1");
		entidade.setTelefone1("(086)1234-5432");

        endereco_1 = new Endereco();
		endereco_1.setBairro("Amambai");
		endereco_1.setCep("79005-671");
		endereco_1.setCidade("Campo Grande");
		endereco_1.setEstado("MS");
		endereco_1.setRua("Avenida das Bandeiras");

        entidade_1 = new Entidade();
		entidade_1.setEndereco(endereco_1);
		entidade_1.setNome("Academia 2");
		entidade_1.setTelefone1("(067)4891-5364");

        endereco_2 = new Endereco();
		endereco_2.setBairro("Guilhermina");
		endereco_2.setCep("02052-001");
		endereco_2.setCidade("São Paulo");
		endereco_2.setEstado("SP");
		endereco_2.setRua("Rua Doze de Setembro");

        entidade_2 = new Entidade();
		entidade_2.setEndereco(endereco_2);
		entidade_2.setNome("Academia 3");
		entidade_2.setTelefone1("(011)9984-2147");

        entidades = new ArrayList<>();

        entidades.add(entidade);
        entidades.add(entidade_1);
        entidades.add(entidade_2);
		
		professor = new Professor();
		professor.setFiliado(filiadoProf);
        professor.setEntidades(entidades);
		
		professorDao = new DAOImpl<Professor>(Professor.class);
	}

	public static void clearDatabase(){
		List<Professor> all = professorDao.list();
		for (Professor each : all) {
			professorDao.delete(each);
		}
		assertEquals(0, professorDao.list().size());
	}

    @Test
	public void  testSalvarProfessorComAssociassoes() throws Exception{
		clearDatabase();
		
		professorDao.save(professor);
		assertEquals("036.464.453-27", professorDao.get(professor).getFiliado().getCpf());
		assertEquals("Professor", professorDao.get(professor).getFiliado().getNome());
		assertEquals("Academia 1", professorDao.get(professor).getEntidades().get(0).getNome());
		assertEquals("Guilhermina", professorDao.get(professor).getEntidades().get(2).getEndereco().getBairro());
	}
	
	@Test
	public void testUpdateProfessor() throws Exception{
		clearDatabase();
		assertEquals(0, professorDao.list().size());
		
		professorDao.save(professor);
		assertEquals(1, professorDao.list().size());
		assertEquals("Professor", professorDao.get(professor).getFiliado().getNome());
		
		Professor p1 = professorDao.get(professor);
		p1.getFiliado().setNome("TesteUpdate");
        p1.getEntidades().get(0).getEndereco().setRua("Rua TesteUpdate");
		professorDao.save(p1);
		
		Professor p2 = professorDao.get(p1);
		assertEquals("TesteUpdate", p2.getFiliado().getNome());
        assertEquals("Rua TesteUpdate", p2.getEntidades().get(0).getEndereco().getRua());
		assertEquals(1, professorDao.list().size());
	}

    @AfterAll
	public static void closeDatabase(){
		clearDatabase();
		DatabaseManager.close();
	}
    
}
