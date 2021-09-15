
using System;
using System.IO;
using System.Collections;
using System.Collections.Generic;

namespace Analizador_lexico {

	public class analizadorSintactico {
		LinkedList<Token> listToken;//lista de tokens de entrada
		StreamReader reglas = new StreamReader(@"file\\GR2slrRulesId.txt");
		StreamReader Tabla  = new StreamReader(@"file\\GR2slrTable.txt");
		int[,] _reglas = new int[54, 2];
		int[,] _tabla  = new int[95,48];
		Stack arbol = new Stack();
		
		public analizadorSintactico(LinkedList<Token> tokens) {
			//recive una lista de tokens
			listToken = new LinkedList<Token>(tokens);
			matriz();//genera las matrices (son 2)
			
		}
		
		public bool analizar() {
			Stack<int> pila = new Stack<int>();
			int accion=0, regla, reduccion, fila, columna, i =0;
			bool valido = false;
			Nodo aux;
			NoTerminal nt;
			//agregamos el cero a la pila
			pila.Push(0);
			arbol.Push(0);
			var token = listToken.First;//creo un nodo Token
			listToken.AddLast(new Token());
			do {
				
				
				fila = pila.Peek();
				columna = token.Value.getId()+1;
				
				accion = _tabla[fila, columna];
				
			
				
				if(accion > 0) {
					//desplazamiento
					pila.Push(columna);
					pila.Push(accion);
					
					aux = new Nodo("ambito", token.Value.getToken());
					nt = new NoTerminal();
					nt.nodo = aux;
					
					arbol.Push( new NoTerminal(nt));
					arbol.Push(accion);
					
					//nos vamos al sig token
					token = token.Next;
				} else if(accion < -1) {
					//ir a la regla
					
					regla = accion*(-1)-1;
					reduccion = _reglas[regla, 1]*2;//pops
					
					aux = creacionArbol(arbol, regla);
					
					for(; 0 < reduccion; reduccion--) {
						pila.Pop();//hacer pop
					}
					//agregar al tope de la pila
					fila = pila.Peek();
					columna = _reglas[regla, 0]+1;
					pila.Push(columna);
					pila.Push(_tabla[fila, columna]);
					
					nt = new NoTerminal(columna);
					nt.nodo = aux;
					
					arbol.Push(new NoTerminal(nt));
					arbol.Push(_tabla[fila, columna]);
					
				}else  if(accion == -1) {
					valido = true;
					token = token.Next;
				} else {
					//error
					return false;
				}
				i++;
			} while(token != listToken.Last);
			
			String s2 ="";
			arbol.Pop();
			nt = ((NoTerminal)arbol.Peek());
			while(nt.nodo != null) {
				s2 += nt.simbolo + "|\n";
				s2 += nt.nodo.simbolo + "_\n";
				nt.nodo = nt.nodo.siguiente;
			}
			return valido;
		}
		
		Nodo creacionArbol(Stack pila, int regla) {
			Nodo nodo = new Nodo();
			Nodo aux  = new Nodo();
			
			switch(regla) {
				case 0: //Programa -> Definiciones
					nodo = new Programa(pila);
					break;
					
				case 3: //Definicion -> DefVar
				case 4: //Definicion -> DefFunc
				case 16://DefLocal -> DefVar
				case 17://DefLocal -> Sentencia
				case 32://Expresion -> LlamadaFunc
				case 33://Expresion -> id
				case 34://Expresion -> constante
				case 36://SentenciaBloque -> Sentencia
				case 37://SentenciaBloque -> Bloque
					pila.Pop();
					nodo = ((NoTerminal)pila.Pop()).nodo;
					break;
					
				case 1: //Definiciones -> ''
				case 6: //ListaVar -> ''
				case 9: //Parametros -> ''
				case 11://ListaParam -> ''
				case 14://DefLocales -> ''
				case 18://Sentencias -> ''
				case 25://Otro -> ''
				case 28://Argumentos -> ''
				case 30://ListaArgumentos -> ''
					//for(int i = 0; i < regla; i++) {
						//pila.Pop();
					//}
					break;
				
				case 2: //Definiciones -> Definicion Definiciones
				case 15://DefLocales -> DefLocal DefLocales
				case 19://Sentencias ->Sentencia Sentencias
				case 29://Argumentos -> Expresion ListaArgumentos
					pila.Pop();					
					aux = ((NoTerminal)pila.Pop()).nodo;
					pila.Pop();
					nodo = ((NoTerminal)pila.Pop()).nodo;
					nodo.siguiente = aux;
					break;
				
				case 5: //DefVar -> tipo id ListaVar ;
					nodo = new DefVar(pila);
					break;
					
				case 7: //ListaVar -> , id ListaVar
					pila.Pop();
					aux = (NoTerminal)pila.Pop();
					pila.Pop();
					nodo = (((Nodo)pila.Pop()));
					pila.Pop();
					pila.Pop();//,
					nodo.siguiente = aux;
					break;
				
				case 8: //DefFunc -> tipo id ( Parametros ) BloqFunc
					nodo = new DefFunc(pila);
					break;
				
				case 10://Parametros -> tipo id ListaParam
					nodo = new Parametros(pila);
					break;
				
				case 12://ListaParam -> , tipo id ListaParam
					nodo = new Parametros(pila);
					pila.Pop();
					pila.Pop();//,
					break;
					
				case 13://BloqFunc -> { DefLocales }
				case 27://Bloque -> { Sentencias }
				case 38://Expresion -> ( Expresion )
					pila.Pop();
					pila.Pop();//)
					pila.Pop();						
					nodo = ((NoTerminal)pila.Pop()).nodo;
					pila.Pop();
					pila.Pop();//)
					break;
					
				case 20://Sentencia -> id = Expresion ;
					nodo = new Asignacion(pila);
					break;
				
				case 21://Sentencia -> if ( Expresion ) SentenciaBloque Otro
					nodo = new If(pila);
					break;
					
				case 22://Sentencia ->while ( Expresion ) Bloque
					nodo = new While(pila);
					break;
				
				case 23://Sentencia -> return Expresion ;
					nodo = new Return(pila);
					break;
				
				case 24://Sentencia -> LlamadaFunc ;
					pila.Pop();
					pila.Pop();//;
					pila.Pop();	
					nodo = ((NoTerminal)pila.Pop()).nodo;
					break;
					
				case 26://Otro -> else SentenciaBloque
					pila.Pop();	
					nodo = ((NoTerminal)pila.Pop()).nodo;
					pila.Pop();
					pila.Pop();//else
					break;
					
				case 31://ListaArgumentos ->, Expresion ListaArgumentos
					pila.Pop();	
					aux = ((NoTerminal)pila.Pop()).nodo;
					pila.Pop();	
					nodo= ((NoTerminal)pila.Pop()).nodo;
					pila.Pop();	
					pila.Pop();//,
					nodo.siguiente = aux;
					break;
					
					
				case 35://LlamadaFunc -> id ( Argumentos )
					pila.Pop();
					pila.Pop();//)
					pila.Pop();	
					aux = ((NoTerminal)pila.Pop()).nodo;
					pila.Pop();
					pila.Pop();//(
					pila.Pop();	
					nodo = (((Nodo)pila.Pop()));
					nodo.siguiente = aux;
					break;
					
				case 39://Expresion -> Expresion opSuma Expresion	
				case 40://Expresion -> Expresion opLogico Expresion
				case 41://Expresion -> Expresion opMul Expresion
				case 42://Expresion -> Expresion opRelac Expresion
					nodo  = new Expresion(pila);
					break;
			}
			return nodo;
		}
		

		void matriz() {
			int i = 0;
			String aux;
			
			String[] corte = new string[2];
			while((aux = reglas.ReadLine()) != null) {
				corte = aux.Split('\t');
				_reglas[i,0] = int.Parse(corte[0]);
				_reglas[i++,1] = int.Parse(corte[1]);
			}
			
			i = 0;//reseteo el conteo
			corte = new string[40];
			while((aux = Tabla.ReadLine()) != null) {
				
				corte = aux.Split('\t');
				for(int j = 0; j < 40; j++) {
					_tabla[i,j] = int.Parse(corte[j]);
				}
				i++;
			}
			
		}
		
		public String texto() {
			return ""+_tabla[78,39];
		}
		
		public String getValue(int e) {
			e--;
			if(e == 0) {
				return "var,";
			}else if(e == 1) {
				return "main,";
			}else if(e == 4) {
				return "(,";
			}else if(e == 5) {
				return "),";
			}else if(e == 6) {
				return "{,";
			}else if(e == 7) {
				return "},";
			}else if(e == 18) {
				return "$,";
			}
			return e+",";
		}
		
	}
}
