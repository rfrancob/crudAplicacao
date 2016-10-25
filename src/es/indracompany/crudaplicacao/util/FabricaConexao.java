package es.indracompany.crudaplicacao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FabricaConexao {

	private static Connection conexao;		
	private static final String URL_CONEXAO = "jdbc:derby:MyDB;create=true";
	private static final String USUARIO = "rfrancob";
	private static final String SENHA = "123456";
	
	public static Connection getConexao() {
		if(conexao == null){
			try {
				Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
				conexao = DriverManager.getConnection(URL_CONEXAO, USUARIO, SENHA);
			}catch (SQLException e) {
				Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, e);
			}catch (ClassNotFoundException e) {
				Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, e);
			} 
		}
		return conexao;
	}
	
	public static void fecharConexao(){
		if(conexao != null){
			try {
				conexao.close();
				conexao = null;
			} catch (SQLException e) {
				Logger.getLogger(FabricaConexao.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}
}
