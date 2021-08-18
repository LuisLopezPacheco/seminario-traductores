/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;

import java.io.File;

/**
 *
 * @author david
 */
public class Index {
    public static void main(String[] args) {
        
       //ruta a ReglasLexicas.flex
        String ruta = "C:/Users/josue/Documents/NetBeansProjects/mini_analizador/src/codigo/Lexer.flex";
        GenerarLexico(ruta);
    
    }
    
    public static void  GenerarLexico(String ruta){
        File archivo = new File(ruta);
        JFlex.Main.generate(archivo);
    }
    
}
