package BD;

import java.sql.*;

public class ConexaoBD {
	
	
			public static Connection createConnectionToMySQL() throws SQLException {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/myclinic", "root", "");
					return conn;
					
				} catch (ClassNotFoundException e) {
					throw new SQLException(e.getException());
					
				}
				
				
			}
			
			public static void main(String[] args) throws SQLException, ClassNotFoundException {
				
				Connection conn = createConnectionToMySQL();
				
				if (conn!=null) {
					System.out.println("BD CONECTADO");
				} else {
					System.out.println("BD  NÃO CONECTADO");
				}
			}
		
	}

