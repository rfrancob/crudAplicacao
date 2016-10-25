package es.indracompany.crudaplicacao.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.indracompany.crudaplicacao.util.FabricaConexao;
import es.indracompany.crudaplicacao.entidade.Funcionario;

public class FuncionarioDAO {

	public void inserir(Funcionario funcionario){
		PreparedStatement ps;
		Connection connection = null;
		try {
			connection = FabricaConexao.getConexao();
			if(funcionario.getCod() == null){
			ps = connection.prepareStatement("INSERT INTO [Crud].[Funcionario] (func_nome, func_cpf, func_dt_nasc, func_depto, func_dt_contrat, func_sal, func_cargo, func_supe) VALUES (?,?,?,?,?,?,?,?)");	
			}
			else {
				ps = connection.prepareStatement("UPDATE [Crud].[Funcionario] SET func_nome=?,func_cpf=?,func_dt_nasc=?,func_depto=?,func_dt_contrat=?,func_sal=?,func_cargo=?func_supe=? where func_cod=?");
				ps.setInt(9, funcionario.getCod());
			}
			ps.setString(1,funcionario.getNome());
			ps.setString(2,funcionario.getCpf());
			ps.setInt(4,funcionario.getDepto());
			ps.setInt(7,funcionario.getCargo());
			ps.setDate(5,new java.sql.Date(funcionario.getContratacao().getTime()));
			ps.setDate(3,new java.sql.Date(funcionario.getNascimento().getTime()));
			ps.setFloat(6,funcionario.getSalario());
			ps.setInt(8,funcionario.getImediato());
			ps.execute();
			FabricaConexao.fecharConexao();;
		} catch (SQLException e) {
			System.out.println("essa exção");
			Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		}

	}

	public List<Funcionario> buscar(){
		Connection connection = FabricaConexao.getConexao();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM [Crud].[Funcionario]");
			ResultSet resultSet = ps.executeQuery();
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			while(resultSet.next()) {
				Funcionario func = new Funcionario();
				func.setCod(resultSet.getInt("cod"));
				func.setNome(resultSet.getString("func_nome"));
				func.setCpf(resultSet.getString("func_cpf"));
				func.setDepto(resultSet.getInt("func_depto"));
				func.setCargo(resultSet.getInt("func_cargo"));
				func.setContratacao(resultSet.getDate("func_dtContratacao"));
				func.setNascimento(resultSet.getDate("func_dtNascimento"));
				func.setSalario(resultSet.getFloat("func_salario"));
				func.setImediato(resultSet.getInt("func_superior"));
				funcionarios.add(func);
			}
			return funcionarios;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
}
