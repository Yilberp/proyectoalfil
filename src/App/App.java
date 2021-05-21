/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Controlador.Controlador;
import Negocio.Tablero;
import Vista.Principal;

/**
 *
 * @author Yilber
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Principal vista = new Principal();
        Controlador controlador = new Controlador(vista);
        controlador.iniciar();
        vista.setVisible(true);
    }
    
}
