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
import javax.swing.JOptionPane;

/**
 *
 * @author Yilber
 */
public class Controlador implements ActionListener {

    private Principal vista;
    private Tablero tablero;
    private String historialJugadas;

    public Controlador(Principal vista) {
        this.vista = vista;
        this.vista.btnJugar.addActionListener(this);
        this.vista.btnPdf.addActionListener(this);
    }

    public String getHistorialJugadas() {
        return historialJugadas;
    }

    public void setHistorialJugadas(String historialJugadas) {
        this.historialJugadas = historialJugadas;
    }

    public void iniciar() {
        vista.setTitle("Proyecto Alfil");
        vista.setLocationRelativeTo(null);
    }

    public String validarCampos(String filaAlfil, String columnaAlfil, String filaPeon, String columnaPeon) {
        if (filaAlfil.isBlank() || columnaAlfil.isBlank() || filaPeon.isBlank() || columnaPeon.isBlank()) {
            return "Rellene los campos";
        }
        try {
            int i_alfil = Integer.parseInt(filaAlfil);
            int j_alfil = Integer.parseInt(columnaAlfil);
            int i_peon = Integer.parseInt(filaPeon);
            int j_peon = Integer.parseInt(columnaPeon);
            if (i_alfil < 1 || i_alfil > 8) {
                return "La fila del alfil recibe un numero entre 1-8";
            }
            if (j_alfil < 1 || j_alfil > 8) {
                return "La columna del alfil recibe un numero entre 1-8";
            }
            if (i_peon < 1 || i_peon > 8) {
                return "La fila del peon recibe un numero entre 1-8";
            }
            if (j_peon < 1 || j_peon > 8) {
                return "La columna del peon recibe un numero entre 1-8";
            }
            if (i_alfil == i_peon && j_alfil == j_peon) {
                return "Las fichas no pueden estar en la misma posicion";
            }
        } catch (Exception e) {
            return "Ingrese numeros no letras";
        }
        return "aprobado";
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
            String filaAlfil = vista.txtFilaAlfil.getText();
            String columnaAlfil = vista.txtColumnaAlfil.getText();
            String filaPeon = vista.txtFilaPeon.getText();
            String columnaPeon = vista.txtColumnaPeon.getText();
            String validacion = validarCampos(filaAlfil, columnaAlfil, filaPeon, columnaPeon);
            if (validacion.equals("aprobado")) {
                int i_alfil = Integer.parseInt(filaAlfil) - 1;
                int j_alfil = Integer.parseInt(columnaAlfil) - 1;
                int i_peon = Integer.parseInt(filaPeon) - 1;
                int j_peon = Integer.parseInt(columnaPeon) - 1;
                this.tablero = new Tablero(i_alfil, j_alfil, i_peon, j_peon, dirPeon);
                System.out.println(this.tablero.mostrar());
                JOptionPane.showMessageDialog(null, "EL JUEGO YA FUE PROCESADO");
            } else {
                JOptionPane.showMessageDialog(null, validacion, "Error!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
