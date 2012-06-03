/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JTransitarios;

import Cargas.Carga;
import Cargas.Indiferenciada;
import Cargas.Perecivel;
import Cargas.Toxica;
import Clientes.Cliente;
import Clientes.SClientes;
import Servicos.Servico;
import Sistema.Sistema;
import Veiculos.SVeiculos;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;

public class JAddCargas extends javax.swing.JFrame {

    public static final int SERVICO_SIMPLES = 0;
    public static final int SERVICO_AEROPORTO = 1;
    public static final int SERVICO_QUERIDO_MUDEI_A_CASA = 2;
    public static final int SERVICO_PROFISSIONAIS_DISTRIBUICAO = 3;
    public static final int SERVICO_SERVICOS_SECRETOS = 4;
    private static int MAX_SIZE;
    Sistema sistema;
    //SVeiculos veiculos;
    //SClientes clientes;
    JEscolhaServico root;
    List<Carga> cargas;
    Servico servico;
    int tipo;
    Cliente cliente;

    public JAddCargas() {
        initComponents();

    }

    public JAddCargas(JEscolhaServico root, Sistema sistema, Cliente cliente, Servico s, int tipo) {
        //this.veiculos = veiculos;
        //this.clientes = clientes;
        this.sistema = sistema;
        this.cargas = new ArrayList<Carga>();
        this.servico = s;
        this.root = root;
        this.root.setVisible(false);
        this.cliente = cliente;
        
        initComponents();

        if (tipo < 0 || tipo > 4) {
            this.dispose();
        }
        this.jButton3.setEnabled(false);
        this.tipo = tipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLayeredPane3 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jScrollPane3.setViewportView(jList2);

        jScrollPane3.setBounds(0, 0, 190, 190);
        jLayeredPane1.add(jScrollPane3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton5.setText("+");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jButton5.setBounds(200, 0, 43, 23);
        jLayeredPane1.add(jButton5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton2.setText("-");
        jButton2.setPreferredSize(new java.awt.Dimension(25, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.setBounds(200, 30, 43, 23);
        jLayeredPane1.add(jButton2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton3.setText("Confirmar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jButton3.setBounds(210, 140, 90, 23);
        jLayeredPane1.add(jButton3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jButton4.setText("Cancelar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jButton4.setBounds(210, 170, 90, 23);
        jLayeredPane1.add(jButton4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Peso(Kg)");

        jLabel2.setText("Descrição");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jTextField1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78))
        );

        jPanel2.setBounds(0, 0, 240, 200);
        jLayeredPane3.add(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLayeredPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLayeredPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jLayeredPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static int getMAX_SIZE() {
        return MAX_SIZE;
    }

    public static void setMAX_SIZE(int MAX_SIZE) {
        JAddCargas.MAX_SIZE = MAX_SIZE;
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        this.root.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.root.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        SVeiculos sv = this.sistema.getVeiculos();
        if (this.sistema.criaPedido(servico, cargas)) {
            this.cliente.addServico(servico);
        SClientes sc = this.sistema.getClientes();
        sc.remove(cliente);
        sc.addCliente(cliente);
        new JShowServ(servico).setVisible(true);
        } 
        else {
            
            this.sistema.setVeiculos(sv);
            JOptionPane.showMessageDialog(this, "O PEDIDO NAO PODE SER EFECTUADO", "Informação", JOptionPane.INFORMATION_MESSAGE);
        }
        this.dispose();
        this.root.setVisible(true);
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:

        if (jTextField1.getText().equals("")
                || jTextArea1.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Prencha todos os campos.", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        try {
            Double d1 = Double.valueOf(jTextField1.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "DADOS invalidos", "Informação", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        double carga = new Double(jTextField1.getText()).doubleValue();
        String des = jTextArea1.getText();

        switch (this.tipo) {
            case JAddCargas.SERVICO_SIMPLES: {

                Carga c = new Indiferenciada(carga, des);
                this.cargas.add(c);
                break;
            }

            case JAddCargas.SERVICO_AEROPORTO: {

                Carga c = new Indiferenciada(carga, des);
                this.cargas.add(c);
                break;
            }
            case JAddCargas.SERVICO_QUERIDO_MUDEI_A_CASA: {

                Carga c = new Indiferenciada(carga, des);
                this.cargas.add(c);
                break;
            }
            case JAddCargas.SERVICO_PROFISSIONAIS_DISTRIBUICAO: {

                Carga c = new Perecivel(carga, des);
                this.cargas.add(c);
                break;
            }
            case JAddCargas.SERVICO_SERVICOS_SECRETOS: {

                Carga c = new Toxica(carga, des);
                this.cargas.add(c);
                break;
            }
        }
        this.update();

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int index = this.jList2.getSelectedIndex();
        this.cargas.remove(index);
        this.update();
    }//GEN-LAST:event_jButton2ActionPerformed

    public void update() {
        
        this.jTextArea1.setText("");
        this.jTextField1.setText("");

        Vector<String> vector = new Vector<String>();

        for (Carga c : this.cargas) {
            vector.add(c.getDescricao());
        }
        this.jList2.setListData(vector);
        if (this.cargas.size() == MAX_SIZE) {
            this.jButton5.setEnabled(false);
            this.jTextArea1.setEnabled(false);
            this.jTextField1.setEnabled(false);
            this.jButton3.setEnabled(true);
        }

        if (this.cargas.size() == 0) {
            this.jButton5.setEnabled(true);
            this.jTextArea1.setEnabled(true);
            this.jTextField1.setEnabled(true);
            jButton2.setEnabled(false);
            this.jButton3.setEnabled(false);
        } else {
            this.jButton5.setEnabled(true);
            jLayeredPane1.setEnabled(true);
            jButton2.setEnabled(true);
        }
    }
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane3;
    private javax.swing.JList jList2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
