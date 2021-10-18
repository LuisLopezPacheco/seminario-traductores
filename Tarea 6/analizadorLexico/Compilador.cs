using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace analizadorLexico
{

    class Compilador
    {
        //Símbolos
        public const int ERROR = -1;
        public const int INICIAL = 55;
        public const int IDENTIFICADOR = 0;
        public const int ENTERO = 1;
        public const int REAL = 2;
        public const int CADENA = 3;
        public const int TIPO =  4;
        public const int OPSUMA = 5;
        public const int OPMUL = 6;
        public const int OPRELAC = 7;
        public const int OPOR = 8;
        public const int OPAND = 9;
        public const int OPNOT = 10;
        public const int OPIGUALDAD = 11;
        public const int PUNTOCOMA = 12;
        public const int COMA = 13;
        public const int ABREPARENTESIS = 14;
        public const int CIERRAPARENTESIS = 15;
        public const int ABRELLAVE = 16;
        public const int CIERRALLAVE = 17;
        public const int IGUAL = 18;
        public const int IF = 19;
        public const int WHILE = 20;
        public const int RETURN = 21;
        public const int ELSE = 22;
        public const int SIGNOPESOS = 23;

        public String[] tipoDatos = new String[] { "int", "float", "void" };
        public String[] reservadas = new String[] { "if", "while", "return", "else" };


        List<String> listaErrores;
        List<String> listaTokens;
        List<String> listaErroresSemanticos;
        List<String> listaEntrada;
        List<String> listaSintactico;
        List<String> salidaSintactico;
        List<Reglas> listaReglas;
        List<DefVar> listaVariables;
        List<Parametros> listaParam;
        List<Termino> listaTerminos;
        List<Expresion> listaExpresiones;
        List<Expresion> listaExpresion;
        List<Sentencia> listaSentencias;
        List<DefLocal> listaDefLocal;
        List<DefLocales> listaDefLocales;
        List<BloqFunc> bloqFuncs;
        List<DefFunc> listaFunciones;
        List<Definicion> listaDefinicion;
        List<Definiciones> listaDefiniciones;
        List<Expresion> listaArgumentos;
        List<LlamadaFunc> listaLlamadaFunc;
        List<String> arbolSint;

        Pila pila;
        int[,] matriz = new int[96, 46];

        int cont;

        public Compilador()
        {
            listaErrores = new List<String>();
            listaTokens = new List<String>();
            listaEntrada = new List<String>();
            listaSintactico = new List<String>();
            salidaSintactico = new List<String>();
            listaReglas = new List<Reglas>();
            listaVariables = new List<DefVar>();
            listaParam = new List<Parametros>();
            listaTerminos = new List<Termino>();
            listaExpresiones = new List<Expresion>();
            listaExpresion = new List<Expresion>();
            listaSentencias = new List<Sentencia>();
            listaDefLocal = new List<DefLocal>();
            listaDefLocales = new List<DefLocales>();
            bloqFuncs = new List<BloqFunc>();
            listaFunciones = new List<DefFunc>();
            listaErroresSemanticos = new List<string>();
            listaDefinicion = new List<Definicion>();
            listaDefiniciones = new List<Definiciones>();
            listaArgumentos = new List<Expresion>();
            listaLlamadaFunc = new List<LlamadaFunc>();
            arbolSint = new List<string>();

            pila = new Pila();
            cargarMatriz();
            cargarReglas();
            cont = 0;
        }

        public void cargarMatriz()
        {
            int delimitador = 9;
            char _dem = Convert.ToChar(delimitador);
            String[] lineas = File.ReadAllLines(@"D:\Practicas\Cosas de C#\Actividades STL II\Analizador Semantico\Tarea 6\analizadorLexico\compilador.lr", Encoding.Default);
            for (int i = 0; i < lineas.Count(); i++)
            {
                for (int j = 0; j < 46; j++)
                {
                    matriz[i, j] = Convert.ToInt32(lineas[i].Split(_dem)[j]);
                }
            }
        }

        public void cargarReglas()
        {
            int delimitador = 9;
            char _dem = Convert.ToChar(delimitador);
            string[] lineas = File.ReadAllLines(@"D:\Practicas\Cosas de C#\Actividades STL II\Analizador Semantico\Tarea 6\analizadorLexico\reglas.txt", Encoding.Default);
            foreach (string linea in lineas)
            {
                string[] partes = linea.Split(_dem);
                listaReglas.Add(new Reglas(Convert.ToInt32(partes[0]), Convert.ToInt32(partes[1]), partes[2]));
            }
        }

        public void agregaToken(String lexema, int tipo)
        {
            //Añade nuevo token
            String nuevoToken;
            switch (tipo)
            {
                case IDENTIFICADOR:
                    nuevoToken = lexema + " es un identificador" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case ENTERO:
                    nuevoToken = lexema + " es un entero" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case REAL:
                    nuevoToken = lexema + " es un número real" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case CADENA:
                    nuevoToken = lexema + " es una cadena" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case TIPO:
                    nuevoToken = lexema + " es un tipo de dato" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case OPSUMA:
                    if (lexema == "+")
                    {
                        nuevoToken = lexema + " es un operador de suma" + "\n";
                        listaTokens.Add(nuevoToken);
                    }
                    else if (lexema == "-")
                    {
                        nuevoToken = lexema + " es un operador de resta" + "\n";
                        listaTokens.Add(nuevoToken);
                    }
                    break;
                case OPMUL:
                    if (lexema == "*")
                    {
                        nuevoToken = lexema + " es un operador de multiplicación" + "\n";
                        listaTokens.Add(nuevoToken);
                    }
                    else if (lexema == "/")
                    {
                        nuevoToken = lexema + " es un operador de división" + "\n";
                        listaTokens.Add(nuevoToken);
                    }
                    break;
                case OPRELAC:
                    nuevoToken = lexema + " es un operador relacional" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case OPOR:
                    nuevoToken = lexema + " es un operador " + "OR" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case OPAND:
                    nuevoToken = lexema + " es un operador AND" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case OPNOT:
                    nuevoToken = lexema + " es un operador de negación" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case OPIGUALDAD:
                    nuevoToken = lexema + " es un operador de igualdad" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case PUNTOCOMA:
                    nuevoToken = lexema + " es un punto y coma (;)" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case COMA:
                    nuevoToken = lexema + " es una coma (,)" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case ABREPARENTESIS:
                    nuevoToken = lexema + " abre paréntesis" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case CIERRAPARENTESIS:
                    nuevoToken = lexema + " cierra paréntesis" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case ABRELLAVE:
                    nuevoToken = lexema + " abre llave" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case CIERRALLAVE:
                    nuevoToken = lexema + " cierra llave" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case IGUAL:
                    nuevoToken = lexema + " es un operador de igual (=)" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case IF:
                case WHILE:
                case RETURN:
                case ELSE:
                    nuevoToken = lexema + " es una palabra reservada" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                case SIGNOPESOS:
                    nuevoToken = lexema + " es el signo $" + "\n";
                    listaTokens.Add(nuevoToken);
                    break;
                default:
                    break;
            }
        }

        public void agregaError(String lexema)
        {
            //Añade un error
            String nuevoError;
            nuevoError = lexema + " es un carácter no admitido" + "\n";
            listaErrores.Add(nuevoError);
        }

        public void agregarErrorSemantico(String cad, String simb)
        {
            String nuevoError;
            switch (cad)
            {
                case "R21":
                    nuevoError = "Error en la asignación: '" + simb + "'. Tipos de datos diferentes";
                    listaErroresSemanticos.Add(nuevoError);
                    break;
                case "R24":
                    nuevoError = "Error en el retorno del valor, tipos de datos diferentes o mal definidos";
                    listaErroresSemanticos.Add(nuevoError);
                    break;
                case "R40":
                    nuevoError = "Error en la llamada a la función: '" + simb + "'. La función no existe o tiene parámetros con tipos de datos diferentes";
                    listaErroresSemanticos.Add(nuevoError);
                    break;
                default:
                    break;
            }
        }

        public void Analizador(String texto) //Analizador Léxico
        {
            int estado = 0; //Identifica el estado actual del analizador
            String lexema = "";
            Char c;
            bool hayPunto = false; //Bandera para verificar si la expresión es un número y si tiene un punto
            texto = texto + "$";
            pila.push(new NoTerminal("$"));
            pila.push(new Estado("0"));
            listaSintactico.Add(dameListaPila());

            //Inicia el automata del analizador
            for (int i = 0; i < texto.Length; i++)
            {
                c = texto[i];
                switch (estado)
                {
                    case INICIAL:
                        if (Char.IsLetter(c) || c == '_')
                        { //Verifica si es letra o empieza con un "_"
                            estado = IDENTIFICADOR;
                            lexema += c;
                        }
                        else if (Char.IsDigit(c))
                        { //Verifica si es digito
                            estado = ENTERO;
                            lexema += c;
                        }
                        else if (c == '"')
                        {
                            estado = CADENA;
                            lexema += c;
                        } 
                        else if(c == '+' || c == '-')
                        {
                            lexema += c;

                            agregaToken(lexema, OPSUMA);
                            AnalizadorSintactico(OPSUMA, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else if (c == '*' || c == '/')
                        {
                            lexema += c;

                            agregaToken(lexema, OPMUL);
                            AnalizadorSintactico(OPMUL, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else if (c == '<' || c == '>')
                        {
                            estado = OPRELAC;
                            lexema += c;
                        }
                        else if (c == '|')
                        {
                            estado = OPOR;
                            lexema += c;
                        }
                        else if (c == '&')
                        {
                            estado = OPAND;
                            lexema += c;
                        }
                        else if (c == '='|| c == '!')
                        {
                            if (texto[i + 1] != '=')
                            {
                                if (c == '=')
                                {
                                    lexema += c;

                                    agregaToken(lexema, IGUAL);
                                    AnalizadorSintactico(IGUAL, lexema);
                                    lexema = "";
                                    estado = INICIAL;
                                }
                                else if (c == '!')
                                {
                                    lexema += c;

                                    agregaToken(lexema, OPNOT);
                                    AnalizadorSintactico(OPNOT, lexema);
                                    estado = INICIAL;
                                    lexema = "";
                                }
                            }
                            else
                            {
                                estado = OPIGUALDAD;
                                lexema += c;
                            }
                        }
                        else if (c == ';')
                        {
                            lexema += c;

                            agregaToken(lexema, PUNTOCOMA);
                            AnalizadorSintactico(PUNTOCOMA, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else if (c == ',')
                        {
                            lexema += c;

                            agregaToken(lexema, COMA);
                            AnalizadorSintactico(COMA, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else if (c == '(')
                        {
                            lexema += c;

                            agregaToken(lexema, ABREPARENTESIS);
                            AnalizadorSintactico(ABREPARENTESIS, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else if (c == ')')
                        {
                            lexema += c;

                            agregaToken(lexema, CIERRAPARENTESIS);
                            AnalizadorSintactico(CIERRAPARENTESIS, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else if (c == '{')
                        {
                            lexema += c;

                            agregaToken(lexema, ABRELLAVE);
                            AnalizadorSintactico(ABRELLAVE, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else if (c == '}')
                        {
                            lexema += c;

                            agregaToken(lexema, CIERRALLAVE);
                            AnalizadorSintactico(CIERRALLAVE, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else if (c == '$')
                        {
                            lexema += c;

                            agregaToken(lexema, SIGNOPESOS);
                            AnalizadorSintactico(SIGNOPESOS, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        break;
                    case IDENTIFICADOR:
                        if (Char.IsLetterOrDigit(c) || c == '_')
                        {
                            estado = IDENTIFICADOR;
                            lexema += c;
                        }
                        else
                        {
                            if (esTipoDato(lexema))
                            {
                                agregaToken(lexema, TIPO);
                                AnalizadorSintactico(TIPO, lexema);
                                estado = INICIAL;
                                lexema = "";
                            }
                            else if (esReservada(lexema))
                            {
                                agregaToken(lexema, tipoReservada(lexema));
                                AnalizadorSintactico(tipoReservada(lexema), lexema);
                                estado = INICIAL;
                                lexema = "";
                            }
                            else
                            {
                                agregaToken(lexema, IDENTIFICADOR);
                                AnalizadorSintactico(IDENTIFICADOR, lexema);
                                estado = INICIAL;
                                lexema = "";
                                i--;
                            }
                        }
                        break;
                    case ENTERO:
                        if (Char.IsDigit(c))
                        {
                            estado = ENTERO;
                            lexema += c;
                        }
                        else if (c == '.')
                        {
                            if (hayPunto == false)
                            {
                                estado = REAL;
                                lexema += c;
                                hayPunto = true;

                            }
                            else
                            {
                                lexema += c;
                                agregaError(lexema);

                                estado = INICIAL;
                                lexema = "";
                            }
                        }
                        else
                        {
                            agregaToken(lexema, ENTERO);
                            AnalizadorSintactico(ENTERO, lexema);
                            estado = INICIAL;
                            lexema = "";
                            i--;
                        }
                        break;
                    case REAL:
                        if (Char.IsDigit(c))
                        {
                            estado = REAL;
                            lexema += c;
                        }
                        else if (c == '.')
                        {
                            if (hayPunto)
                            {
                                lexema += c;
                                agregaError(lexema);

                                estado = INICIAL;
                                lexema = "";
                            }
                        }
                        else
                        {
                            agregaToken(lexema, REAL);
                            AnalizadorSintactico(REAL, lexema);
                            estado = INICIAL;
                            lexema = "";
                            hayPunto = false;
                            i--;
                        }
                        break;
                    case CADENA:
                        if (c == '"')
                        {
                            lexema += c;
                            agregaToken(lexema, CADENA);
                            AnalizadorSintactico(CADENA, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else {
                            estado = CADENA;
                            lexema += c;
                        }
                        break;
                    case OPRELAC:
                        if (c == '=')
                        {
                            lexema += c;

                            agregaToken(lexema, OPRELAC);
                            AnalizadorSintactico(OPRELAC, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else
                        {
                            agregaToken(lexema, OPRELAC);
                            AnalizadorSintactico(OPRELAC, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        break;
                    case OPOR:
                        if(c == '|')
                        {
                            lexema += c;

                            agregaToken(lexema, OPOR);
                            AnalizadorSintactico(OPOR, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else
                        {
                            agregaToken(lexema, OPOR);
                            AnalizadorSintactico(OPOR, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        break;
                    case OPAND:
                        if (c == '&')
                        {
                            lexema += c;

                            agregaToken(lexema, OPAND);
                            AnalizadorSintactico(OPAND, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        else
                        {
                            agregaToken(lexema, OPAND);
                            AnalizadorSintactico(OPAND, lexema);
                            estado = INICIAL;
                            lexema = "";
                        }
                        break;
                    case OPIGUALDAD:
                        lexema += c;

                        agregaToken(lexema, OPIGUALDAD);
                        AnalizadorSintactico(OPIGUALDAD, lexema);
                        estado = INICIAL;
                        lexema = "";
                        break;
                    default:
                        break;
                }
            }
            //Termina el automata
        }

        public void AnalizadorSintactico(int estado, String simb) //Analizador sintáctico
        {
            String regla;
            if (matriz[cont, estado] == -1)
            {
                salidaSintactico.Add("R" + 0);
                listaEntrada.Add(simb);
                return;
            }
            else if (matriz[cont, estado] > 0)
            {
                cont = matriz[cont, estado];
                pila.push(new Terminal(simb));
                pila.push(new Estado(cont.ToString()));
                listaSintactico.Add(dameListaPila());
                salidaSintactico.Add("D" + cont);
                listaEntrada.Add(simb);
            }
            else if (matriz[cont, estado] < -1)
            {
                int i = (matriz[cont, estado] * -1) - 2;
                if (listaReglas[i].num_va == 0)
                {
                    int num_regla = listaReglas[i].num;
                    cont = matriz[cont, num_regla];
                    pila.push(new NoTerminal(listaReglas[i].nombre));
                    pila.push(new Estado(cont.ToString()));
                    listaSintactico.Add(dameListaPila());
                    salidaSintactico.Add("R" + (i + 1));
                    listaEntrada.Add(simb);
                    AnalizadorSintactico(estado, simb);
                }
                else
                {
                    int num_regla = listaReglas[i].num;
                    arbolSintactico("R" + (i + 1), simb);
                    cont = matriz[Convert.ToInt32(((Estado)pila.top()).simbolo), num_regla];
                    pila.push(new NoTerminal(listaReglas[i].nombre));
                    pila.push(new Estado(cont.ToString()));
                    listaSintactico.Add(dameListaPila());
                    salidaSintactico.Add("R" + (i + 1));
                    listaEntrada.Add(simb);
                    AnalizadorSintactico(estado, simb);
                }
            }
        }

        public void arbolSintactico(String regla, String simb)
        {
            Termino nuevoTermino;
            switch (regla)
            {
                case "R1":
                    Programa prog = new Programa(pila, listaDefiniciones);
                    prog.muestra(arbolSint);
                    break;
                case "R30":
                    pila.pop();
                    pila.pop();
                    break;
                case "R3":
                    Definiciones nuevaDef = new Definiciones(pila, listaDefinicion.Last<Definicion>());
                    listaDefiniciones.Add(nuevaDef);
                    Definicion auxDef = listaDefinicion.Last<Definicion>();
                    listaDefinicion.Remove(auxDef);
                    break;
                case "R4":
                    Definicion defVariable = new Definicion(pila, listaVariables.Last<DefVar>());
                    listaDefinicion.Add(defVariable);
                    break;
                case "R5":
                    Definicion def = new Definicion(pila, listaFunciones.Last<DefFunc>());
                    listaDefinicion.Add(def);
                    break;
                case "R6":
                    DefVar arbol = new DefVar(pila);
                    listaVariables.Add(arbol);
                    break;
                case "R9":
                    DefFunc nuevaFuncion = new DefFunc(pila, listaParam, bloqFuncs.Last<BloqFunc>());
                    listaFunciones.Add(nuevaFuncion);
                    listaParam = new List<Parametros>();
                    listaExpresion = new List<Expresion>();
                    listaExpresiones = new List<Expresion>();
                    listaDefLocal = new List<DefLocal>();
                    listaDefLocales = new List<DefLocales>();
                    break;
                case "R10":
                    listaParam.Add(null);
                    break;
                case "R11":
                    pila.pop();
                    pila.pop();
                    Parametros nuevoParametro = new Parametros(pila);
                    listaParam.Add(nuevoParametro);
                    break;
                case "R12":
                    break;
                case "R13":
                    pila.pop();
                    pila.pop();
                    Parametros nuevoParametros = new Parametros(pila);
                    listaParam.Add(nuevoParametros);
                    pila.pop();
                    pila.pop();
                    break;
                case "R14":
                    BloqFunc bFunc = new BloqFunc(pila, listaDefLocales.Last<DefLocales>());
                    bloqFuncs.Add(bFunc);
                    break;
                case "R16":
                    DefLocales locales = new DefLocales(pila, listaDefLocal);
                    listaDefLocales.Add(locales);
                    break;
                case "R17":
                    DefLocal nuevaVar = new DefLocal(pila, listaVariables.Last<DefVar>());
                    listaDefLocal.Add(nuevaVar);
                    break;
                case "R18":
                    DefLocal defSentencia = new DefLocal(pila, listaSentencias.Last<Sentencia>());
                    listaDefLocal.Add(defSentencia);
                    break;
                case "R20":
                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();
                    break;
                case "R21":
                    Expresion aux;
                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();
                    if (listaExpresion.Count > 0)
                    {
                        Sentencia nuevaSentencia = new Sentencia(pila, listaExpresion.Last<Expresion>());
                        listaSentencias.Add(nuevaSentencia);
                        if (nuevaSentencia.validar(listaVariables) == false)
                        {
                            agregarErrorSemantico("R21", nuevaSentencia.id);
                        }
                        aux = listaExpresion.Last<Expresion>();
                        listaExpresion.Remove(aux);
                    }
                    else
                    {
                        Sentencia nuevaSentencia = new Sentencia(pila, listaExpresiones.Last<Expresion>());
                        listaSentencias.Add(nuevaSentencia);
                    }
                    break;
                case "R23":
                    for (int i = 0; i < 10; i++)
                    {
                        pila.pop();
                    }
                    break;
                case "R24":
                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();
                    Sentencia sentReturn = new Sentencia(pila, listaExpresion.Last<Expresion>());
                    listaSentencias.Add(sentReturn);
                    aux = listaExpresion.Last<Expresion>();
                    listaExpresion.Remove(aux);
                    break;
                case "R28":
                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();
                    break;
                case "R32":
                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();

                    listaArgumentos.Add(listaExpresiones[listaExpresiones.Count - 2]);
                    break;
                case "R34":
                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();

                    listaArgumentos.Add(listaExpresiones.Last<Expresion>());
                    break;
                case "R35":
                    Termino nuevoTermFunc = new Termino(pila, listaLlamadaFunc.Last<LlamadaFunc>());
                    listaTerminos.Add(nuevoTermFunc);
                    break;
                case "R36":
                case "R37":
                case "R38":
                    nuevoTermino = new Termino(pila);
                    listaTerminos.Add(nuevoTermino);
                    break;
                case "R40":
                    Argumentos args = new Argumentos(listaArgumentos);
                    LlamadaFunc llamadaFunc = new LlamadaFunc(pila, args);
                    if (llamadaFunc.comparar(listaFunciones) == false)
                    {
                        agregarErrorSemantico("R40", llamadaFunc.id);
                    }
                    listaLlamadaFunc.Add(llamadaFunc);
                    break;
                case "R47":
                    
                    Expresion nuevaExpresion = new Expresion(pila, listaExpresiones);
                    listaExpresion.Add(nuevaExpresion);
                    break;
                case "R48":
                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();

                    pila.pop();
                    pila.pop();
                    break;
                case "R52":
                    Expresion nuevaExp = new Expresion(pila, listaTerminos.Last<Termino>());
                    listaExpresiones.Add(nuevaExp);
                    break;
                default:
                    break;
            }
        }

        public Boolean esTipoDato(String lexema)
        {
            for (int i = 0; i < tipoDatos.Length; i++)
            {
                if (tipoDatos[i].Equals(lexema))
                {
                    return true;
                }
            }
            return false;
        }


        public Boolean esReservada(String lexema)
        {
            for (int i = 0; i < reservadas.Length; i++)
            {
                if (reservadas[i].Equals(lexema))
                {
                    return true;
                }
            }
            return false;
        }

        public int tipoReservada(String lexema)
        {
            switch (lexema)
            {
                case "if":
                    return IF;
                case "while":
                    return WHILE;
                case "return":
                    return RETURN;
                case "else":
                    return ELSE;
                default:
                    return ERROR;
            }
        }

        public String dameListaToken()
        {
            String lista = String.Join(Environment.NewLine, listaTokens.ToArray());
            return lista;

        }

        public String dameListaErrores()
        {
            String lista = String.Join(Environment.NewLine, listaErrores.ToArray());
            return lista;
        }

        public String dameListaErroresSemanticos()
        {
            String lista = String.Join(Environment.NewLine, listaErroresSemanticos.ToArray());
            return lista;
        }

        public String dameListaPila()
        {
            String s = "";
            foreach (ElementoPila dato in pila.listaPila)
            {
                s = s + dato.simbolo;
            }
            s = s + "\n";
            return s;
        }

        public List<String> dameListaSintactico()
        {
            return listaSintactico;
        }

        public List<String> dameSalida()
        {
            return salidaSintactico;
        }
        
        public List<String> dameEntrada()
        {
            return listaEntrada;
        }
        
        public String muestraArbol()
        {
            String lista = String.Join(Environment.NewLine, arbolSint.ToArray());
            return lista;
        }
    }
}
