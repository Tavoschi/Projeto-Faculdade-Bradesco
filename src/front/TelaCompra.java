package front;


import back.ConexaoBD;
import back.SessaoUsuario;
import front.TelaEscolha;
import front.TelaInicial;
import back.StatusCompra;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class TelaCompra extends javax.swing.JFrame {
 

    public TelaCompra() {
        initComponents();
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jToggleButton1 = new javax.swing.JToggleButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        botãoRCompra = new javax.swing.JButton();
        campoNumCartao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Compra");
        setLocation(new java.awt.Point(800, 200));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(139, 0, 0));
        jPanel2.setPreferredSize(new java.awt.Dimension(46, 44));
        jPanel2.setRequestFocusEnabled(false);

        jToggleButton1.setBackground(new java.awt.Color(139, 0, 0));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/pngwing1.com.png"))); // NOI18N
        jToggleButton1.setBorder(null);
        jToggleButton1.setBorderPainted(false);
        jToggleButton1.setContentAreaFilled(false);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/BradescoLogo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(139, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 37, Short.MAX_VALUE)
        );

        botãoRCompra.setBackground(new java.awt.Color(153, 0, 0));
        botãoRCompra.setFont(new java.awt.Font("Bradesco Sans", 0, 12)); // NOI18N
        botãoRCompra.setForeground(new java.awt.Color(0, 0, 0));
        botãoRCompra.setText("Realizar Compra");
        botãoRCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botãoRCompraActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Bradesco Sans", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Numero do cartão:");

        jLabel3.setFont(new java.awt.Font("Bradesco Sans", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Valor da compra: 100R$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(botãoRCompra))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(campoNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(91, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoNumCartao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(botãoRCompra)
                .addGap(28, 28, 28)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
       this.setVisible(false);
       TelaEscolha t9 = new TelaEscolha();
       t9.setVisible(true);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void botãoRCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botãoRCompraActionPerformed
        realizarCompra();
      
    }//GEN-LAST:event_botãoRCompraActionPerformed
     int escolha;
    String[] opcoes = {"Confirmar", "Recusar"};     
 private void realizarCompra() {
    
       String numCartaoDigitado = campoNumCartao.getText().trim();

    if (numCartaoDigitado.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Por favor, insira o número do cartão antes de realizar a compra.", "Campo obrigatório", JOptionPane.WARNING_MESSAGE);
        return;
    }

    SessaoUsuario.setNumeroCartao(numCartaoDigitado); // Atualiza o cartão na sessão se quiser usar
    String numCartao = SessaoUsuario.getNumeroCartao();
    try (Connection conn = ConexaoBD.conectar()) {
        
        String sql = "SELECT limite FROM dadosCart WHERE numCart = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, numCartao);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            double limite = rs.getDouble("limite");
            boolean limiteNulo = rs.wasNull();  

            double limiteCartao = 1000;
            double valorCompra = 300;

            StatusCompra status;

            if (limiteNulo) {
                    status = StatusCompra.APROVADA;
                    JOptionPane.showMessageDialog(this, "Compra " + status); 
                this.setVisible(false);
                TelaInicial t10 = new TelaInicial();
                t10.setVisible(true);
                    
            } else if (valorCompra <= limite && valorCompra <= limiteCartao) {
                status = StatusCompra.APROVADA;
                JOptionPane.showMessageDialog(this, status.getMensagem(), status.getTitulo(), JOptionPane.INFORMATION_MESSAGE);
            } else {
                this.setVisible(false);
                TelaInicial t10 = new TelaInicial();
                t10.setVisible(true);

                status = StatusCompra.AGUARDANDO_CONFIRMACAO;
                System.out.println(status);

                int escolha = JOptionPane.showOptionDialog(
                    null,
                    "Você deseja confirmar a operação?\n" + valorCompra + " R$",
                    status.getTitulo(),
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
                );

                if (escolha == 0) {
                    status = StatusCompra.APROVADA;
                    JOptionPane.showMessageDialog(this, "Compra " + status);
                    System.out.println("Compra " + status);
                } else if (escolha == 1) {
                    status = StatusCompra.RECUSADA;
                    JOptionPane.showMessageDialog(this, "Compra " + status);
                    System.out.println("Compra " + status);
                } else {
                    System.out.println("Usuário fechou a janela ou cancelou.");
                }
            }
        } else {
            StatusCompra status = StatusCompra.CARTAO_NAO_ENCONTRADO;
            JOptionPane.showMessageDialog(this, status.getMensagem(), status.getTitulo(), JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException ex) {
        StatusCompra status = StatusCompra.ERRO_BANCO;
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, status.getMensagem(), status.getTitulo(), JOptionPane.ERROR_MESSAGE);
    }
}



     
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCompra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botãoRCompra;
    private javax.swing.JTextField campoNumCartao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
