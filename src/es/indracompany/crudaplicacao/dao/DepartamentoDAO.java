package es.indracompany.crudaplicacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.indracompany.crudaplicacao.entidade.Departamento;
import es.indracompany.crudaplicacao.util.FabricaConexao;

public class DepartamentoDAO {

	public void inserir(Departamento departamento){
		PreparedStatement ps;
		Connection connection = null;
		try {
			connection = FabricaConexao.getConexao();
			if(departamento.getCod() == null){
				ps = connection.prepareStatement("INSERT INTO Departamento (depto_codigo, depto_descricao, depto_ramal) VALUES (?,?,?)");	
			}
			else {
				ps = connection.prepareStatement("UPDATE Funcionario SET depto_descricao=?,depto_ramal=? where depto_codigo=?");
				ps.setInt(3, departamento.getCod());
			}
			ps.setString(1,departamento.getDepto_desc());
			ps.setInt(2,departamento.getRamal());
			ps.execute();
			FabricaConexao.fecharConexao();;
		} catch (SQLException e) {
			System.out.println("essa exção");
			Logger.getLogger(DepartamentoDAO.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}

	}

	public List<Departamento> buscar(){
		Connection connection = FabricaConexao.getConexao();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM Departamento");
			ResultSet resultSet = ps.executeQuery();
			List<Departamento> departmentos = new ArrayList<Departamento>();
			while(resultSet.next()) {
				Departamento dpto = new Departamento();
				dpto.setCod(resultSet.getInt("cod"));
				dpto.setDepto_desc(resultSet.getString("depto_desc"));
				dpto.setRamal(resultSet.getInt("ramal"));
				departmentos.add(dpto);
			}
			return departmentos;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
