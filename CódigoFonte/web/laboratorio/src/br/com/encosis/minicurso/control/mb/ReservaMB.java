package br.com.encosis.minicurso.control.mb;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.encosis.minicurso.model.bean.Reserva;
import br.com.encosis.minicurso.model.dao.JPAUtil;
import br.com.encosis.minicurso.model.dao.ReservaDAO;

@ViewScoped
@ManagedBean
public class ReservaMB {
	//Atributos devem ser iniciados
	private Reserva reserva = new Reserva();
	
	public Reserva getReserva() {
		return reserva;
	}
	
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	
	//Atributo que guarda a colecao reservas armazenados em BD
	public List<Reserva> listaReservas = new ArrayList<Reserva>();
	
	public List<Reserva> getListaReservas() {
		return listaReservas;
	}	

	//Metodo invocado apos a classe ser carregada pelo servidor
	@PostConstruct
	public void carregarReservas(){
		EntityManager em = JPAUtil.getEntityManager();
		ReservaDAO dao = new ReservaDAO(em);
		listaReservas = dao.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		ReservaDAO dao = new ReservaDAO(em);
		em.getTransaction().begin();
		dao.excluir(reserva);
		em.getTransaction().commit();
		em.close();
		carregarReservas();
	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManager();
		ReservaDAO dao = new ReservaDAO(em);
		em.getTransaction().begin();
		reserva.setDataCadastro(Calendar.getInstance());
		if(reserva.getId()!=null){
			dao.alterar(reserva);
		}else{
			dao.cadastrar(reserva);
		}
		em.getTransaction().commit();
		em.close();
		reserva  = new Reserva();
		carregarReservas();
	}
}
