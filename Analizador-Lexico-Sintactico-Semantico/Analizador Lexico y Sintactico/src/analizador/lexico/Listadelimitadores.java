/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package analizador.lexico;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

/**
 *
 * @author LAB
 */
public class Listadelimitadores {
  private Vector<Tabladelimitadores> L ;

    public Listadelimitadores()
    {
        L = new Vector<Tabladelimitadores>();

    }

    public void agregar(Tabladelimitadores e)
    {
        L.add(e);
    }

   // el indexOf busca usando el equals de las clases
    public int buscar(Tabladelimitadores e)
    {
        return L.indexOf(e);
    }

   public void ordenar(Comparator<Tabladelimitadores> cs)
    {
		Collections.sort(L,cs);
	}


   public int buscar(Tabladelimitadores key,Comparator<Tabladelimitadores> cs)
	{
        Collections.sort(L,cs);
		return Collections.binarySearch(L, key, cs);
	}

    public void eliminar(int i)
    {
        L.remove(i);
    }

    public Tabladelimitadores getElemento(int i)
    {
        return L.get(i);
    }

    public int getN()
    {
        return L.size();
    }

    public void inserta(int i, Tabladelimitadores e)
    {
        L.add(i,e);
    }

    public void reemplaza(int i, Tabladelimitadores e)
    {
        L.set(i,e);
    }
    public Vector<Tabladelimitadores> getL()
    {
        return L;
    }

    public void mostrar()
    {
      for(Tabladelimitadores e:L)
        	System.out.println(e);
    }

     public int buscarpordni(String dni){
     for(int i = 0;i<L.size();i++){
        Tabladelimitadores x = L.get(i);
         if(x.getNombre().equals(dni)){
             return i;
         }
     }
     return -1;
    }
              
    
    public Object[] devuelveNombreUsuario()    {
        Object datos[]= new Object[L.size()];
        for(int i=0;i<L.size();i++)
        {
            Tabladelimitadores x=L.get(i);
            datos[i]=x.getNombre();
            //datos[i][1]=x.getDireccion();
        }
        return datos;
    }
   
    public Object[][] devuelveDatos()    {
        Object datos[][]=new Object[L.size()][4];
        for(int i=0;i<L.size();i++)
        {
            Tabladelimitadores x=L.get(i);
            datos[i][0]=x.getId();
            datos[i][1]=x.getNombre();
            datos[i][2]=x.getTokens();

;

          
        }
        return datos;
    }
 
    public int BuscarNom(String Nombre)
    {
       int respuesta=0;
       Listatablasimbolos R= new Listatablasimbolos();
       for(int i=0;i<L.size();i++)
       {
            Tabladelimitadores x = L.get(i);          
            if(x.getNombre().equals(Nombre))
            respuesta=1;
          
       }
       return respuesta;
    }   
    
    
     public int BuscarID(String Nombre)
    {
       int respuesta=0;
       Listatablasimbolos R= new Listatablasimbolos();
       for(int i=0;i<L.size();i++)
       {
            Tabladelimitadores x = L.get(i);          
            if(x.getNombre().equals(Nombre))
            respuesta=x.getId();
          
       }
       return respuesta;
    }   
     
      public double devuelID()    {
    Object datos[]= new Object[L.size()];
    double total=0;
        for(int i=0;i<L.size();i++)
        {
            Tabladelimitadores x=L.get(i);
            datos[i]=x.getId();
            total=(int)datos[i];
            //datos[i][1]=x.getDireccion();
        }
        return total;
    }  
      
     public String Obtenernombre(int Nombre)
    {
       String respuesta="";
       Listatablasimbolos R= new Listatablasimbolos();
       for(int i=0;i<L.size();i++)
       {
            Tabladelimitadores x = L.get(i);          
            if(x.getId()==Nombre)
            respuesta=x.getNombre();
          
       }
       return respuesta;
    }   
        
      
     
}
