package es.indracompany.crudaplicacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.indracompany.crudaplicacao.entidade.Cargo;
import es.indracompany.crudaplicacao.util.FabricaConexao;

public class CargoDao {
	
	public void inserir(Cargo cargo){
		PreparedStatement ps;
		Connection connection = null;
		try {
			connection = FabricaConexao.getConexao();
			if(cargo.getCod() == null){
				ps = connection.prepareStatement("INSERT INTO Cargo (cargo_cod, cargo_desc, cargo_nivel) VALUES (?,?,?)");	
			}
			else {
				ps = connection.prepareStatement("UPDATE Cargo SET cargo_des=?,cargo_nivel=? where cargo_cod=?");
				ps.setInt(3, cargo.getCod());
			}
			ps.setString(1,cargo.getCargo_desc());
			ps.setInt(2,cargo.getCargo_nivel());
			ps.execute();
			FabricaConexao.fecharConexao();;
		} catch (SQLException e) {
			System.out.println("essa exção");
			Logger.getLogger(CargoDao.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}

	}

	public List<Cargo> buscar(){
		Connection connection = FabricaConexao.getConexao();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Cargo");
			ResultSet resultSet = ps.executeQuery();
			List<Cargo> cargos = new ArrayList<Cargo>();
			while(resultSet.next()) {
				Cargo carg = new Cargo();
				carg.setCod(resultSet.getInt("cod"));
				carg.setCargo_desc(resultSet.getString("cargo_desc"));
				carg.setCargo_nivel(resultSet.getInt("cargo_nivel"));
				cargos.add(carg);
			}
			return cargos;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
