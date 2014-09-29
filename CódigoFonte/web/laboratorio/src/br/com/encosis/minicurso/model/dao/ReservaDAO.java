package br.com.encosis.minicurso.model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.encosis.minicurso.model.bean.Reserva;
@SuppressWarnings("unchecked")
public class ReservaDAO {

	private EntityManager entityManager;
	
	public ReservaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	public void cadastrar(Reserva reserva){
		entityManager.persist(reserva);
	}
	public void alterar(Reserva reserva){
		entityManager.merge(reserva);
	}
	public void excluir(Reserva reserva){
		entityManager.remove(entityManager.merge(reserva));
	}
	
	public Reserva consultar(Long id){
		return entityManager.getReference(Reserva.class, id);
	}
	
	public List<Reserva> listar(){
		String jpql = "Select p from Reserva p order by nome";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}
}
