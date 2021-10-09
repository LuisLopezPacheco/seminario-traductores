
package analizador.lexico;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class ListaNumeros {
  private Vector<Tablanumeros> L ;

    public ListaNumeros()
    {
        L = new Vector<Tablanumeros>();

    }

    public void agregar(Tablanumeros e)
    {
        L.add(e);
    }

   // el indexOf busca usando el equals de las clases
    public int buscar(Tabladelimitadores e)
    {
        return L.indexOf(e);
    }

   public void ordenar(Comparator<Tablanumeros> cs)
    {
		Collections.sort(L,cs);
	}


   public int buscar(Tablanumeros key,Comparator<Tablanumeros> cs)
	{
        Collections.sort(L,cs);
		return Collections.binarySearch(L, key, cs);
	}

    public void eliminar(int i)
    {
        L.remove(i);
    }

    public Tablanumeros getElemento(int i)
    {
        return L.get(i);
    }

    public int getN()
    {
        return L.size();
    }

    public void inserta(int i, Tablanumeros e)
    {
        L.add(i,e);
    }

    public void reemplaza(int i, Tablanumeros e)
    {
        L.set(i,e);
    }
    public Vector<Tablanumeros> getL()
    {
        return L;
    }

    public void mostrar()
    {
      for(Tablanumeros e:L)
        	System.out.println(e);
    }

     public int buscarpordni(String dni){
     for(int i = 0;i<L.size();i++){
        Tablanumeros x = L.get(i);
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
            Tablanumeros x=L.get(i);
            datos[i]=x.getNombre();
            //datos[i][1]=x.getDireccion();
        }
        return datos;
    }
   
    public Object[][] devuelveDatos()    {
        Object datos[][]=new Object[L.size()][4];
        for(int i=0;i<L.size();i++)
        {
            Tablanumeros x=L.get(i);
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
            Tablanumeros x = L.get(i);          
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
            Tablanumeros x = L.get(i);          
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
            Tablanumeros x=L.get(i);
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
            Tablanumeros x = L.get(i);          
            if(x.getId()==Nombre)
            respuesta=x.getNombre();
          
       }
       return respuesta;
    }  
      
     
}

