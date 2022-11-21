package test.org.fpij.jitakyoei.model.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import main.java.org.fpij.jitakyoei.model.beans.Aluno;
import main.java.org.fpij.jitakyoei.model.beans.Endereco;
import main.java.org.fpij.jitakyoei.model.beans.Entidade;
import main.java.org.fpij.jitakyoei.model.beans.Filiado;
import main.java.org.fpij.jitakyoei.model.beans.Professor;
import main.java.org.fpij.jitakyoei.model.dao.DAO;
import main.java.org.fpij.jitakyoei.model.dao.DAOImpl;
import main.java.org.fpij.jitakyoei.util.DatabaseManager;

public class AlunoDaoTest {
	
	private static DAO<Aluno> alunoDao;
	private static Aluno aluno;
	private static Aluno aluno_1;
	private static Aluno aluno_2;
	private static Aluno aluno_3;
	private static Aluno aluno_4;
	private static Aluno aluno_5;
	private static Entidade entidade;
	private static Endereco endereco;
	private static Filiado f1;
	private static Filiado filiadoProf;
	private static Professor professor;
	
	@BeforeAll
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);
		f1 = new Filiado();
		f1.setNome("Aécio");
		f1.setCpf("03646445327");
		f1.setDataNascimento(new Date());
		f1.setDataCadastro(new Date());
		f1.setId(1332L);
		
		endereco = new Endereco();
		endereco.setBairro("Dirceu");
		endereco.setCep("64078-213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setRua("Rua Des. Berilo Mota");
		
		filiadoProf = new Filiado();
		filiadoProf.setNome("Professor");
		filiadoProf.setCpf("03646445327");
		filiadoProf.setDataNascimento(new Date());
		filiadoProf.setDataCadastro(new Date());
		filiadoProf.setId(3332L);
		filiadoProf.setEndereco(endereco);
		
		professor = new Professor();
		professor.setFiliado(filiadoProf);
		
		entidade = new Entidade();
		entidade.setEndereco(endereco);
		entidade.setNome("Academia 1");
		entidade.setTelefone1("(086)1234-5432");
		
		aluno = new Aluno();
		aluno.setFiliado(f1);
		aluno.setProfessor(professor);
		aluno.setEntidade(entidade);
		
		alunoDao = new DAOImpl<Aluno>(Aluno.class);
	}

	public static void clearDatabase(){
		List<Aluno> all = alunoDao.list();
		for (Aluno each : all) {
			alunoDao.delete(each);
		}
		assertEquals(0, alunoDao.list().size());
	}
	
	
	@Test
	public void  testSalvarAlunoComAssociassoes() throws Exception{
		clearDatabase();
		
		alunoDao.save(aluno);
		assertEquals("03646445327", alunoDao.get(aluno).getFiliado().getCpf());
		assertEquals("Aécio", alunoDao.get(aluno).getFiliado().getNome());
		assertEquals("Professor", alunoDao.get(aluno).getProfessor().getFiliado().getNome());
		assertEquals("Dirceu", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getBairro());
	}
	
	@Test
	public void testUpdateAluno() throws Exception{
		clearDatabase();
		assertEquals(0, alunoDao.list().size());
		
		alunoDao.save(aluno);
		assertEquals(1, alunoDao.list().size());
		assertEquals("Aécio", aluno.getFiliado().getNome());
		
		Aluno a1 = alunoDao.get(aluno);
		a1.getFiliado().setNome("TesteUpdate");
		alunoDao.save(a1);
		
		Aluno a2 = alunoDao.get(a1);
		assertEquals("TesteUpdate", a2.getFiliado().getNome());
		assertEquals(1, alunoDao.list().size());
	}
	
	@Test
	public void testListarEAdicionarAlunos(){
		int qtd = alunoDao.list().size();

		f1 = new Filiado();
		f1.setNome("Aécio");
		f1.setCpf("03646445327");
		f1.setDataNascimento(new Date());
		f1.setDataCadastro(new Date());
		f1.setId(1332L);
		
		endereco = new Endereco();
		endereco.setBairro("Dirceu");
		endereco.setCep("64078-213");
		endereco.setCidade("Teresina");
		endereco.setEstado("PI");
		endereco.setRua("Rua Des. Berilo Mota");
		
		filiadoProf = new Filiado();
		filiadoProf.setNome("Professor");
		filiadoProf.setCpf("03646445327");
		filiadoProf.setDataNascimento(new Date());
		filiadoProf.setDataCadastro(new Date());
		filiadoProf.setId(3332L);
		filiadoProf.setEndereco(endereco);
		
		professor = new Professor();
		professor.setFiliado(filiadoProf);
		
		entidade = new Entidade();
		entidade.setEndereco(endereco);
		entidade.setNome("Academia 1");
		entidade.setTelefone1("(086)1234-5432");
		
		aluno_1 = new Aluno();
		aluno_1.setFiliado(f1);
		aluno_1.setProfessor(professor);
		aluno_1.setEntidade(entidade);
		
		alunoDao.save(aluno_1);
		assertEquals(qtd+1, alunoDao.list().size());
		
		aluno_2 = new Aluno();
		aluno_2.setFiliado(f1);
		aluno_2.setProfessor(professor);
		aluno_2.setEntidade(entidade);

		alunoDao.save(aluno_2);
		assertEquals(qtd+2, alunoDao.list().size());

		aluno_3 = new Aluno();
		aluno_3.setFiliado(f1);
		aluno_3.setProfessor(professor);
		aluno_3.setEntidade(entidade);
		
		alunoDao.save(aluno_3);
		assertEquals(qtd+3, alunoDao.list().size());

		aluno_4 = new Aluno();
		aluno_4.setFiliado(f1);
		aluno_4.setProfessor(professor);
		aluno_4.setEntidade(entidade);
		
		alunoDao.save(aluno_4);
		assertEquals(qtd+4, alunoDao.list().size());
		
		clearDatabase();
		assertEquals(0, alunoDao.list().size());

		aluno_5 = new Aluno();
		aluno_5.setFiliado(f1);
		aluno_5.setProfessor(professor);
		aluno_5.setEntidade(entidade);
		
		alunoDao.save(aluno_5);
		assertEquals(1, alunoDao.list().size());
	}
	
	@Test
	public void testSearchAluno() throws Exception{
		clearDatabase();
		alunoDao.save(aluno);
		
		Filiado f = new Filiado();
		f.setNome("Aécio");
		Aluno a = new Aluno();
		a.setFiliado(f);
		
		List<Aluno> result = alunoDao.search(a);
		assertEquals(1, result.size());
		assertEquals("03646445327", result.get(0).getFiliado().getCpf());
		
		clearDatabase();
		assertEquals(0, alunoDao.search(a).size());
	}

	@Test
	public void testCopyProperties() throws Exception{
		clearDatabase();
		assertEquals(0, alunoDao.list().size());

		Filiado fp = new Filiado();
		fp.setNome("Rogério");
		Professor p = new Professor();
		p.setFiliado(fp);

		Filiado f = new Filiado();
		f.setNome("Aécio");
		Entidade e = new Entidade();
		e.setNome("null");

		Aluno a = new Aluno();
		a.setFiliado(f);
		a.setProfessor(p);
		a.setEntidade(e);
		
		alunoDao.save(a);
		assertEquals(1, alunoDao.list().size());
		assertEquals("Aécio", a.getFiliado().getNome());
		
		Aluno a1 = alunoDao.get(a);
		a1.getFiliado().setNome("TesteCopia");
		a1.getProfessor().getFiliado().setNome("ProfessorTesteCopia");
		a1.getEntidade().setNome("AcademiaTesteCopia");
		alunoDao.save(a1);
		
		Aluno a2 = alunoDao.get(a);
		a2.copyProperties(a1);
		alunoDao.save(a2);
		assertEquals("TesteCopia", a2.getFiliado().getNome());
		assertEquals("ProfessorTesteCopia", a2.getProfessor().getFiliado().getNome());
		assertEquals("AcademiaTesteCopia", a2.getEntidade().getNome());
		assertEquals(1, alunoDao.list().size());
	}
	
	@AfterAll
	public static void closeDatabase(){
		clearDatabase();
		DatabaseManager.close();
	}
	
}
