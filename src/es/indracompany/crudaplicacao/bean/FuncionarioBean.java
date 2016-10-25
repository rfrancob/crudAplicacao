package es.indracompany.crudaplicacao.bean;


import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.indracompany.crudaplicacao.dao.FuncionarioDAO;
import es.indracompany.crudaplicacao.entidade.Funcionario;

@ManagedBean(name="FuncionarioBean")
@SessionScoped
public class FuncionarioBean {
	
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();
	private Funcionario funcionario = new Funcionario();
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO(); //Criado apenas para não precisar ficar chamando o DAO td hora.
	
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public FuncionarioDAO getFuncionarioDAO() {
		return funcionarioDAO;
	}
	public void setFuncionarioDAO(FuncionarioDAO funcionarioDAO) {
		this.funcionarioDAO = funcionarioDAO;
	}
	
	public void add(){
		funcionarioDAO.inserir(funcionario);
		funcionario = new Funcionario();
		
	}
	public void listar() {
		funcionarios = funcionarioDAO.buscar();
	}
	public void editar(Funcionario f) {
		funcionario = f;
		
	}		
}
