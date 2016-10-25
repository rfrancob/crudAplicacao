package es.indracompany.crudaplicacao.entidade;

public class Departamento {

	private Integer cod;
	private String depto_desc;
	private Integer ramal;

	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDepto_desc() {
		return depto_desc;
	}
	public void setDepto_desc(String depto_desc) {
		this.depto_desc = depto_desc;
	}
	
	public Integer getRamal() {
		return ramal;
	}
	public void setRamal(Integer ramal) {
		this.ramal = ramal;
	}

}
