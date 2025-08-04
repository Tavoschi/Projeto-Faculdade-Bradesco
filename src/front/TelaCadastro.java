package front;


import back.ConexaoBD;
import front.TelaLogin;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class TelaCadastro extends JFrame {
    private JTextField nome, cpf, senha;

    public TelaCadastro() {
        setTitle("Cadastro de Usuários");
        setSize(314, 539);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel(new BorderLayout());
        panelPrincipal.setBackground(new Color(204, 204, 204));

        
        JPanel faixaSuperior = new JPanel();
        faixaSuperior.setPreferredSize(new Dimension(300, 50));
        faixaSuperior.setBackground(new Color(139, 0, 0));
        faixaSuperior.setLayout(new BorderLayout());

        
        ImageIcon iconeVoltar = new ImageIcon(getClass().getResource("/imagem/pngwing1.com.png"));
        ImageIcon iconeBanco = new ImageIcon(getClass().getResource("/imagem/BradescoLogo.png"));

        Image imagemVoltar = iconeVoltar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Image imagemBanco = iconeBanco.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

        JLabel labelVoltar = new JLabel(new ImageIcon(imagemVoltar));
        JLabel labelBanco = new JLabel(new ImageIcon(imagemBanco));

        
        labelVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        labelVoltar.setBorder(new EmptyBorder(10, 10, 10, 10));
        labelVoltar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                dispose(); 
                new TelaLogin().setVisible(true); 
            }
        });

        labelBanco.setBorder(new EmptyBorder(5, 5, 5, 10));

        faixaSuperior.add(labelVoltar, BorderLayout.WEST);
        faixaSuperior.add(labelBanco, BorderLayout.EAST);

        panelPrincipal.add(faixaSuperior, BorderLayout.NORTH);

       
        JPanel camposPanel = new JPanel();
        camposPanel.setLayout(new BoxLayout(camposPanel, BoxLayout.Y_AXIS));
        camposPanel.setBackground(new Color(204, 204, 204));
        camposPanel.setBorder(new EmptyBorder(20, 10, 10, 10));

        Font fonte = new Font("Bradesco Sans", Font.PLAIN, 14);
        Border bordaCampo = BorderFactory.createCompoundBorder(
                new LineBorder(Color.BLACK, 1, true),
                new EmptyBorder(10, 10, 10, 10)
        );

        nome = criarCampo(fonte, bordaCampo);
        cpf = criarCampo(fonte, bordaCampo);
        senha = criarCampo(fonte, bordaCampo);

        camposPanel.add(criarLinha("Nome:", nome, fonte));
        camposPanel.add(Box.createVerticalStrut(5));
        camposPanel.add(criarLinha("CPF:", cpf, fonte));
        camposPanel.add(Box.createVerticalStrut(5));
        camposPanel.add(criarLinha("Senha:", senha, fonte));

        JPanel centralPanel = new JPanel(new BorderLayout());
        centralPanel.setBackground(new Color(204, 204, 204));
        centralPanel.add(Box.createVerticalGlue(), BorderLayout.NORTH);
        centralPanel.add(camposPanel, BorderLayout.CENTER);

       
        JButton cadastrar = new JButton("CADASTRAR");
        cadastrar.setFont(fonte);
        cadastrar.setBackground(new Color(139, 0, 0));
        cadastrar.setForeground(Color.WHITE);
        cadastrar.setFocusPainted(false);
        cadastrar.setBorder(new EmptyBorder(8, 20, 8, 20));

        cadastrar.addActionListener((ActionEvent e) -> {
            String nomeTexto = nome.getText().trim();
            String cpfTexto = cpf.getText().trim();
            String senhaTexto = senha.getText().trim();

            if (nomeTexto.isEmpty() || cpfTexto.isEmpty() || senhaTexto.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Todos os campos devem ser preenchidos.");
                return;
            }

            if (!nomeTexto.matches("[\\p{L} ]+")) {
                JOptionPane.showMessageDialog(this, "O nome deve conter apenas letras e espaços.");
                return;
            }

            if (!cpfTexto.matches("\\d{11}")) {
                JOptionPane.showMessageDialog(this, "O CPF deve conter exatamente 11 dígitos numéricos.");
                return;
            }

            if (!cpfValido(cpfTexto)) {
                JOptionPane.showMessageDialog(this, "O CPF digitado é inválido.");
                return;
            }

            try (Connection conn = ConexaoBD.conectar()) {
                String sqlVerifica = "SELECT cpf FROM dados WHERE cpf = ?";
                try (PreparedStatement psVerifica = conn.prepareStatement(sqlVerifica)) {
                    psVerifica.setString(1, cpfTexto);
                    ResultSet rs = psVerifica.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(this, "CPF já cadastrado. Por favor, use outro CPF.");
                        return;
                    }
                }

                String sqlInsert = "INSERT INTO dados (nome, cpf, senha) VALUES (?, ?, ?)";
                try (PreparedStatement ps = conn.prepareStatement(sqlInsert)) {
                    ps.setString(1, nomeTexto);
                    ps.setString(2, cpfTexto);
                    ps.setString(3, senhaTexto);
                    ps.executeUpdate();

                    JOptionPane.showMessageDialog(this, "Usuário cadastrado com sucesso!");
                    nome.setText("");
                    cpf.setText("");
                    senha.setText("");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + ex.getMessage());
            }
        });

        JPanel botoesPanel = new JPanel();
        botoesPanel.setBackground(new Color(204, 204, 204));
        botoesPanel.add(cadastrar);

        JPanel faixaInferior = new JPanel();
        faixaInferior.setPreferredSize(new Dimension(0, 37));
        faixaInferior.setBackground(new Color(139, 0, 0));

        JPanel rodapePanel = new JPanel();
        rodapePanel.setLayout(new BoxLayout(rodapePanel, BoxLayout.Y_AXIS));
        rodapePanel.setBackground(new Color(204, 204, 204));
        rodapePanel.add(botoesPanel);
        rodapePanel.add(faixaInferior);

        panelPrincipal.add(centralPanel, BorderLayout.CENTER);
        panelPrincipal.add(rodapePanel, BorderLayout.SOUTH);
        setContentPane(panelPrincipal);
    }

    private JTextField criarCampo(Font fonte, Border borda) {
        JTextField campo = new JTextField();
        campo.setFont(fonte);
        campo.setBorder(borda);
        campo.setPreferredSize(new Dimension(20, 20));
        campo.setMaximumSize(new Dimension(450, 35));
        campo.setBackground(Color.WHITE);
        return campo;
    }

    private JPanel criarLinha(String texto, JTextField campo, Font fonte) {
        JPanel linha = new JPanel();
        linha.setLayout(new BoxLayout(linha, BoxLayout.X_AXIS));
        linha.setAlignmentX(Component.LEFT_ALIGNMENT);
        linha.setBackground(new Color(204, 204, 204));
        JLabel label = new JLabel(texto);
        label.setFont(fonte);
        label.setPreferredSize(new Dimension(60, 25));
        label.setMaximumSize(new Dimension(35, 35));
        linha.add(label);
        linha.add(Box.createHorizontalStrut(10));
        linha.add(campo);
        return linha;
    }

    public static boolean cpfValido(String cpf) {
        if (cpf == null || cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;
        try {
            int soma1 = 0, soma2 = 0;
            for (int i = 0; i < 9; i++) {
                int digito = Character.getNumericValue(cpf.charAt(i));
                soma1 += digito * (10 - i);
                soma2 += digito * (11 - i);
            }
            int digito1 = 11 - (soma1 % 11);
            digito1 = (digito1 >= 10) ? 0 : digito1;
            soma2 += digito1 * 2;
            int digito2 = 11 - (soma2 % 11);
            digito2 = (digito2 >= 10) ? 0 : digito2;
            return digito1 == Character.getNumericValue(cpf.charAt(9)) &&
                   digito2 == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TelaCadastro().setVisible(true);
        });
    }
}