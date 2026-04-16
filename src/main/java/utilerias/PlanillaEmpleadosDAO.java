/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Contrerasalexa1907
 */
public class PlanillaEmpleadosDAO {
    public void insertar(String nombre, int horas, int cargo, int modalidad,
                         double pagoHora, double bruto, double bonificacion, double neto) {

        try {
            Connection cn = new ConexionBD().conectar();

            String sql = "INSERT INTO planilla_empleados " +
                    "(nombre, horas, cargo, modalidad, pago_hora, sueldo_bruto, bonificacion, sueldo_neto) " +
                    "VALUES (?,?,?,?,?,?,?,?)";

            PreparedStatement ps = cn.prepareStatement(sql);

            ps.setString(1, nombre);
            ps.setInt(2, horas);
            ps.setInt(3, cargo);
            ps.setInt(4, modalidad);
            ps.setDouble(5, pagoHora);
            ps.setDouble(6, bruto);
            ps.setDouble(7, bonificacion);
            ps.setDouble(8, neto);

            ps.executeUpdate();

            cn.close();

        } catch (Exception e) {
            System.out.println("Error al insertar: " + e.getMessage());
        }
    }
    
    public ArrayList<Object[]> listar() {

        ArrayList<Object[]> lista = new ArrayList<>();

        try {
            Connection cn = new ConexionBD().conectar();

            String sql = "SELECT nombre, horas, cargo, modalidad, pago_hora, sueldo_bruto, bonificacion, sueldo_neto FROM planilla_empleados";

            PreparedStatement ps = cn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Object[] fila = new Object[8];

                fila[0] = rs.getString("nombre");
                fila[1] = rs.getInt("horas");
                fila[2] = rs.getInt("cargo");
                fila[3] = rs.getInt("modalidad");
                fila[4] = rs.getDouble("pago_hora");
                fila[5] = rs.getDouble("sueldo_bruto");
                fila[6] = rs.getDouble("bonificacion");
                fila[7] = rs.getDouble("sueldo_neto");

                lista.add(fila);
            }

            cn.close();

        } catch (Exception e) {
            System.out.println("Error al listar: " + e.getMessage());
        }

        return lista;
    }
}