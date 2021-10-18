using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace analizadorLexico
{
    class ElementoPila
    {
        public const int ERROR = -1;
        public const int IDENTIFICADOR = 0;
        public const int SIMBOLO = 1;
        public const int SIGNOPESO = 2;
        public const int E = 3;
        public const int INICIAL = 5;

        public int tipo;
        public String simbolo;

        public ElementoPila()
        {
            
        }

        public String ToString()
        {
            return simbolo;
        }
    }

    class Terminal : ElementoPila
    {
        public Terminal(int id)
        {
            tipo = id;
            if (id == SIGNOPESO)
            {
                simbolo = "$";
            }
        }

        public Terminal(String sim)
        {
            simbolo = sim;
        }
    }

    class NoTerminal : ElementoPila
    {
        public NoTerminal(String sim)
        {
            simbolo = sim;
        }
        public Nodo nodo { get; set; }
        String texto;
    }

    class Estado : ElementoPila
    {
        public Estado(String estado)
        {
            simbolo = estado;
        }
    }

    class Nodo
    {
        public Nodo sig;
    }


    class DefVar : Nodo
    {
        public String tipo;
        public String id;
        public Nodo listaVar;

        public DefVar(Pila p)
        {
            p.pop();
            p.pop();
            p.pop();
            listaVar = ((NoTerminal)p.pop()).nodo;
            p.pop();
            id = ((Terminal)p.pop()).simbolo;
            p.pop();
            tipo = ((Terminal)p.pop()).simbolo;
        }
        public void muestra(List<String> s)
        {
            s.Add("Tipo: " + tipo + " ID: " + id);
        }
    }

    class DefFunc : Nodo
    {
        public List<Parametros> param;
        public String id;
        public String tipo;
        public BloqFunc bloqFunc;

        public DefFunc(Pila p, List<Parametros> l, BloqFunc f)
        {
            bloqFunc = f;
            if (l == null)
            {
                p.pop();
                p.pop();
                p.pop();
                p.pop();
                p.pop();
                p.pop(); //Parametros
                p.pop();
                p.pop();
                p.pop();
                id = ((Terminal)p.pop()).simbolo;
                p.pop();
                tipo = ((Terminal)p.pop()).simbolo;
            }
            else
            {
                param = new List<Parametros>();
                for (int i = 0; i < l.Count; i++)
                {
                    param.Add(l[i]);
                }
                p.pop();
                p.pop();
                p.pop();
                p.pop();
                p.pop();
                p.pop(); //Parametros
                p.pop();
                p.pop();
                p.pop();
                id = ((Terminal)p.pop()).simbolo;
                p.pop();
                tipo = ((Terminal)p.pop()).simbolo;
            }
        }

        public void muestra(List<String> s)
        {
            s.Add("Tipo: " + tipo + " ID: " + id);
            if (param != null)
            {
                s.Add("Parámetros");
                for (int i = 0; i < param.Count; i++)
                {
                    param[i].muestra(s);
                }
                s.Add("BloqFunc");
                bloqFunc.muestra(s);
            }
            else
            {
                s.Add("BloqFunc");
                bloqFunc.muestra(s);
            }
        }
    }

    class Parametros : Nodo
    {
        public String id;
        public String tipo;

        public Parametros(Pila p)
        {
            p.pop(); //estado
            id = ((Terminal)p.pop()).simbolo;
            p.pop(); // estado
            tipo = ((Terminal)p.pop()).simbolo;
        }

        public void muestra(List<String> s)
        {
            s.Add("Tipo: " + tipo + " ID: " + id);
        }
    }

    class DefLocal : Nodo
    {
        public Sentencia sent;
        public DefVar variables;
        public List<DefLocal> dlocal;

        public DefLocal(Pila p, Sentencia s)
        {
            p.pop();
            p.pop();

            sent = s;
        }
        public DefLocal(Pila p, DefVar v)
        {
            p.pop();
            p.pop();

            variables = v;
        }

        public void muestra(List<String> s)
        {
            if (sent != null)
            {
                s.Add("Sentencia");
                sent.muestra(s);
            }
            else
            {
                s.Add("Variable");
                variables.muestra(s);
            }
        }
    }

    class DefLocales : Nodo
    {
        List<DefLocal> dlocal;

        public DefLocales(Pila p, List<DefLocal> d)
        {
            p.pop();
            p.pop();
            p.pop();
            p.pop();

            dlocal = new List<DefLocal>();
            for (int i = 0; i < d.Count; i++)
            {
                dlocal.Add(d[i]);
            }
        }

        public void muestra(List<String> s)
        {
            for (int i = 0; i < dlocal.Count; i++)
            {
                s.Add("DefLocal");
                dlocal[i].muestra(s);
            }
        }
    }


    class BloqFunc : Nodo
    {
        DefLocales dlocales;

        public BloqFunc(Pila p, DefLocales d)
        {
            p.pop();
            p.pop();
            p.pop();
            p.pop();
            p.pop();
            p.pop();

            dlocales = d;
        }

        public void muestra(List<String> s)
        {
            dlocales.muestra(s);
        }
    }


    class Argumentos : Nodo
    {
        public List<Expresion> exp;

        public Argumentos(List<Expresion> e)
        {
            exp = e;
        }
    }

    class LlamadaFunc : Nodo
    {
        public String id;
        public Argumentos args;

        public LlamadaFunc(Pila p, Argumentos a)
        {
            p.pop();
            p.pop();
            p.pop();
            p.pop();
            p.pop();
            p.pop();
            p.pop();
            id = ((Terminal)p.pop()).simbolo;
            args = a;
        }

        public bool comparar(List<DefFunc> d)
        {
            String[] tipo = new String[10];
            String termino;
            if (d.Count == 0)
            {
                return false;
            }
            else
            {
                for (int i = 0; i < d.Count; i++)
                {
                    if (id == d[i].id)
                    {
                        for (int j = 0; j < d[i].param.Count; j++)
                        {
                            tipo[j] = d[i].param[j].tipo;
                            if (tipo[j] == "int")
                            {
                                termino = args.exp[j].termino.id;
                                for (int k = 0; k < termino.Length; k++)
                                {
                                    if (termino[k] == '.')
                                    {
                                        return false;
                                     }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
            return false;
        }

        public void muestra(List<String> s)
        {
            s.Add("LlamadaFunc");
            s.Add("ID: " + id);
            s.Add("Argumentos");
            for (int i = 0; i < args.exp.Count; i++)
            {
                s.Add("Expresión");
                args.exp[i].termino.muestra(s);
            }
        }
    }

    class Definicion : Nodo
    {
        public DefFunc funciones;
        public DefVar variables;

        public Definicion(Pila p, DefFunc f)
        {
            p.pop();
            p.pop();

            funciones = f;
        }

        public Definicion(Pila p, DefVar v)
        {
            p.pop();
            p.pop();

            variables = v;
        }

        public void muestra(List<String> s)
        {
            if (funciones != null)
            {
                s.Add("DefFunc");
                funciones.muestra(s);
            }
            else
            {
                variables.muestra(s);
            }
        }
    }

    class Definiciones : Nodo
    {
        public Definicion definicion;

        public Definiciones(Pila p, Definicion d)
        {
            p.pop();
            p.pop();
            p.pop();
            p.pop();

            definicion = d;
        }

        public void muestra(List<String> s)
        {
            s.Add("Definición");
            definicion.muestra(s);
        }
    }

    class Programa : Nodo
    {
        public List<Definiciones> def;

        public Programa(Pila p, List<Definiciones> d)
        {
            p.pop();
            p.pop();

            def = new List<Definiciones>();
            for (int i = 0; i < d.Count; i++)
            {
                def.Add(d[i]);
            }
        }

        public void muestra(List<String> s)
        {
            s.Add("Programa");
            for (int i = 0; i < def.Count; i++)
            {
                s.Add("Definiciones");
                def[i].muestra(s);
            }
        }
    }

    class Termino : Nodo
    {
        public String id;
        public LlamadaFunc llamada;

        public Termino(Pila p)
        {
            p.pop(); //estado
            id = ((Terminal)p.pop()).simbolo;
        }

        public Termino(Pila p, LlamadaFunc ll)
        {
            p.pop();
            p.pop();

            llamada = ll;
        }

        public void muestra(List<String> s)
        {
            if(llamada != null)
            {
                llamada.muestra(s);
            }
            else
            {
                s.Add("ID: " + id);
            }
        }

    }

    class Sentencia : Nodo
    {
        public Expresion exp;
        public String id;

        public Sentencia(Pila p, Expresion l)
        {
            exp = l;

            p.pop();
            id = ((Terminal)p.pop()).simbolo;
        }


        public bool validar(List<DefVar> v)
        {
            String[] ids = new string[exp.exp.Count];
            for (int j = 0; j < exp.exp.Count; j++)
            {
                ids[j] = exp.exp[j].termino.id;
            }

            for (int i = 0; i < v.Count; i++)
            {
                if (id == v[i].id)
                {
                    for (int j = 0; j < ids.Length; j++)
                    {
                        for (int k = 0; k < v.Count; k++)
                        {
                            if (ids[j] == v[k].id)
                            {
                                if (v[i].tipo != v[j].tipo)
                                {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }


        public void muestra(List<String> s)
        {
            //exp.termino.muestra();
            //exp[1].termino.muestra();
            if (exp.exp != null)
            {
                s.Add("Expresión");
                for (int i = 0; i < exp.exp.Count; i++)
                {
                    s.Add("Término");
                    exp.exp[i].termino.muestra(s);
                }
            }
            else
            {
                s.Add("Expresión");
                s.Add("Término");
                exp.termino.muestra(s);
            }
        }
    }

    class Expresion : Nodo
    {
        public List<Termino> term;
        public List<Expresion> exp;
        public Nodo expresion;
        public Termino termino;

        public Expresion(Pila p, Termino t)
        {
            p.pop();
            expresion = ((NoTerminal)p.pop()).nodo;
            termino = t;
        }

        public Expresion(Pila p, List<Expresion> l)
        {
            p.pop();
            expresion = ((NoTerminal)p.pop()).nodo;

            p.pop();
            p.pop();

            p.pop();
            expresion = ((NoTerminal)p.pop()).nodo;

            exp = new List<Expresion>();
            for (int i = 0; i < l.Count; i++)
            {
                exp.Add(l[i]);
            }
        }

        public void validar()
        {

        }
    }

    class Pila
    {
        public LinkedList<ElementoPila> listaPila = new LinkedList<ElementoPila>();

        public Pila()
        {

        }

        public void push(ElementoPila x)
        {
            listaPila.AddLast(x);
        }

        public ElementoPila top()
        {
            return listaPila.Last.Value;
        }

        public ElementoPila pop()
        {
            ElementoPila x = listaPila.Last.Value;
            listaPila.Remove(x);

            return x;
        }

        public void vaciarPila()
        {
            listaPila.Clear();
        }

        public void mostrarPila()
        {
            foreach (ElementoPila dato in listaPila)
            {
                Console.Write(dato.simbolo);
            }
            Console.WriteLine("\n");
        }
    }
}
