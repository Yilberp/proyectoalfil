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

    public String jugar(String camino) {
        if ((i_alfil == 7 && dirPeon) || (i_alfil == 0 && !dirPeon)) {
            return camino;
        }
        int dir = (dirPeon ? 1 : -1);
        if (!seEncuentran(i_peon + dir, j_peon, i_alfil, j_alfil)) {
            camino = camino + " P(" + (i_peon + dir) + "," + j_peon;
            i_peon += dir;
        } else {
            if (!seEncuentran(i_peon + dir, j_peon, i_alfil + 1, j_alfil + 1)) {
                i_alfil++;
                j_alfil++;
            } else if (!seEncuentran(i_peon + dir, j_peon, i_alfil - 1, j_alfil - 1)) {
                i_alfil--;
                j_alfil--;
            } else if (!seEncuentran(i_peon + dir, j_peon, i_alfil + 1, j_alfil - 1)) {
                i_alfil++;
                j_alfil--;
            } else if (!seEncuentran(i_peon + dir, j_peon, i_alfil - 1, j_alfil + 1)) {
                i_alfil--;
                j_alfil++;
            }
            camino = camino + " A(" + (i_alfil) + "," + j_alfil;
        }
        return jugar(camino);
    }

    public boolean seEncuentran(int i_p, int j_p, int i_a, int j_a) {
        if (i_a < 0 || i_a > 7 || j_a < 0 || j_a > 7) {
            return false;
        }
        if (i_p == i_a && j_p == j_a) {
            return true;
        }
        boolean ans = false;
        ans = ans || seEncuentran(i_p, j_p, i_a - 1, j_a + 1);
        ans = ans || seEncuentran(i_p, j_p, i_a + 1, j_a - 1);
        ans = ans || seEncuentran(i_p, j_p, i_a + 1, j_a + 1);
        ans = ans || seEncuentran(i_p, j_p, i_a - 1, j_a - 1);
        return ans;
    }

}
