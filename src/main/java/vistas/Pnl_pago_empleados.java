/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vistas;

import controladores.PlanillaEmpleados;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import utilerias.PlanillaEmpleadosDAO;

/**
 *
 * @author Contrerasalexa1907
 */
public class Pnl_pago_empleados extends javax.swing.JPanel {

    /**
     * Creates new form Pnl_pago_empleados
     */
    DefaultListModel moEmpleado,moPagoHora,
                 moBonificacion,moSueldo,moEstadisticas;
    
    PlanillaEmpleados objP;
    
    public Pnl_pago_empleados() {
        PlanillaEmpleadosDAO dao = new PlanillaEmpleadosDAO();
        
        initComponents();
        llenaCargo();
        llenaModalidad();
        cargaModelos();
        cargarDesdeBD();
    }
    
    //1
    void llenaCargo(){
        cboCargo.removeAllItems();
        cboCargo.addItem("Gerente");
        cboCargo.addItem("Administrativo");
        cboCargo.addItem("Jefe");
        cboCargo.addItem("Operario");
    }

    //2
    void llenaModalidad(){
        cboModalidad.removeAllItems();
        cboModalidad.addItem("Tiempo Completo");
        cboModalidad.addItem("Tiempo Parcial");
    }

    //3
    void cargaModelos(){
        moEmpleado = new DefaultListModel();
        moPagoHora = new DefaultListModel();
        moBonificacion = new DefaultListModel();
        moSueldo = new DefaultListModel();
        moEstadisticas = new DefaultListModel();

        lstEmpleado.setModel(moEmpleado);
        lstPagoxHora.setModel(moPagoHora);
        lstBonificacion.setModel(moBonificacion);
        lstSueldo.setModel(moSueldo);
        lstEstadisticas.setModel(moEstadisticas);
    }
    
    //3
    String getEmpleado(){
        return txtEmpleado.getText().trim();
    }

    //4
    int getHoras(){
        return Integer.parseInt(txtHoras.getText());
    }

    //5
    int getCargo(){
        return cboCargo.getSelectedIndex();
    }

    //6
    int getModalidad(){
        return cboModalidad.getSelectedIndex();
    }
    
    //8
    void imprimeEstadisticas(){
        moEstadisticas.clear();

        moEstadisticas.addElement("El Total de Empleados es: " + objP.getTotal());
        moEstadisticas.addElement("-----------------------------------");
        moEstadisticas.addElement("Gerentes: " + objP.getTotalGerentes());
        moEstadisticas.addElement("Administrativos: " + objP.getTotalAdministrativo());
        moEstadisticas.addElement("Jefes: " + objP.getTotalJefes());
        moEstadisticas.addElement("Operarios: " + objP.getTotalOperario());
        moEstadisticas.addElement("-----------------------------------");
        moEstadisticas.addElement("Menos de $1200: " + objP.getTotalmenor1200());
        moEstadisticas.addElement("Entre $1200 y $2500: " + objP.getTotalEntre1200y2500());
        moEstadisticas.addElement("Más de $2500: " + objP.getTotalmas2500());
    }    
    
    //9
    String valida(){
        if (txtEmpleado.getText().trim().equals(""))
            return "Nombre del Empleado";

        if (txtHoras.getText().trim().equals(""))
            return "Horas de trabajo";

        try {
            int h = Integer.parseInt(txtHoras.getText());
            if (h < 0) return "Horas inválidas";
        } catch (Exception e) {
            return "Horas debe ser número";
        }

        if (cboCargo.getSelectedIndex() == -1)
            return "Cargo del empleado";

        if (cboModalidad.getSelectedIndex() == -1)
            return "Modalidad del empleado";

        return "";
    }

    void limpiarCampos(){
        txtEmpleado.setText("");
        txtHoras.setText("");
        cboCargo.setSelectedIndex(-1);
        cboModalidad.setSelectedIndex(-1);
        txtEmpleado.requestFocus();
    }
   
    void cargarDesdeBD(){

        PlanillaEmpleadosDAO dao = new PlanillaEmpleadosDAO();
        var lista = dao.listar();

        // Limpiar primero
        moEmpleado.clear();
        moPagoHora.clear();
        moBonificacion.clear();
        moSueldo.clear();

        for (Object[] fila : lista) {

            String nombre = fila[0].toString();
            int horas = (int) fila[1];
            int cargo = (int) fila[2];
            int modalidad = (int) fila[3];

            double pagoHora = (double) fila[4];
            double bonificacion = (double) fila[6];
            double sueldo = (double) fila[7];

            // Mostrar en UI
            moEmpleado.addElement(nombre);
            moPagoHora.addElement(pagoHora);
            moBonificacion.addElement(bonificacion);
            moSueldo.addElement(sueldo);

            // 🔥 IMPORTANTE: reconstruir contadores
            new PlanillaEmpleados(horas, cargo, modalidad);
        }

        // Actualizar estadísticas después de cargar
        imprimeEstadisticas();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEmpleado = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboCargo = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cboModalidad = new javax.swing.JComboBox<>();
        btnLimpiar = new javax.swing.JButton();
        btnProcesar = new javax.swing.JButton();
        btnEstadisticas = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstEmpleado = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstPagoxHora = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstBonificacion = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstSueldo = new javax.swing.JList<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstEstadisticas = new javax.swing.JList<>();

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Rockwell", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PAGO DE EMPLEADOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres y Apellidos del empleado");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        txtEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 430, 40));

        jLabel3.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cargo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtHoras.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(txtHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 190, 40));

        jLabel4.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Horas Trabajadas");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, -1, 30));

        jPanel1.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 430, 40));

        jLabel5.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Modalidad de empleo");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, -1, -1));

        jPanel1.add(cboModalidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 190, 40));

        btnLimpiar.setBackground(new java.awt.Color(184, 224, 210));
        btnLimpiar.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(this::btnLimpiarActionPerformed);
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 210, 40));

        btnProcesar.setBackground(new java.awt.Color(128, 155, 206));
        btnProcesar.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnProcesar.setForeground(new java.awt.Color(255, 255, 255));
        btnProcesar.setText("PROCESAR");
        btnProcesar.setToolTipText("");
        btnProcesar.addActionListener(this::btnProcesarActionPerformed);
        jPanel1.add(btnProcesar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 200, 40));

        btnEstadisticas.setBackground(new java.awt.Color(244, 244, 160));
        btnEstadisticas.setFont(new java.awt.Font("Rockwell", 1, 18)); // NOI18N
        btnEstadisticas.setForeground(new java.awt.Color(255, 255, 255));
        btnEstadisticas.setText("ESTADISTICAS");
        btnEstadisticas.setToolTipText("");
        btnEstadisticas.addActionListener(this::btnEstadisticasActionPerformed);
        jPanel1.add(btnEstadisticas, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 190, 40));

        jLabel6.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Empleado");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane1.setViewportView(lstEmpleado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 220, 110));

        jLabel7.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("PH");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane2.setViewportView(lstPagoxHora);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 100, 110));

        jLabel8.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Bonificación");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, -1));

        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane3.setViewportView(lstBonificacion);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 130, 110));

        jLabel9.setFont(new java.awt.Font("Rockwell", 1, 20)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Sueldo Neto");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 260, -1, -1));

        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane4.setViewportView(lstSueldo);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 170, 110));

        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jScrollPane5.setViewportView(lstEstadisticas);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 650, 330));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnProcesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProcesarActionPerformed
        // TODO add your handling code here:
        String error = valida();

        if (!error.equals("")) {
            JOptionPane.showMessageDialog(null, "Falta: " + error);
            return;
        }

        // 🔹 Datos
        String nombre = getEmpleado();
        int horas = getHoras();
        int cargo = getCargo();
        int modalidad = getModalidad();

        // 🔹 Lógica
        PlanillaEmpleados obj = new PlanillaEmpleados(horas, cargo, modalidad);

        double pagoHora = obj.asignaPagoxHora();
        double bruto = obj.calculaBruto();
        double bonificacion = obj.asignaBonificacion(bruto);
        double neto = obj.calculaSueldo();

        // 🔹 Mostrar en listas
        moEmpleado.addElement(nombre);
        moPagoHora.addElement(pagoHora);
        moBonificacion.addElement(bonificacion);
        moSueldo.addElement(neto);

        // 🔥 BD
        PlanillaEmpleadosDAO dao = new PlanillaEmpleadosDAO();
        dao.insertar(nombre, horas, cargo, modalidad, pagoHora, bruto, bonificacion, neto);

        // 🔹 Estadísticas
        imprimeEstadisticas();
    }//GEN-LAST:event_btnProcesarActionPerformed

    private void btnEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadisticasActionPerformed
        // TODO add your handling code here:
        imprimeEstadisticas();
    }//GEN-LAST:event_btnEstadisticasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEstadisticas;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnProcesar;
    private javax.swing.JComboBox<String> cboCargo;
    private javax.swing.JComboBox<String> cboModalidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JList<String> lstBonificacion;
    private javax.swing.JList<String> lstEmpleado;
    private javax.swing.JList<String> lstEstadisticas;
    private javax.swing.JList<String> lstPagoxHora;
    private javax.swing.JList<String> lstSueldo;
    private javax.swing.JTextField txtEmpleado;
    private javax.swing.JTextField txtHoras;
    // End of variables declaration//GEN-END:variables
}
