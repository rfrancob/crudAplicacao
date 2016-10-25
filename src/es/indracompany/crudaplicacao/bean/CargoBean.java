package es.indracompany.crudaplicacao.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import es.indracompany.crudaplicacao.dao.CargoDao;
import es.indracompany.crudaplicacao.entidade.Cargo;

@ManagedBean(name="CargoBean")
@SessionScoped
public class CargoBean {

	private List<Cargo> cargos = new ArrayList<Cargo>();
	private Cargo cargo = new Cargo();
	private CargoDao cargoDao = new CargoDao(); //Criado apenas para não precisar ficar chamando o DAO td hora.

	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public CargoDao getCargoDAO() {
		return cargoDao;
	}
	public void setCargoDAO(CargoDao cargoDAO) {
		this.cargoDao = cargoDAO;
	}

	public void add(){
		cargoDao.inserir(cargo);
		cargo = new Cargo();

	}
	public void listar() {
		cargos = cargoDao.buscar();
	}
	public void editar(Cargo c) {
		cargo = c;
	}
}
