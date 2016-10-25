package es.indracompany.crudaplicacao.entidade;

public class Cargo {
	
	private Integer cod;
	private String cargo_desc;
	private Integer cargo_nivel;

	public Integer getCod() {
		return cod;
	}
	public void setCod(Integer cod) {
		this.cod = cod;
	}
	
	public String getCargo_desc() {
		return cargo_desc;
	}
	public void setCargo_desc(String cargo_desc) {
		this.cargo_desc = cargo_desc;
	}
	
	public Integer getCargo_nivel() {
		return cargo_nivel;
	}
	public void setCargo_nivel(Integer cargo_nivel) {
		this.cargo_nivel = cargo_nivel;
	}
}
