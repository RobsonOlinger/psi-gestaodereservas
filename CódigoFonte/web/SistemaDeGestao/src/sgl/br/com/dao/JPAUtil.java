package sgl.br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
		private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestaoLab");
		
		public static EntityManager getEntityManager(){
			return emf.createEntityManager();
		}
				
}
