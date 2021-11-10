package Propiedades;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Propiedades {

    private ClassLoader cl;

    public Propiedades() {
        cl = Propiedades.class.getClassLoader();
    }

    public Properties getProperties(String nombreArchivo) {
        try {
            Properties propiedades = new Properties();
            propiedades.load(cl.getResourceAsStream(nombreArchivo));
            if (!propiedades.isEmpty()) {
                return propiedades;
            } else {
                return null;
            }
        } catch (IOException ex) {
            return null;
        }
    }

    public void setProperties(Properties prop, String direccion) {
        try {
            FileOutputStream os = new FileOutputStream(cl.getResource(direccion).getPath());//para ver los cambios al construir
            prop.store(os, "Configuracion");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Propiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
