package back;

import back.Usuario;
import back.ConexaoBD;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO extends ConexaoBD{
    
    public void inserir(Usuario usuario) throws SQLException{
        String sql = "INSERT INTO dados(nome,cpf, senha) VALUES (?,?,?)";
        try(Connection conn = conectar();
            PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getSenha());
            
            stmt.executeUpdate();
            
           try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    usuario.setId(rs.getInt(1));
                }
            }
        }
    }
    public List<Usuario> listar() throws SQLException{
           List <Usuario> usuarios = new ArrayList<>();
           String sql = "SELECT * FROM dados";
            try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                usuarios.add(new Usuario(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("senha")
                        
                ));
            }
        }
        return usuarios;
           
    }
    
   
   public int verificarLogin(String senha, String cpf) {
    String sql = "SELECT id FROM dados WHERE cpf = ? AND senha = ?";
    try (Connection conn = conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, cpf);
        stmt.setString(2, senha);

        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt("id");
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }
    return -1;
}
 
    
}
