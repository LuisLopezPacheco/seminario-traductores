
using System;

namespace Analizador_lexico
{
	/// <summary>
	/// Description of Token.
	/// </summary>
	public class Token {
		public Token() { }
		
		public enum Estado {
			q0,
			q1,
			q2,
			q3,
			q4,
			q5,
			q6,
			q7,
			q8,
			q9,
			q10,
			q11,
			q12,
			q13,
			q14,
			q15,
			q16,
			qTipo,
			qIf, qWhile, qReturn, qElse,
			qFin,
			qError
			
		}
		
		private Estado estado;
		private String token;
		private int fila, columna, id;
		
		public Token(Token token) {
			this.estado	= token.estado;
			this.token	= token.token;
			this.fila	= token.fila;
			this.columna= token.columna;
			this.id		= token.id;
		}
		
		public String getValue(Estado e) {
			if(e == Estado.q0) {
				return "var";
			}else if(e == Estado.q1) {
				return "main";
			}else if(e == Estado.q4) {
				return "(";
			}else if(e == Estado.q5) {
				return ")";
			}else if(e == Estado.q6) {
				return "{";
			}else if(e == Estado.q7) {
				return "}";
			}
			return "";
		}
		
		public Token(Estado estadoToken, String token, int fila, int columna) {
			this.estado = estadoToken;
			this.token = token;
			this.fila = fila;
			this.columna = columna;
		}
		
		public String getToken() {
			return token;
		}
		
		public int getFila() {
			return fila;
		}
		
		public int gefColumna() {
			return columna;
		}
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public String getStado() {
			switch(estado) {
			case Estado.q1://variable o palabra reservada
				id = 1;
				return "variable";
			case Estado.q2://punto y coma
				id = 2;
				return  "punto y coma";
			case Estado.q3://coma
				id = 3;
				return "coma";
			case Estado.q4://parentesis apertura
				id = 4;
				return  "parentesis izq";
			case Estado.q5://parentesis cierre
				id = 5;
				return "parentesis der";
			case Estado.q6://llave apertura
				id = 6;
				return  "llave izq";
			case Estado.q7://llave cierre
				id = 7;
				return "llave der";
			case Estado.q8://igual
				id = 8;
				return  "asignacion";
			case Estado.q9://numero entero
				id = 13;
				return "entero";
			case Estado.q11://numero flotante
				id = 13;
				return  "flotante";
			case Estado.q12:// mas o menos
				id = 14;
				return "operador suma";
			case Estado.q14://operador logico
				id = 15;
				return "operador logico";
			case Estado.q15://mult, div o mod
				id = 16;
				return "operador mult";
			case Estado.q16://fin
				id = 17;
				return  "operador relacional";
			case Estado.qTipo:
				id = 0;
				return "tipo de dato";
			case Estado.qIf:
				id = 9;
				return "if";
			case Estado.qWhile:
				id = 10;
				return "while";
			case Estado.qReturn:
			id =11;
			return "else";
			case Estado.qElse:
				id = 12;
				return "else";
			case Estado.qFin:
				id = 18;
				return "fin ejecucion";
			default:
				id = -1;
				return "error";
			}
		}
	}
}
