package br.com.encosis.minicurso.control.mb;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import br.com.encosis.minicurso.model.bean.Manterusuario;
import br.com.encosis.minicurso.model.dao.JPAUtil;
import br.com.encosis.minicurso.model.dao.ManterusuarioDAO;

@ViewScoped
@ManagedBean
public class ManterusuarioMB {
	//Atributos devem ser iniciados
	private Manterusuario manterusuario = new Manterusuario();
	
	public Manterusuario getManterusuario() {
		return manterusuario;
	}
	
	public void setManterusuario(Manterusuario manterusuario) {
		this.manterusuario = manterusuario;
	}
	
	//Atributo que guarda a colecao manterusuarios armazenados em BD
	public List<Manterusuario> listaManterusuarios = new ArrayList<Manterusuario>();
	
	public List<Manterusuario> getListaManterusuarios() {
		return listaManterusuarios;
	}	

	//Metodo invocado apos a classe ser carregada pelo servidor
	@PostConstruct
	public void carregarManterusuarios(){
		EntityManager em = JPAUtil.getEntityManager();
		ManterusuarioDAO dao = new ManterusuarioDAO(em);
		listaManterusuarios = dao.listar();
		em.close();
	}
	
	public void excluir(){
		EntityManager em = JPAUtil.getEntityManager();
		ManterusuarioDAO dao = new ManterusuarioDAO(em);
		em.getTransaction().begin();
		dao.excluir(manterusuario);
		em.getTransaction().commit();
		em.close();
		carregarManterusuarios();
	}

	public void salvar(){
		EntityManager em = JPAUtil.getEntityManager();
		ManterusuarioDAO dao = new ManterusuarioDAO(em);
		em.getTransaction().begin();
		manterusuario.setDataCadastro(Calendar.getInstance());
		if(manterusuario.getId()!=null){
			dao.alterar(manterusuario);
		}else{
			dao.cadastrar(manterusuario);
		}
		em.getTransaction().commit();
		em.close();
		manterusuario  = new Manterusuario();
		carregarManterusuarios();
	}
}
