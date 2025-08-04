package front;


import front.TelaLogin;

public class TelaInicial extends javax.swing.JFrame {


    public TelaInicial() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        iconeBradesco = new javax.swing.JToggleButton();
        HubBaixo = new javax.swing.JLabel();
        HubCima = new javax.swing.JLabel();
        Fundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Inicial");
        setLocation(new java.awt.Point(800, 200));
        setPreferredSize(new java.awt.Dimension(313, 535));
        setResizable(false);

        Painel.setBackground(new java.awt.Color(204, 204, 204));
        Painel.setMinimumSize(new java.awt.Dimension(300, 500));
        Painel.setLayout(null);

        iconeBradesco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Bradesco.png"))); // NOI18N
        iconeBradesco.setBorder(null);
        iconeBradesco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconeBradescoActionPerformed(evt);
            }
        });
        Painel.add(iconeBradesco);
        iconeBradesco.setBounds(120, 220, 56, 53);

        HubBaixo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        HubBaixo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/HudCelular1.png"))); // NOI18N
        Painel.add(HubBaixo);
        HubBaixo.setBounds(0, 480, 320, 20);

        HubCima.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/HudCelular2.png"))); // NOI18N
        Painel.add(HubCima);
        HubCima.setBounds(0, 0, 300, 21);

        Fundo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Fundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/FundoBradesco.jpg"))); // NOI18N
        Painel.add(Fundo);
        Fundo.setBounds(0, 0, 300, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Painel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iconeBradescoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconeBradescoActionPerformed
        this.setVisible(false);
        TelaLogin t2 = new TelaLogin();
        t2.setVisible(true);

    }//GEN-LAST:event_iconeBradescoActionPerformed

    public static void main(String args[]) {

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fundo;
    private javax.swing.JLabel HubBaixo;
    private javax.swing.JLabel HubCima;
    private javax.swing.JPanel Painel;
    private javax.swing.JToggleButton iconeBradesco;
    // End of variables declaration//GEN-END:variables
}
