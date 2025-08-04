package back;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class ConexaoBD {
    
    
    private static final String URL = "jdbc:mysql://localhost:3306/clientes"; //Alterar quando necessário 
    private static final String USER = "root"; //Alterar quando necessário 
    private static final String PASSWORD = "35863498Gu."; //Alterar quando necessário 
    
    //private static final String URL = "jdbc:h2:~/clientes";
    //private static final String USER = "sa";
    //private static final String PASSWORD = "";
    
      public static Connection conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexão bem-sucedida!");
            return conn;
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC não encontrado!", e);
        }
    }
    
}
