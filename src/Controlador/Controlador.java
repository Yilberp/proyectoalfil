/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yilber
 */
public class Controlador implements ActionListener {

    public Principal vista;

    public Controlador(Principal vista) {
        this.vista = vista;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean dirPeon = vista.boxDireccion.getName().equals("Ir hacia abajo");
        int i_alfil = Integer.parseInt(vista.txtFilaAlfil.getText());
        int j_alfil = Integer.parseInt(vista.txtColumnaAlfil.getText());
        int i_peon = Integer.parseInt(vista.txtFilaPeon.getText());
        int j_peon = Integer.parseInt(vista.txtColumnaPeon.getText());
    }
}
