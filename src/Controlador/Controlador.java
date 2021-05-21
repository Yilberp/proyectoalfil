/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Negocio.Tablero;
import Vista.Principal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Yilber
 */
public class Controlador implements ActionListener {

    private Principal vista;
    private Tablero tablero;

    public Controlador(Principal vista) {
        this.vista = vista;
        this.vista.btnJugar.addActionListener(this);
        this.vista.btnPdf.addActionListener(this);
    }

    public void iniciar() {
        vista.setTitle("Proyecto Alfil");
        vista.setLocationRelativeTo(null);
    }

    public void limpiar() {
        vista.txtFilaAlfil.setText("");
        vista.txtColumnaAlfil.setText("");
        vista.txtFilaPeon.setText("");
        vista.txtColumnaPeon.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.btnJugar)) {
            Boolean dirPeon = vista.boxDireccion.getSelectedItem().toString().equals("Ir hacia abajo");
            int i_alfil = Integer.parseInt(vista.txtFilaAlfil.getText())-1;
            int j_alfil = Integer.parseInt(vista.txtColumnaAlfil.getText())-1;
            int i_peon = Integer.parseInt(vista.txtFilaPeon.getText())-1;
            int j_peon = Integer.parseInt(vista.txtColumnaPeon.getText())-1;
            this.tablero = new Tablero(i_alfil, j_alfil, i_peon, j_peon, dirPeon);
            System.out.println(this.tablero.mostrar());
        }
    }
}
