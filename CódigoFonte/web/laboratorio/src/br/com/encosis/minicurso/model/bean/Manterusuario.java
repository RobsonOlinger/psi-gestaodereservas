package br.com.encosis.minicurso.model.bean;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Manterusuario {
	
	@Id
	@GeneratedValue
	private Long id;
	private String nome;
	private String matricula;
	private String perfil;
	private String senha;
	private String confirmar_senha;
	//Armazenar apanas a data, sem hora
	@Temporal(TemporalType.DATE)
	private Calendar dataCadastro;
		
	
	//Metodos de GET e SET...
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getConfirmar_senha() {
		return confirmar_senha;
	}
	public void setConfirmar_senha(String confirmar_senha) {
		this.confirmar_senha = confirmar_senha;
	}
	public Calendar getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
}

