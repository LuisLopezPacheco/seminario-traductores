package analizador.lexico;

/**
 *
 * @author LAB
 */
public class Tabladelimitadores {
  int id;
  String nombre;
  String tokens;

    public Tabladelimitadores(int id, String nombre, String tokens) {
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
