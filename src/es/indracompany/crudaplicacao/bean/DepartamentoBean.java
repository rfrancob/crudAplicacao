package es.indracompany.crudaplicacao.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.indracompany.crudaplicacao.dao.DepartamentoDAO;
import es.indracompany.crudaplicacao.entidade.Departamento;

@ManagedBean(name="DepartamentoBean")
@SessionScoped
public class DepartamentoBean {

	private List<Departamento> departamentos = new ArrayList<Departamento>();
	private Departamento departamento = new Departamento();
	private DepartamentoDAO departamentoDAO = new DepartamentoDAO(); //Criado apenas para não precisar ficar chamando o DAO td hora.

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}
	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
	}
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	public DepartamentoDAO getDepartamentoDAO() {
		return departamentoDAO;
	}
	public void setDepartamentoDAO(DepartamentoDAO departamentoDAO) {
		this.departamentoDAO = departamentoDAO;
	}

	public void add(){
		departamentoDAO.inserir(departamento);
		departamento = new Departamento();

	}
	public void listar() {
		departamentos = departamentoDAO.buscar();
	}
	public void editar(Departamento d) {
		departamento = d;

	}
}
