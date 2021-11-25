/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compilador;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Geovah
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String ruta1 = "C:/Users/josue/Desktop/Compilador/src/Compilador/Lexer.flex";
        String ruta2 = "C:/Users/josue/Desktop/Compilador/src/Compilador/LexerCup.flex";
        String[] rutaS = {"-parser", "Sintax", "C:/Users/josue/Desktop/Compilador/src/Compilador/Sintax.cup"};
        generar(ruta1, ruta2, rutaS);
    }
    
    public static void generar(String ruta1, String ruta2, String[] rutaS) throws IOException, Exception{
        File archivo;
        archivo = new File(ruta1);
        JFlex.Main.generate(archivo);
        archivo = new File(ruta2);
        JFlex.Main.generate(archivo);
        
        java_cup.Main.main(rutaS);
        
        Path rutaSym = Paths.get("C:/Users/josue/Desktop/Compilador/src/Compilador/sym.java");
        if (Files.exists(rutaSym)) {
            Files.delete(rutaSym);
        }
        Files.move(
                Paths.get("C:/Users/josue/Desktop/Compilador/sym.java"), 
                Paths.get("C:/Users/josue/Desktop/Compilador/src/Compilador/sym.java")
        );
        Path rutaSin = Paths.get("C:/Users/josue/Desktop/Compilador/src/Compilador/Sintax.java");
        if (Files.exists(rutaSin)) {
            Files.delete(rutaSin);
        }
        Files.move(
                Paths.get("C:/Users/josue/Desktop/Compilador/Sintax.java"), 
                Paths.get("C:/Users/josue/Desktop/Compilador/src/Compilador/Sintax.java")
        ); 
    }
   
}
