package test.org.fpij.jitakyoei.model.dao;

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

public class AlunoDaoTest {
	
	private static DAO<Aluno> alunoDao;
	private static Aluno aluno;
	private static Endereco enderecoAluno;
	private static Rg rgAluno;
	private static Filiado filiadoAluno;

	// private static Aluno aluno_1;
	// private static Aluno aluno_2;
	// private static Aluno aluno_3;
	// private static Aluno aluno_4;
	// private static Aluno aluno_5;

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
	
	@BeforeAll
	public static void setUp(){
		DatabaseManager.setEnviroment(DatabaseManager.TEST);

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
		filiadoAluno.setFaixas(faixasProfessor);
		filiadoProf.setId(3332L);
		filiadoProf.setNome("Roberto");
		filiadoAluno.setObservacoes("");
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

		// filiadoAluno = new Filiado();
		// filiadoAluno.setNome("Aécio");
		// filiadoAluno.setCpf("03646445327");
		// filiadoAluno.setDataNascimento(new Date());
		// filiadoAluno.setDataCadastro(new Date());
		// filiadoAluno.setId(1332L);
		
		// enderecoAluno = new Endereco();
		// enderecoAluno.setBairro("Dirceu");
		// enderecoAluno.setCep("64078213");
		// enderecoAluno.setCidade("Teresina");
		// enderecoAluno.setEstado("PI");
		// enderecoAluno.setRua("Rua Des. Berilo Mota");
		
		// filiadoProf = new Filiado();
		// filiadoProf.setNome("Professor");
		// filiadoProf.setCpf("03646445327");
		// filiadoProf.setDataNascimento(new Date());
		// filiadoProf.setDataCadastro(new Date());
		// filiadoProf.setId(3332L);
		// filiadoProf.setEndereco(enderecoAluno);
		
		// professor = new Professor();
		// professor.setFiliado(filiadoProf);
		
		// entidade = new Entidade();
		// entidade.setEndereco(enderecoAluno);
		// entidade.setNome("Academia 1");
		// entidade.setTelefone1("(086)1234-5432");
		
		// aluno = new Aluno();
		// aluno.setFiliado(filiadoAluno);
		// aluno.setProfessor(professor);
		// aluno.setEntidade(entidade);
		
		alunoDao.save(aluno);
		assertEquals(qtd+1, alunoDao.list().size());
		
		// aluno = new Aluno();
		// aluno.setFiliado(filiadoAluno);
		// aluno.setProfessor(professor);
		// aluno.setEntidade(entidade);

		alunoDao.save(aluno);
		assertEquals(qtd+2, alunoDao.list().size());

		// aluno = new Aluno();
		// aluno.setFiliado(filiadoAluno);
		// aluno.setProfessor(professor);
		// aluno.setEntidade(entidade);
		
		alunoDao.save(aluno);
		assertEquals(qtd+3, alunoDao.list().size());

		// aluno = new Aluno();
		// aluno.setFiliado(filiadoAluno);
		// aluno.setProfessor(professor);
		// aluno.setEntidade(entidade);
		
		alunoDao.save(aluno);
		assertEquals(qtd+4, alunoDao.list().size());
		
		clearDatabase();
		assertEquals(0, alunoDao.list().size());

		// aluno = new Aluno();
		// aluno.setFiliado(filiadoAluno);
		// aluno.setProfessor(professor);
		// aluno.setEntidade(entidade);
		
		alunoDao.save(aluno);
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
		a.setFiliado(filiadoAluno);
		a.setProfessor(professor);
		a.setEntidade(entidade);
		
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

	// Tests for all Get methods

	// Entidade
	@Test
	public void testGetEntidadeCnpj() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getCnpj();

		assertEquals("80641845000178", alunoDao.get(aluno).getEntidade().getCnpj());
		assertEquals("80641845000178", aluno.getEntidade().getCnpj());
	}

	@Test
	public void testGetEntidadeNome() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getNome();

		assertEquals("Academia 1", alunoDao.get(aluno).getEntidade().getNome());
		assertEquals("Academia 1", aluno.getEntidade().getNome());
	}

	@Test
	public void testGetEntidadeTelefone1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getTelefone1();

		assertEquals("(086)1111-0001", alunoDao.get(aluno).getEntidade().getTelefone1());
		assertEquals("(086)1111-0001", aluno.getEntidade().getTelefone1());
	}

	@Test
	public void testGetEntidadeTelefone2() throws Exception {
		clearDatabase();
		
		alunoDao.save(aluno);

		// aluno.getEntidade().getTelefone2();

		assertEquals("(086)1111-0002", alunoDao.get(aluno).getEntidade().getTelefone2());
		assertEquals("(086)1111-0002", aluno.getEntidade().getTelefone2());
	}

	@Test
	public void testGetEntidadeEnderecoBairro() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getEndereco().getBairro();
		
		assertEquals("Entidade", alunoDao.get(aluno).getEntidade().getEndereco().getBairro());
		assertEquals("Entidade", aluno.getEntidade().getEndereco().getBairro());
	}

	@Test
	public void testGetEntidadeEnderecoCep() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getEndereco().getCep();

		assertEquals("04078213", alunoDao.get(aluno).getEntidade().getEndereco().getCep());
		assertEquals("04078213", aluno.getEntidade().getEndereco().getCep());

	}

	@Test
	public void testGetEntidadeEnderecoCidade() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getEndereco().getCidade();

		assertEquals("Teresina", alunoDao.get(aluno).getEntidade().getEndereco().getCidade());
		assertEquals("Teresina", aluno.getEntidade().getEndereco().getCidade());

	}

	@Test
	public void testGetEntidadeEnderecoEstado() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getEndereco().getEstado();

		assertEquals("PI", alunoDao.get(aluno).getEntidade().getEndereco().getEstado());
		assertEquals("PI", aluno.getEntidade().getEndereco().getEstado());

	}

	@Test
	public void testGetEntidadeEnderecoNumero() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getEndereco().getNumero();

		assertEquals("20", alunoDao.get(aluno).getEntidade().getEndereco().getNumero());
		assertEquals("20", aluno.getEntidade().getEndereco().getNumero());

	}

	@Test
	public void testGetEntidadeEnderecoRua() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getEntidade().getEndereco().getRua();

		assertEquals("Rua Entidade", alunoDao.get(aluno).getEntidade().getEndereco().getRua());
		assertEquals("Rua Entidade", aluno.getEntidade().getEndereco().getRua());

	}

	// Filiado
	@Test
	public void testGetFiliadoCpf() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getFiliado().getCpf();

		assertEquals("03646445327", alunoDao.get(aluno).getFiliado().getCpf());
		assertEquals("03646445327", aluno.getFiliado().getCpf());


	}

	@Test
	public void testGetFiliadoEmail() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getEmail();

		assertEquals("null@email.com", alunoDao.get(aluno).getFiliado().getEmail());
		assertEquals("null@email.com", aluno.getFiliado().getEmail());

	}

	@Test
	public void testGetFiliadoId() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getId();

		String str_daoAlunoId = String.valueOf(alunoDao.get(aluno).getFiliado().getId());
		String str_alunoId = String.valueOf(aluno.getFiliado().getId());

		assertEquals("1332", str_daoAlunoId);
		assertEquals("1332", str_alunoId);

	}

	@Test
	public void testGetFiliadoNome() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getNome();

		assertEquals("Aécio", alunoDao.get(aluno).getFiliado().getNome());
		assertEquals("Aécio", aluno.getFiliado().getNome());

	}

	@Test
	public void testGetFiliadoObservacao() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getObservacoes();

		assertEquals("Aluno iniciante", alunoDao.get(aluno).getFiliado().getObservacoes());
		assertEquals("Aluno iniciante", aluno.getFiliado().getObservacoes());

	}

	@Test
	public void testGetFiliadoRegistroCbj() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getRegistroCbj();

		assertEquals("12", alunoDao.get(aluno).getFiliado().getRegistroCbj());
		assertEquals("12", aluno.getFiliado().getRegistroCbj());

	}

	@Test
	public void testGetFiliadoTelefone1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getTelefone1();

		assertEquals("(086)1234-9876", alunoDao.get(aluno).getFiliado().getTelefone1());
		assertEquals("(086)1234-9876", aluno.getFiliado().getTelefone1());

	}

	@Test
	public void testGetFiliadoTelefone2() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getTelefone2();

		assertEquals("", alunoDao.get(aluno).getFiliado().getTelefone2());
		assertEquals("", aluno.getFiliado().getTelefone2());

	}

	@Test
	public void testGetFiliadoEnderecoBairro() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getEndereco().getBairro();

		assertEquals("Amambai", alunoDao.get(aluno).getFiliado().getEndereco().getBairro());
		assertEquals("Amambai", aluno.getFiliado().getEndereco().getBairro());

	}

	@Test
	public void testGetFiliadoEnderecoCep() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getEndereco().getCep();

		assertEquals("79005671", alunoDao.get(aluno).getFiliado().getEndereco().getCep());
		assertEquals("79005671", aluno.getFiliado().getEndereco().getCep());

	}

	@Test
	public void testGetFiliadoEnderecoCidade() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getEndereco().getCidade();

		assertEquals("Campo Grande", alunoDao.get(aluno).getFiliado().getEndereco().getCidade());
		assertEquals("Campo Grande", aluno.getFiliado().getEndereco().getCidade());

	}

	@Test
	public void testGetFiliadoEnderecoEstado() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getEndereco().getEstado();

		assertEquals("MS", alunoDao.get(aluno).getFiliado().getEndereco().getEstado());
		assertEquals("MS", aluno.getFiliado().getEndereco().getEstado());

	}

	@Test
	public void testGetFiliadoEnderecoNumero() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getEndereco().getNumero();

		assertEquals("12", alunoDao.get(aluno).getFiliado().getEndereco().getNumero());
		assertEquals("12", aluno.getFiliado().getEndereco().getNumero());

	}

	@Test
	public void testGetFiliadoEnderecoRua() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getEndereco().getRua();

		assertEquals("Avenida das Bandeiras", alunoDao.get(aluno).getFiliado().getEndereco().getRua());
		assertEquals("Avenida das Bandeiras", aluno.getFiliado().getEndereco().getRua());

	}

	@Test
	public void testGetFiliadoFaixas() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getFaixas();

		assertEquals(null, alunoDao.get(aluno).getFiliado().getFaixas());
		assertEquals(null, aluno.getFiliado().getFaixas());

	}

	@Test
	public void testGetFiliadoRgNumero() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getRg().getNumero();

		assertEquals("123456789", alunoDao.get(aluno).getFiliado().getRg().getNumero());
		assertEquals("123456789", aluno.getFiliado().getRg().getNumero());

	}

	@Test
	public void testGetFiliadoRgOrgaoExpedidor() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);
		
		// aluno.getFiliado().getRg().getOrgaoExpedidor();

		assertEquals("Secretária de Expedição de RGs", alunoDao.get(aluno).getFiliado().getRg().getOrgaoExpedidor());
		assertEquals("Secretária de Expedição de RGs", aluno.getFiliado().getRg().getOrgaoExpedidor());

	}

	// Professor
	@Test
	public void testGetProfessorEntidadesCnpj_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getCnpj();

		assertEquals("80641845000178", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getCnpj());
		assertEquals("80641845000178", aluno.getProfessor().getEntidades().get(0).getCnpj());
	}

	@Test
	public void testGetProfessorEntidadesNome_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getNome();

		assertEquals("Academia 1", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getNome());
		assertEquals("Academia 1", aluno.getProfessor().getEntidades().get(0).getNome());

	}

	@Test
	public void testGetProfessorEntidadesTelefone1_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getTelefone1();

		assertEquals("(086)1111-0001", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getTelefone1());
		assertEquals("(086)1111-0001", aluno.getProfessor().getEntidades().get(0).getTelefone1());

	}

	@Test
	public void testGetProfessorEntidadesTelefone2_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getTelefone2();

		assertEquals("(086)1111-0002", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getTelefone2());
		assertEquals("(086)1111-0002", aluno.getProfessor().getEntidades().get(0).getTelefone2());

	}

	@Test
	public void testGetProfessorEntidadesEndereco_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getEndereco().getBairro();

		assertEquals("Entidade", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getEndereco().getBairro());
		assertEquals("Entidade", aluno.getProfessor().getEntidades().get(0).getEndereco().getBairro());
	}

	@Test
	public void testGetProfessorEntidadesEnderecoCep_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getEndereco().getCep();

		assertEquals("04078213", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getEndereco().getCep());
		assertEquals("04078213", aluno.getProfessor().getEntidades().get(0).getEndereco().getCep());

	}


	@Test
	public void testGetProfessorEntidadesEnderecoCidade_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getEndereco().getCidade();

		assertEquals("Teresina", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getEndereco().getCidade());
		assertEquals("Teresina", aluno.getProfessor().getEntidades().get(0).getEndereco().getCidade());
		
	}


	@Test
	public void testGetProfessorEntidadesEnderecoEstado_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getEndereco().getEstado();

		assertEquals("PI", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getEndereco().getEstado());
		assertEquals("PI", aluno.getProfessor().getEntidades().get(0).getEndereco().getEstado());

	}


	@Test
	public void testGetProfessorEntidadesEnderecoNumero_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getEndereco().getNumero();

		assertEquals("20", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getEndereco().getNumero());
		assertEquals("20", aluno.getProfessor().getEntidades().get(0).getEndereco().getNumero());

	}


	@Test
	public void testGetProfessorEntidadesEnderecoRua_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(0).getEndereco().getRua();

		assertEquals("Rua Entidade", alunoDao.get(aluno).getProfessor().getEntidades().get(0).getEndereco().getRua());
		assertEquals("Rua Entidade", aluno.getProfessor().getEntidades().get(0).getEndereco().getRua());

	}

	@Test
	public void testGetProfessorEntidadesCnpj_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getCnpj();

		assertEquals("12345678000101", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getCnpj());
		assertEquals("12345678000101", aluno.getProfessor().getEntidades().get(1).getCnpj());
	}

	@Test
	public void testGetProfessorEntidadesNome_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getNome();

		assertEquals("Academia 2", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getNome());
		assertEquals("Academia 2", aluno.getProfessor().getEntidades().get(1).getNome());

	}

	@Test
	public void testGetProfessorEntidadesTelefone1_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getTelefone1();

		assertEquals("(086)2222-1101", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getTelefone1());
		assertEquals("(086)2222-1101", aluno.getProfessor().getEntidades().get(1).getTelefone1());

	}

	@Test
	public void testGetProfessorEntidadesTelefone2_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getTelefone2();

		assertEquals("", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getTelefone2());
		assertEquals("", aluno.getProfessor().getEntidades().get(1).getTelefone2());

	}

	@Test
	public void testGetProfessorEntidadesEndereco_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getEndereco().getBairro();

		assertEquals("Vila Entidade", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getEndereco().getBairro());
		assertEquals("Vila Entidade", aluno.getProfessor().getEntidades().get(1).getEndereco().getBairro());
	}

	@Test
	public void testGetProfessorEntidadesEnderecoCep_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getEndereco().getCep();

		assertEquals("14078213", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getEndereco().getCep());
		assertEquals("14078213", aluno.getProfessor().getEntidades().get(1).getEndereco().getCep());

	}


	@Test
	public void testGetProfessorEntidadesEnderecoCidade_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getEndereco().getCidade();

		assertEquals("Teresina", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getEndereco().getCidade());
		assertEquals("Teresina", aluno.getProfessor().getEntidades().get(1).getEndereco().getCidade());
		
	}


	@Test
	public void testGetProfessorEntidadesEnderecoEstado_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getEndereco().getEstado();

		assertEquals("PI", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getEndereco().getEstado());
		assertEquals("PI", aluno.getProfessor().getEntidades().get(1).getEndereco().getEstado());

	}


	@Test
	public void testGetProfessorEntidadesEnderecoNumero_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getEndereco().getNumero();

		assertEquals("21", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getEndereco().getNumero());
		assertEquals("21", aluno.getProfessor().getEntidades().get(1).getEndereco().getNumero());

	}


	@Test
	public void testGetProfessorEntidadesEnderecoRua_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getEntidades().get(1).getEndereco().getRua();

		assertEquals("Rua Entidade 1", alunoDao.get(aluno).getProfessor().getEntidades().get(1).getEndereco().getRua());
		assertEquals("Rua Entidade 1", aluno.getProfessor().getEntidades().get(1).getEndereco().getRua());

	}


	@Test
	public void testGetProfessorFiliadoCpf() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getCpf();

		assertEquals("03646445327", alunoDao.get(aluno).getProfessor().getFiliado().getCpf());
		assertEquals("03646445327", aluno.getProfessor().getFiliado().getCpf());

	}

	@Test
	public void testGetProfessorFiliadoEmail() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getEmail();

		assertEquals("professor@email.com", alunoDao.get(aluno).getProfessor().getFiliado().getEmail());
		assertEquals("professor@email.com", aluno.getProfessor().getFiliado().getEmail());

	}

	@Test
	public void testGetProfessorFiliadoId() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getId();

		String str_daoProfessorId = String.valueOf(alunoDao.get(aluno).getProfessor().getFiliado().getId());
		String str_professorId = String.valueOf(aluno.getProfessor().getFiliado().getId());

		assertEquals("3332", str_daoProfessorId);
		assertEquals("3332", str_professorId);

	}

	@Test
	public void testGetProfessorFiliadoNome() throws Exception {

		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getNome();

		assertEquals("Roberto", alunoDao.get(aluno).getProfessor().getFiliado().getNome());
		assertEquals("Roberto", aluno.getProfessor().getFiliado().getNome());

	}

	@Test
	public void testGetProfessorFiliadoObservacoes() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getObservacoes();

		assertEquals("", alunoDao.get(aluno).getProfessor().getFiliado().getObservacoes());
		assertEquals("", aluno.getProfessor().getFiliado().getObservacoes());

	}

	@Test
	public void testGetProfessorFiliadoRegistroCbj() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getRegistroCbj();

		assertEquals("13", alunoDao.get(aluno).getProfessor().getFiliado().getRegistroCbj());
		assertEquals("13", aluno.getProfessor().getFiliado().getRegistroCbj());

	}

	@Test
	public void testGetProfessorFiliadoTelefone1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getTelefone1();

		assertEquals("(086)1234-9876", alunoDao.get(aluno).getProfessor().getFiliado().getTelefone1());
		assertEquals("(086)1234-9876", aluno.getProfessor().getFiliado().getTelefone1());

	}

	@Test
	public void testGetProfessorFiliadoTelefone2() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getTelefone2();

		assertEquals("(086)98524-3614", alunoDao.get(aluno).getProfessor().getFiliado().getTelefone2());
		assertEquals("(086)98524-3614", aluno.getProfessor().getFiliado().getTelefone2());

	}

	@Test
	public void testGetProfessorFiliadoEnderecoBairro() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getEndereco().getBairro();

		assertEquals("Bairro", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getBairro());
		assertEquals("Bairro", aluno.getProfessor().getFiliado().getEndereco().getBairro());

	}

	@Test
	public void testGetProfessorFiliadoEnderecoCep() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getEndereco().getCep();

		assertEquals("12345678", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getCep());
		assertEquals("12345678", aluno.getProfessor().getFiliado().getEndereco().getCep());

	}

	@Test
	public void testGetProfessorFiliadoEnderecoCidade() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getEndereco().getCidade();

		assertEquals("Cidade", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getCidade());
		assertEquals("Cidade", aluno.getProfessor().getFiliado().getEndereco().getCidade());

	}

	@Test
	public void testGetProfessorFiliadoEnderecoEstado() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getEndereco().getEstado();

		assertEquals("PI", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getEstado());
		assertEquals("PI", aluno.getProfessor().getFiliado().getEndereco().getEstado());

	}

	@Test
	public void testGetProfessorFiliadoEnderecoNumero() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getEndereco().getNumero();

		assertEquals("007", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getNumero());
		assertEquals("007", aluno.getProfessor().getFiliado().getEndereco().getNumero());

	}

	@Test
	public void testGetProfessorFiliadoEnderecoRua() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getEndereco().getRua();

		assertEquals("Rua Professor Algébrio", alunoDao.get(aluno).getProfessor().getFiliado().getEndereco().getRua());
		assertEquals("Rua Professor Algébrio", aluno.getProfessor().getFiliado().getEndereco().getRua());

	}

	@Test
	public void testGetProfessorFiliadoFaixasCorDesc_0() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getFaixas().get(0).getCor().getDescricao();

		assertEquals("Branca", alunoDao.get(aluno).getProfessor().getFiliado().getFaixas().get(0).getCor().getDescricao());
		assertEquals("Branca", aluno.getProfessor().getFiliado().getFaixas().get(0).getCor());

	}

	@Test
	public void testGetProfessorFiliadoFaixasCorDesc_1() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getFaixas().get(1).getCor().getDescricao();

		assertEquals("Verde", alunoDao.get(aluno).getProfessor().getFiliado().getFaixas().get(1).getCor().getDescricao());
		assertEquals("Verde", aluno.getProfessor().getFiliado().getFaixas().get(1).getCor().getDescricao());

	}

	@Test
	public void testGetProfessorFiliadoFaixasCorDesc_2() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getFaixas().get(2).getCor().getDescricao();

		assertEquals("Preta 2º Dan", alunoDao.get(aluno).getProfessor().getFiliado().getFaixas().get(2).getCor().getDescricao());
		assertEquals("Preta 2º Dan", aluno.getProfessor().getFiliado().getFaixas().get(2).getCor().getDescricao());

	}

	@Test
	public void testGetProfessorFiliadoRgNumero() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getRg().getNumero();

		assertEquals("987654321", alunoDao.get(aluno).getProfessor().getFiliado().getRg().getNumero());
		assertEquals("987654321", aluno.getProfessor().getFiliado().getRg().getNumero());

	}

	@Test
	public void testGetProfessorFiliadoRgOrgaoExpeditor() throws Exception {
		clearDatabase();

		alunoDao.save(aluno);

		// aluno.getProfessor().getFiliado().getRg().getOrgaoExpedidor();

		assertEquals("Secretária de Expedição de RGs", alunoDao.get(aluno).getProfessor().getFiliado().getRg().getOrgaoExpedidor());
		assertEquals("Secretária de Expedição de RGs", aluno.getProfessor().getFiliado().getRg().getOrgaoExpedidor());

	}
	
	

	@AfterAll
	public static void closeDatabase(){
		clearDatabase();
		DatabaseManager.close();
	}
	
}
