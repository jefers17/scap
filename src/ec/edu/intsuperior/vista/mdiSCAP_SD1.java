/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.vista;



/**
 *
 * @author RaMIRO
 */
public class mdiSCAP_SD1 extends javax.swing.JFrame {

    /**
     * Creates new form mdiSCAP_SD1
     */
    public mdiSCAP_SD1() {
        initComponents();
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        panel = new javax.swing.JPanel();
        mSCAP_SD1 = new javax.swing.JMenuBar();
        mParametros = new javax.swing.JMenu();
        mpSocios = new javax.swing.JMenuItem();
        mpImplementos = new javax.swing.JMenuItem();
        mpServicios = new javax.swing.JMenuItem();
        mpCargosEmpleados = new javax.swing.JMenuItem();
        mProcesos = new javax.swing.JMenu();
        mprMedidores = new javax.swing.JMenuItem();
        mprInventario = new javax.swing.JMenuItem();
        mprMantenimiento = new javax.swing.JMenuItem();
        mprServicios = new javax.swing.JMenuItem();
        mprCobroAgua = new javax.swing.JMenuItem();
        mReportes = new javax.swing.JMenu();
        mrEmpleados = new javax.swing.JMenuItem();
        mrCargos = new javax.swing.JMenuItem();
        mrSocios = new javax.swing.JMenuItem();
        mrMaterialesHerramientas = new javax.swing.JMenuItem();
        mrMultas = new javax.swing.JMenuItem();
        mrMedidores = new javax.swing.JMenuItem();
        mrInventario = new javax.swing.JMenuItem();
        mrMantenimiento = new javax.swing.JMenuItem();
        mrServicios = new javax.swing.JMenuItem();
        mrKardex = new javax.swing.JMenuItem();
        mrUsuarios = new javax.swing.JMenuItem();
        mrPlanillas = new javax.swing.JMenuItem();
        mSeguridad = new javax.swing.JMenu();
        msUsuarios = new javax.swing.JMenuItem();
        msResetearClave = new javax.swing.JMenuItem();
        msResetearDB = new javax.swing.JMenuItem();
        mAyuda = new javax.swing.JMenu();
        maAyuda = new javax.swing.JMenuItem();
        maAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jToolBar1.setRollover(true);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 351, Short.MAX_VALUE)
        );

        mParametros.setText("Parametros");

        mpSocios.setText("Socios");
        mpSocios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpSociosActionPerformed(evt);
            }
        });
        mParametros.add(mpSocios);

        mpImplementos.setText("Implementos");
        mpImplementos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpImplementosActionPerformed(evt);
            }
        });
        mParametros.add(mpImplementos);

        mpServicios.setText("Servicios");
        mpServicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpServiciosActionPerformed(evt);
            }
        });
        mParametros.add(mpServicios);

        mpCargosEmpleados.setText("Cargos Empleados");
        mpCargosEmpleados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpCargosEmpleadosActionPerformed(evt);
            }
        });
        mParametros.add(mpCargosEmpleados);

        mSCAP_SD1.add(mParametros);

        mProcesos.setText("Procesos");

        mprMedidores.setText("Medidores");
        mProcesos.add(mprMedidores);

        mprInventario.setText("Inventario");
        mProcesos.add(mprInventario);

        mprMantenimiento.setText("Mantenimiento");
        mprMantenimiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mprMantenimientoActionPerformed(evt);
            }
        });
        mProcesos.add(mprMantenimiento);

        mprServicios.setText("Servicios");
        mProcesos.add(mprServicios);

        mprCobroAgua.setText("Cobro de Agua");
        mProcesos.add(mprCobroAgua);

        mSCAP_SD1.add(mProcesos);

        mReportes.setText("Reportes");

        mrEmpleados.setText("Empleados");
        mReportes.add(mrEmpleados);

        mrCargos.setText("Cargos");
        mReportes.add(mrCargos);

        mrSocios.setText("Socios");
        mReportes.add(mrSocios);

        mrMaterialesHerramientas.setText("Materiales y Herramientas");
        mReportes.add(mrMaterialesHerramientas);

        mrMultas.setText("Multas");
        mReportes.add(mrMultas);

        mrMedidores.setText("Medidores");
        mReportes.add(mrMedidores);

        mrInventario.setText("Inventario");
        mReportes.add(mrInventario);

        mrMantenimiento.setText("Mantenimiento");
        mReportes.add(mrMantenimiento);

        mrServicios.setText("Servicios");
        mReportes.add(mrServicios);

        mrKardex.setText("Kardex");
        mReportes.add(mrKardex);

        mrUsuarios.setText("Usuarios");
        mReportes.add(mrUsuarios);

        mrPlanillas.setText("Planillas");
        mReportes.add(mrPlanillas);

        mSCAP_SD1.add(mReportes);

        mSeguridad.setText("Seguridad");

        msUsuarios.setText("Usuarios");
        mSeguridad.add(msUsuarios);

        msResetearClave.setText("Resetear clave usuario");
        mSeguridad.add(msResetearClave);

        msResetearDB.setText("Reiniciar DB");
        mSeguridad.add(msResetearDB);

        mSCAP_SD1.add(mSeguridad);

        mAyuda.setText("Ayuda");

        maAyuda.setText("Ayuda");
        mAyuda.add(maAyuda);

        maAcercaDe.setText("Acerca de...");
        mAyuda.add(maAcercaDe);

        mSCAP_SD1.add(mAyuda);

        setJMenuBar(mSCAP_SD1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mprMantenimientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mprMantenimientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mprMantenimientoActionPerformed

    private void mpServiciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpServiciosActionPerformed
        // TODO add your handling code here:
        JFservicio ob = new JFservicio();
        this.panel.add(ob);
        ob.show();
    }//GEN-LAST:event_mpServiciosActionPerformed

    private void mpCargosEmpleadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpCargosEmpleadosActionPerformed
        jiFrmCargosEmpleados obj = new jiFrmCargosEmpleados();
        this.panel.add(obj);
        obj.show();
    }//GEN-LAST:event_mpCargosEmpleadosActionPerformed

    private void mpSociosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpSociosActionPerformed
        // TODO add your handling code here:
        jFSocios obj = new jFSocios();
        this.panel.add(obj);
        obj.show();
    }//GEN-LAST:event_mpSociosActionPerformed

    private void mpImplementosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpImplementosActionPerformed
        // TODO add your handling code here:
       JfrImplementos obj = new JfrImplementos();
        this.panel.add(obj);
        obj.show(); 
    }//GEN-LAST:event_mpImplementosActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(mdiSCAP_SD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mdiSCAP_SD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mdiSCAP_SD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mdiSCAP_SD1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mdiSCAP_SD1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JMenu mAyuda;
    private javax.swing.JMenu mParametros;
    private javax.swing.JMenu mProcesos;
    private javax.swing.JMenu mReportes;
    private javax.swing.JMenuBar mSCAP_SD1;
    private javax.swing.JMenu mSeguridad;
    private javax.swing.JMenuItem maAcercaDe;
    private javax.swing.JMenuItem maAyuda;
    private javax.swing.JMenuItem mpCargosEmpleados;
    private javax.swing.JMenuItem mpImplementos;
    private javax.swing.JMenuItem mpServicios;
    private javax.swing.JMenuItem mpSocios;
    private javax.swing.JMenuItem mprCobroAgua;
    private javax.swing.JMenuItem mprInventario;
    private javax.swing.JMenuItem mprMantenimiento;
    private javax.swing.JMenuItem mprMedidores;
    private javax.swing.JMenuItem mprServicios;
    private javax.swing.JMenuItem mrCargos;
    private javax.swing.JMenuItem mrEmpleados;
    private javax.swing.JMenuItem mrInventario;
    private javax.swing.JMenuItem mrKardex;
    private javax.swing.JMenuItem mrMantenimiento;
    private javax.swing.JMenuItem mrMaterialesHerramientas;
    private javax.swing.JMenuItem mrMedidores;
    private javax.swing.JMenuItem mrMultas;
    private javax.swing.JMenuItem mrPlanillas;
    private javax.swing.JMenuItem mrServicios;
    private javax.swing.JMenuItem mrSocios;
    private javax.swing.JMenuItem mrUsuarios;
    private javax.swing.JMenuItem msResetearClave;
    private javax.swing.JMenuItem msResetearDB;
    private javax.swing.JMenuItem msUsuarios;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}