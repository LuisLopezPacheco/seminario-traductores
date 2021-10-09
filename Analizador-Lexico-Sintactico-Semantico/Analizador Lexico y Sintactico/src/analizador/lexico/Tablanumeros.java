/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador.lexico;

/**
 *
 * @author LAB
 */
public class Tablanumeros {
  int id;
  String nombre;
  String tokens;

    public Tablanumeros(int id, String nombre, String tokens) {
        this.id = id;
        this.nombre = nombre;
        this.tokens = tokens;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTokens() {
        return tokens;
    }

    public void setTokens(String tokens) {
        this.tokens = tokens;
    }
  
  
}
