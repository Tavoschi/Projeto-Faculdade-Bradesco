package back;

import back.Cartao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartaoDAO extends ConexaoBD{
     public void inserir(Cartao cartao) throws SQLException {
        String sql = "INSERT INTO dadosCart(limite, numCart) VALUES (?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
     
            stmt.setString(1, cartao.getLimite());
        
            stmt.setString(2, cartao.getNumCart());

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    cartao.setId(rs.getInt(1));
                }
            }
        }
    }

    public List<Cartao> list() throws SQLException {
        List<Cartao> cartoes = new ArrayList<>();
        String sql = "SELECT * FROM dadosCart";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                cartoes.add(new Cartao(
                    rs.getInt("id"),
                    rs.getString("limite"),
                    rs.getString("numCart")
                 
                        
                ));
            }
        }

        return cartoes;
    }

    public void atualizar(Cartao cartao) throws SQLException {
        String sql = "UPDATE dadosCart SET limite=? WHERE id=?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cartao.getLimite());
            stmt.setInt(2, cartao.getId());

            stmt.executeUpdate();
        }
    }

    public void apagarLimite(Cartao cartao) throws SQLException {
        String sql = "UPDATE dadosCart SET limite = NULL WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, cartao.getId());
            stmt.executeUpdate();
        }
    }
     public boolean cartaoExiste(int idUsuario) {
        String sql = "SELECT * FROM dadosCart WHERE idUsuario = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void inserirCartao(String numero, int idUsuario) {
        String sql = "INSERT INTO dadosCart (numCart, idUsuario) VALUES (?, ?)";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, numero);
            stmt.setInt(2, idUsuario);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String gerarNumeroCartao(int idUsuario) {
        StringBuilder numero = new StringBuilder();
        numero.append(String.format("%04d", idUsuario)); // base no ID

        for (int i = 0; i < 12; i++) {
            numero.append((int) (Math.random() * 10));
        }
        return numero.toString();
    }

    public String buscarCartaoPorUsuario(int idUsuario) {
        String sql = "SELECT numCart FROM dadosCart WHERE idUsuario = ?";
        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idUsuario);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("numCart");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Não encontrado";
    }
   
}

   

            
       
    
    
   
    
    
    

