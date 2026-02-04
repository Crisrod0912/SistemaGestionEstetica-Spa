package UI;

import IO.ServidorIO;
import IO.ServidorNotificacionIO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

public class Principal extends JFrame {

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        new Thread(new ServidorIO()).start();
        new Thread(new ServidorNotificacionIO()).start();
        Thread reloj;
        reloj = new Thread(() -> {
            java.text.SimpleDateFormat formatoHora = new SimpleDateFormat("hh:mm:ss a");
            java.text.SimpleDateFormat formatoFecha = new SimpleDateFormat("EEEE, dd 'de' MMMM 'de' yyyy", new java.util.Locale("es", "ES"));

            while (true) {
                String hora = formatoHora.format(new java.util.Date());
                String fecha = formatoFecha.format(new java.util.Date());

                javax.swing.SwingUtilities.invokeLater(() -> {
                    lblHora.setText("Hora: " + hora);
                    lblFecha.setText("Fecha: " + fecha);
                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    break;
                }
            }
        });
        reloj.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnClientes = new javax.swing.JButton();
        btnEmpleados = new javax.swing.JButton();
        btnReservas = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnRegistrarUsuario = new javax.swing.JButton();
        lblFecha = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 3, true), "Sistema de Gestion de Citas Hospitalarias", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18), new java.awt.Color(0, 51, 153))); // NOI18N
        jPanel1.setToolTipText("");

        btnClientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(0, 102, 204));
        btnClientes.setText("Gestión de Clientes");
        btnClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnEmpleados.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEmpleados.setForeground(new java.awt.Color(0, 102, 204));
        btnEmpleados.setText("Gestión de Empleados");
        btnEmpleados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadosActionPerformed(evt);
            }
        });

        btnReservas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReservas.setForeground(new java.awt.Color(0, 102, 204));
        btnReservas.setText("Gestión de Reservas");
        btnReservas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasActionPerformed(evt);
            }
        });

        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(0, 102, 204));
        btnSalir.setText("Salir");
        btnSalir.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        btnRegistrarUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnRegistrarUsuario.setForeground(new java.awt.Color(0, 102, 204));
        btnRegistrarUsuario.setText("Gestión de Usuario");
        btnRegistrarUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 153), 2, true));
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });

        lblFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFecha.setForeground(new java.awt.Color(0, 0, 102));
        lblFecha.setText("Fecha");

        lblHora.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 0, 102));
        lblHora.setText("00:00:00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHora)
                    .addComponent(lblFecha))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEmpleados, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReservas, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel1.getAccessibleContext().setAccessibleName("Sistema de Gestión Estética / Spa");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadosActionPerformed
        Empleados empleados = null;
        try {
            empleados = new Empleados(this);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        empleados.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnEmpleadosActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        Usuarios usuarios = null;
        try {
            usuarios = new Usuarios(this);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        usuarios.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        Clientes clientes = null;
        try {
            clientes = new Clientes(this);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        clientes.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasActionPerformed
        Reservas reservas = null;
        try {
            reservas = new Reservas(this);
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        reservas.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_btnReservasActionPerformed

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnEmpleados;
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnReservas;
    private javax.swing.JButton btnSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    // End of variables declaration//GEN-END:variables
}
