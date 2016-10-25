package es.indracompany.crudaplicacao.entidade;

import java.util.Date;

public class Funcionario {

	private String nome;
	private Integer cod;
	private String cpf;
	private Integer depto;
	private Integer cargo;
	private Date contratacao;
	private Date nascimento;
	private float salario;
	private Integer imediato;
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Integer getDepto() {
		return depto;
	}
	public void setDepto(Integer depto) {
		this.depto = depto;
	}
	
	public Integer getCargo() {
		return cargo;
	}
	public void setCargo(Integer cargo) {
		this.cargo = cargo;
	}
	
	public Date getContratacao() {
		return contratacao;
	}
	public void setContratacao(Date contratacao) {
		this.contratacao = contratacao;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public Integer getImediato() {
		return imediato;
	}
	public void setImediato(Integer imediato) {
		this.imediato = imediato;
	}
	public Funcionario(String nome, Integer cod, String cpf, Integer depto, Integer cargo,
			Date contratacao, Date nascimento, float salario, Integer imediato) {
		this.nome = nome;
		this.cod = cod;
		this.cpf = cpf;
		this.depto = depto;
		this.cargo = cargo;
		this.contratacao = contratacao;
		this.nascimento = nascimento;
		this.salario = salario;
		this.imediato = imediato;
	}
	public Funcionario(){}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}

	
}