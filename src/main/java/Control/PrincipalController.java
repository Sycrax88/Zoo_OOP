/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import View.*;

/**
 *
 * @author douglas.alarcon
 */
public class PrincipalController {

    public static VistaPrincipal ventana = new VistaPrincipal();

    public static void mostrar() {
        ventana.setVisible(true);
    }

    public static void ocultar() {
        ventana.setVisible(false);
    }

    public static void botonVenta() {
        ocultar();
        VentaController.mostrar();
    }

    public static void botonPlan() {
        ocultar();
        PlanController.mostrar();
    }

    public static void botonAnimal() {
        ocultar();
        AnimalController.mostrar();
    }

}
