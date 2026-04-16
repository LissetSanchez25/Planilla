/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

/**
 *
 * @author Contrerasalexa1907
 */
public class PlanillaEmpleados {

    //1
    private int horas, cargo, modalidad;

    //2 CONTADORES
    private static int total = 0;
    private static int tGerente = 0;
    private static int tAdministrativo = 0;
    private static int tJefe = 0;
    private static int tOperario = 0;

    private static int cMenos1200 = 0;
    private static int cEntre1200y2500 = 0;
    private static int cMas2500 = 0;

    //3 CONSTRUCTOR
    public PlanillaEmpleados(int horas, int cargo, int modalidad){
        this.horas = horas;
        this.cargo = cargo;
        this.modalidad = modalidad;

        total++;
        contadorCargos();
        contadorSueldo();
    }

    //4 PAGO POR HORA
    public double asignaPagoxHora(){
        switch(cargo){
            case 0: return 20;
            case 1: return 10;
            case 2: return 8;
            default: return 3.5;
        }
    }

    //5 BRUTO
    public double calculaBruto(){
        return horas * asignaPagoxHora();
    }

    //BONIFICACIÓN
    public double asignaBonificacion(double bruto){
        switch(modalidad){
            case 0: return 0.2 * bruto;
            default: return 0.05 * bruto;
        }
    }

    //SUELDO FINAL
    public double calculaSueldo(){
        double bruto = calculaBruto();
        return bruto + asignaBonificacion(bruto);
    }

    //6 CONTADOR DE CARGOS
    private void contadorCargos(){
        switch(cargo){
            case 0: tGerente++; break;
            case 1: tAdministrativo++; break;
            case 2: tJefe++; break;
            default: tOperario++;
        }
    }

    //7 CONTADOR POR SUELDO (TE FALTABA ESTE)
    private void contadorSueldo(){
        double sueldo = calculaSueldo();

        if (sueldo < 1200)
            cMenos1200++;
        else if (sueldo <= 2500)
            cEntre1200y2500++;
        else
            cMas2500++;
    }

    //========================
    // GETTERS (LOS QUE USA TU UI)
    //========================

    public static int getTotal(){
        return total;
    }

    public static int getTotalGerentes(){
        return tGerente;
    }

    public static int getTotalAdministrativo(){
        return tAdministrativo;
    }

    public static int getTotalJefes(){
        return tJefe;
    }

    public static int getTotalOperario(){
        return tOperario;
    }

    public static int getTotalmenor1200(){
        return cMenos1200;
    }

    public static int getTotalEntre1200y2500(){
        return cEntre1200y2500;
    }

    public static int getTotalmas2500(){
        return cMas2500;
    }
}