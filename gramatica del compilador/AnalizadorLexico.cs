
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Analizador_lexico {
	/// <summary>
	/// Description of AnalizadorLexico.
	/// </summary>
	public class AnalizadorLexico {
		private String entrada;
		public AnalizadorLexico(String entrada) {
			this.entrada = entrada;
		}
		private LinkedList<Token> Salida;
		private LinkedList<Token> SalidaError;
		private int estado;
		private String aux;
		
		public LinkedList<Token> escanear() {
			int fila=1,columna=1;
			entrada += " $";//fin de la cadena
			Salida = new LinkedList<Token>();//nueva lista de tokens
			SalidaError = new LinkedList<Token>();
			estado = 0;
			aux = "";
			char c;//caracter actual
			for(int i = 0; i < entrada.Length; i++) {
				c = entrada.ElementAt(i);
				//reconocer los estados
								
				switch(estado) {
					case 0:
						if(char.IsLetter(c) || c.CompareTo('_')==0) {
							estado = 1;
							aux += c;
						}else if(c.CompareTo(';')==0) {
							aux += c;
							agregarToken(Token.Estado.q2, fila, columna);
						}else if(c.CompareTo(',')==0) {
							aux += c;
							agregarToken(Token.Estado.q3, fila, columna);
						}else if(c.CompareTo('(')==0) {
							aux += c;
							agregarToken(Token.Estado.q4, fila, columna);
						}else if(c.CompareTo(')')==0) {
							aux += c;
							agregarToken(Token.Estado.q5, fila, columna);
						}else if(c.CompareTo('{')==0) {
							aux += c;
							agregarToken(Token.Estado.q6, fila, columna);
						}else if(c.CompareTo('}')==0) {
							aux += c;
							agregarToken(Token.Estado.q7, fila, columna);
						}else if(c.CompareTo('=')==0 || c.CompareTo('<')==0 ||c.CompareTo('>')==0 ||c.CompareTo('!')==0) {
							estado = 16;
							aux += c;
						}else if(char.IsDigit(c)) {
							estado = 9;
							aux += c;
						}else if(c.CompareTo('.')==0) {
							estado = 10;
							aux += c;
						}else if(c.CompareTo('+')==0 || c.CompareTo('-')==0) {
							aux += c;
							agregarToken(Token.Estado.q12, fila, columna);
						}else if(c.CompareTo('&')==0 || c.CompareTo('|')==0) {
							estado = 13;
							aux += c;
						}else if(c.CompareTo('*')==0 || c.CompareTo('/')==0 || c.CompareTo('%')==0) {
							aux += c;
							agregarToken(Token.Estado.q15, fila, columna);
						}else if(c.CompareTo('$')==0 && i+1== entrada.Length) {
							//analiza el fin de cadea
							aux += c;
							agregarToken(Token.Estado.qFin, fila, columna);
						}else if(!esEspacio(c)){
							//en el caso de que no cumpla la condicion y no sea algun tipo de espacis
							aux += c;
							agregarTokenError(Token.Estado.qError, fila, columna);
						}
						break;
					case 1:
						if(char.IsLetter(c) || c.CompareTo('_')==0 || char.IsDigit(c)) {
							aux += c;
						}else if(c.CompareTo('$')==0 && i+1== entrada.Length) {
							//analiza el fin de cadea
							agregarToken(Token.Estado.q1, fila, columna);
						} else {
							//verificar si el token es un tipo de dato o una palabra reservada
							if(esTipoDato(aux)) {
								agregarToken(Token.Estado.qTipo, fila, columna);
							}else {
								agregarToken(esReservada(aux), fila, columna);
							}
							i--;
						}
						break;
					case 9:
						if(char.IsDigit(c)) {
							//el estadfo no cambia
							aux += c;
						}else if(c.CompareTo('.')==0) {
							estado = 10;
							aux += c;
						}else if(char.IsLetter(c)) {
							//llevarme a un caso de error
							estado = 17;
							aux += c;
						}else if(c.CompareTo('$')==0 && i+1== entrada.Length) {
							//analiza el fin de cadea
							agregarToken(Token.Estado.q9, fila, columna);
						} else {
							i--;
							agregarToken(Token.Estado.q9, fila, columna);
						}
						break;
					case 10:
						if(char.IsDigit(c)) {
							estado = 11;
							aux += c;
						} else if(char.IsLetter(c)) {
							//llevarme a un caso de error
							i--;
							agregarTokenError(Token.Estado.qError, fila, columna);
							
						}else if(esEspacio(c)) {
							i--;
							agregarTokenError(Token.Estado.q10, fila, columna);
						} else if(c.CompareTo('$')==0 && i+1== entrada.Length) {
							//analiza el fin de cadea
							agregarTokenError(Token.Estado.q10, fila, columna);
						} else {
							i--;
							agregarToken(Token.Estado.q10, fila, columna);
						}
						break;
					case 11:
						if(char.IsDigit(c)) {
							//el estadfo no cambia
							aux += c;
						} else if(char.IsLetter(c)) {
							//llevarme a un caso de error
							estado = 17;
							aux += c;
						} else if(c.CompareTo('$')==0 && i+1== entrada.Length) {
							//analiza el fin de cadea
							agregarToken(Token.Estado.q11, fila, columna);
						} else {
							i--;
							agregarToken(Token.Estado.q11, fila, columna);
						}
						break;
					case 13:
						if((c.CompareTo('&')==0 || c.CompareTo('|')==0) && aux[0] == c) {
							aux += c;
							agregarToken(Token.Estado.q14, fila, columna);
						}else if(c.CompareTo('&')==0 || c.CompareTo('|')==0) {
							//llevarme a un caso de error
							estado = 17;
							aux += c;
							agregarTokenError(Token.Estado.qError, fila, columna);
						} else if(c.CompareTo('$')==0 && i+1== entrada.Length) {
							//analiza el fin de cadea
							agregarToken(Token.Estado.qFin, fila, columna);
						} else {
							i--;
							agregarTokenError(Token.Estado.q1, fila, columna);
						}
						break;
					case 16:
						if(!(c.CompareTo('=')==0) && aux == "=") {
							//analizar la asignacion
							i--;
							agregarToken(Token.Estado.q8, fila, columna);
						} else if((aux == "<" || aux == ">") && !(c.CompareTo('=')==0)) {
							//SOLO >, <
							if(c.CompareTo('>')==0 || c.CompareTo('<')==0 ||c.CompareTo('!')==0) {
								//erro logico
								estado = 17;
								aux += c;
							} else {
								i--;
								agregarToken(Token.Estado.q16, fila, columna);
							}
						}else if(c.CompareTo('=')==0) {
							//solo <=, >=, !=, == 
							aux += c;
							agregarToken(Token.Estado.q16, fila, columna);
						} else if(c.CompareTo('$')==0 && i+1== entrada.Length) {
							//analiza el fin de cadea
						} else {
							estado = 17;
							aux += c;
						}
						break;
					case 17:System.Windows.Forms.MessageBox.Show(aux+","+c);
						if(!esEspacio(c) && c.CompareTo('$')==0 && i+1 == entrada.Length) {
							aux += c;
						} else {
							aux += c;
							agregarTokenError(Token.Estado.qError, fila, columna);
						}
						break;
				}
				
				if(c.CompareTo('\n')==0) {
					fila++;
					columna=1;
				}else {
					columna++;
				}
			}
			return Salida;
		}
		
		public void agregarToken(Token.Estado tipo, int fila, int columna) {
			Salida.AddLast(new Token(tipo, aux, fila, columna-aux.Length));
			aux= "";
			estado = 0;
		}
		
		public void agregarTokenError(Token.Estado tipo, int fila, int columna) {
			SalidaError.AddLast(new Token(tipo, aux, fila, columna-aux.Length));
			aux= "";
			estado = 0;
		}
		
		public LinkedList<Token> listError() {
			return SalidaError;
		}
		
		public void imprimir(LinkedList<Token> lista) {
			foreach(Token item in lista) {
				System.Windows.Forms.MessageBox.Show(item.getStado()+"---"+item.getToken());
			}
		}
		
		bool esEspacio(char c) {
			return c.CompareTo(' ')==0 || c.CompareTo('\t')==0 || c.CompareTo('\n')==0;
		}
		
		bool esTipoDato(String cadena) {
			if(cadena == "int" || cadena == "string" || cadena == "char" || cadena == "bool" || cadena == "double" || cadena == "float") {
				return true;
			}
			return false;
		}
		
		Token.Estado esReservada (String cadena) {
			if(cadena == "if") {
				return Token.Estado.qIf;
			} else if(cadena == "while") {
				return Token.Estado.qWhile;
			}else if (cadena == "return") {
				return Token.Estado.qReturn;
			}else if (cadena == "else") {
				return Token.Estado.qElse;
			}
			return Token.Estado.q1;
		}
	}
}
