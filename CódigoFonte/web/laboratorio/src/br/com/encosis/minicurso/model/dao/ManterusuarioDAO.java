package br.com.encosis.minicurso.model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.encosis.minicurso.model.bean.Manterusuario;
@SuppressWarnings("unchecked")
public class ManterusuarioDAO {

	private EntityManager entityManager;
	
	public ManterusuarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Manterusuario manterusuario){
		entityManager.persist(manterusuario);
	}
	public void alterar(Manterusuario manterusuario){
		entityManager.merge(manterusuario);
	}
	public void excluir(Manterusuario manterusuario){
		entityManager.remove(entityManager.merge(manterusuario));
	}
	
	public Manterusuario consultar(Long id){
		return entityManager.getReference(Manterusuario.class, id);
	}
	
	public List<Manterusuario> listar(){
		String jpql = "Select p from Manterusuario p order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
