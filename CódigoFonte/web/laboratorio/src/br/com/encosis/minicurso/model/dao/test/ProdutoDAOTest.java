package br.com.encosis.minicurso.model.dao.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import javax.persistence.EntityManager;

import junit.framework.Assert;

import org.junit.Test;
import br.com.encosis.minicurso.model.bean.Reserva;
import br.com.encosis.minicurso.model.dao.JPAUtil;
import br.com.encosis.minicurso.model.dao.ReservaDAO;

public class ProdutoDAOTest {

	@Test
	public void testCadastrar() {
		// Solicitacao de conexao ao SGBD
		EntityManager entityManager = JPAUtil.getEntityManager();
		ReservaDAO dao = new ReservaDAO(entityManager);
		// Inicio da transacao
		entityManager.getTransaction().begin();
		// Criacao de um novo reserva
		Reserva reserva = new Reserva();
		reserva.setNome("teste");
		reserva.setMatricula("teste");
		reserva.setDataCadastro(Calendar.getInstance());
		reserva.setBloco("bloca a");
		reserva.setCurso("curso teste");
		//Execucao do cadastro
		dao.cadastrar(reserva);
		//Fechamento da conexao
		entityManager.getTransaction().commit();
		entityManager.close();
		
		//Realização do teste de cadastro
		Assert.assertNotNull(reserva.getId());
	}

	// Continuacao...
	@Test
	public void testAlterar() {
		fail("Not yet implemented");
	}

	@Test
	public void testExcluir() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsultar() {
		fail("Not yet implemented");
	}

	@Test
	public void testListar() {
		fail("Not yet implemented");
	}

}
