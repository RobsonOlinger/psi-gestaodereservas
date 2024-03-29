package br.com.encosis.minicurso.model.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	// Definicao de atributo para criacao de conexoes
	private static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory("reserva");

	/**
	 * Metodo responsavel pela criacao de conexoes
	 * @return conexao para acesso ao SGBD
	 */
	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
