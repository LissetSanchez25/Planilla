/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gilberto
 */
public class ConexionBD {
    
    private static final String URL = "jdbc:mysql://localhost:3306/db_casacambio";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // tu contraseña si tienes
    
    public Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}