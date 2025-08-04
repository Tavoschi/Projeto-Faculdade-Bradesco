package front;

import back.ConexaoBD;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class TelaAdmin extends JFrame {
    public TelaAdmin(int idUsuario) {
        setTitle("Área Administrativa");
        setSize(300, 200);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton visualizar = new JButton("VISUALIZAR DADOS");
        visualizar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        visualizar.setBackground(new Color(139, 0, 0));
        visualizar.setForeground(Color.WHITE);
        visualizar.setFocusPainted(false);
        visualizar.setBorder(new EmptyBorder(8, 20, 8, 20));
        visualizar.addActionListener(e -> new TelaConsulta());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(204, 204, 204));
        panel.add(visualizar);
        setContentPane(panel);
        setVisible(true);
    }

    
    private class TelaConsulta extends JFrame {
        private JTextField campoBusca;
        private JTable tabela;
        private DefaultTableModel modelo;

        public TelaConsulta() {
            setTitle("Consulta de Usuários");
            setSize(600, 450);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout(10, 10));
            getContentPane().setBackground(new Color(204, 204, 204));

            campoBusca = new JTextField();
            campoBusca.setFont(new Font("Segoe UI", Font.PLAIN, 14));
            campoBusca.setBorder(BorderFactory.createTitledBorder("Buscar por Nome, CPF ou ID"));
            campoBusca.addActionListener(e -> carregarDados());
            add(campoBusca, BorderLayout.NORTH);

            modelo = new DefaultTableModel(new String[]{"ID", "NOME", "CPF", "SENHA"}, 0);
            tabela = new JTable(modelo);
            tabela.setFont(new Font("Segoe UI", Font.PLAIN, 13));
            tabela.setRowHeight(22);
            JScrollPane scrollPane = new JScrollPane(tabela);
            add(scrollPane, BorderLayout.CENTER);

           
            JButton excluir = new JButton("EXCLUIR USUÁRIO");
            excluir.setFont(new Font("Segoe UI", Font.BOLD, 14));
            excluir.setBackground(new Color(139, 0, 0));
            excluir.setForeground(Color.WHITE);
            excluir.setFocusPainted(false);
            excluir.setBorder(new EmptyBorder(8, 20, 8, 20));

            excluir.addActionListener((ActionEvent e) -> excluirUsuario());

            JPanel painelBotoes = new JPanel();
            painelBotoes.setBackground(new Color(204, 204, 204));
            painelBotoes.add(excluir);

            add(painelBotoes, BorderLayout.SOUTH);

            carregarDados();
            setVisible(true);
        }

        private void carregarDados() {
            modelo.setRowCount(0);
            String busca = campoBusca.getText().trim();
            String sql = "SELECT * FROM dados WHERE nome LIKE ? OR senha LIKE ? OR cpf LIKE ? OR id LIKE ?";
            try (Connection conn = ConexaoBD.conectar();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                String filtro = "%" + busca + "%";
                ps.setString(1, filtro);
                ps.setString(2, filtro);
                ps.setString(3, filtro);
                ps.setString(4, filtro);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    modelo.addRow(new Object[]{
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            rs.getString("senha")
                    });
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + ex.getMessage());
            }
        }

        private void excluirUsuario() {
            int linhaSelecionada = tabela.getSelectedRow();
            if (linhaSelecionada == -1) {
                JOptionPane.showMessageDialog(this, "Selecione um usuário para excluir.");
                return;
            }

            int confirmacao = JOptionPane.showConfirmDialog(this, "Tem certeza que deseja excluir este usuário?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
            if (confirmacao != JOptionPane.YES_OPTION) return;

            int id = (int) modelo.getValueAt(linhaSelecionada, 0);

            String sql = "DELETE FROM dados WHERE id = ?";
            try (Connection conn = ConexaoBD.conectar();
                 PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, id);
                int linhasAfetadas = ps.executeUpdate();

                if (linhasAfetadas > 0) {
                    JOptionPane.showMessageDialog(this, "Usuário excluído com sucesso!");
                    carregarDados();
                } else {
                    JOptionPane.showMessageDialog(this, "Não foi possível excluir o usuário.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao excluir usuário: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        int idUsuario = 0;
        SwingUtilities.invokeLater(() -> new TelaAdmin(idUsuario));
    }
}