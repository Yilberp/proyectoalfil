/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Ficha;

/**
 *
 * @author madar
 */
public class Tablero {

    private Ficha[][] myTablero;
    private Ficha alfil;
    private Ficha peon;
    private int i_alfil, j_alfil, i_peon, j_peon;
    private boolean dirPeon;

    //Adicione los atributos que considere necesarios para el correcto fucnioanmiento de su aplicación, si y solo si , no violen ninguna regla en POO
    public Tablero() {

    }

    /**
     * Constructor para iniciar el juego
     *
     * @param i_alfil Posición de la fila para el alfil
     * @param j_alfil Posición de la columna para el alfil
     * @param i_peon Posición de la fila para el peon
     * @param j_peon Posición de la columna para el alfil
     * @param dirPeon true si el peón se mueve de arriba hacia abajo, o false en
     * caso contrario
     */
    public Tablero(int i_alfil, int j_alfil, int i_peon, int j_peon, boolean dirPeon) {
        this.myTablero = new Ficha[8][8];
        this.alfil = new Ficha("alfil");
        this.peon = new Ficha("peon");
        this.i_alfil = i_alfil;
        this.j_alfil = j_alfil;
        this.i_peon = i_peon;
        this.j_peon = j_peon;
        this.dirPeon = dirPeon;

        this.myTablero[i_alfil][j_alfil] = this.getAlfil();
        this.myTablero[i_peon][j_peon] = this.getPeon();
    }

    public Ficha getAlfil() {
        return alfil;
    }

    public void setAlfil(Ficha alfil) {
        this.alfil = alfil;
    }

    public Ficha getPeon() {
        return peon;
    }

    public void setPeon(Ficha peon) {
        this.peon = peon;
    }

    public int getI_alfil() {
        return i_alfil;
    }

    public void setI_alfil(int i_alfil) {
        this.i_alfil = i_alfil;
    }

    public int getJ_alfil() {
        return j_alfil;
    }

    public void setJ_alfil(int j_alfil) {
        this.j_alfil = j_alfil;
    }

    public int getI_peon() {
        return i_peon;
    }

    public void setI_peon(int i_peon) {
        this.i_peon = i_peon;
    }

    public int getJ_peon() {
        return j_peon;
    }

    public void setJ_peon(int j_peon) {
        this.j_peon = j_peon;
    }

    public boolean isDirPeon() {
        return dirPeon;
    }

    public void setDirPeon(boolean dirPeon) {
        this.dirPeon = dirPeon;
    }

    public String jugar() {

        return null;
    }

    public String mostrar() {
        String msg = "";
        for (int i = 0; i < this.myTablero.length; i++) {
            for (int j = 0; j < this.myTablero[i].length; j++) {
                if (this.myTablero[i][j] != null) {
                    msg += this.myTablero[i][j].getNombreFicha() + "\t";
                } else {
                    msg += this.myTablero[i][j] + "\t";
                }
            }
            msg += "\n";
        }
        return msg;
    }

}
