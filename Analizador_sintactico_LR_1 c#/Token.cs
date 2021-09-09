using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Analizador_sintactico_LR_1
{
	public class Token
	{
		public enum Type
		{
			q1, // variable
			q2, // Entero
			q3, // Real
			q4, // Operador de adición +-
			q5, // Operador de Multiplicación */
			q6, // Operador de asignación = 
			q7, // Operador relacional < | > | <= | >= | != | ==
			q8, // Operador And  &&
			q9, // Operador Or  ||
			q10, // Parentesis	()
			q11, // llave		{}
			q12, // punto, coma 
			q13, // if
			q14, // while
			q15, // return
			q16, // else
			q17, // int
			q18, // float
			q19, // Operador Not
			q20, // $
			q21, // string
			q22, // Error
			q23 //inicial
		}

		private Type state;
		private string chain, symbol;
		private int type;




		public string Chain { get => chain; set => chain = value; }
		public string Symbol { get => symbol; set => symbol = value; }
		public int Type1 { get => type; set => type = value; }

		public Token()
		{ }
		public Token(Type myState, string myChain)
		{
			state = myState;
			chain = myChain;
			generateId();
		}

		public void generateId()
		{
			switch (state)
			{
				case Type.q1:       //identificador
					type = 0;
					symbol = "Variable";
					break;
				case Type.q2:       //Entero
					type = 1;
					symbol = "Entero";
					break;
				case Type.q3:       //Real
					type = 2;
					symbol = "Real";
					break;
				case Type.q4:       //Operador de Adición
					type = 1;
					symbol = "Operador de Adición";
					break;
				case Type.q5:       //Operador de Multiplicación
					type = 6;
					symbol = "Operador de Multiplicación";
					break;
				case Type.q6:       //Operador de Asignación
					type = 18;
					symbol = "Operador de Asignación";
					break;
				case Type.q7:       //Operador Relacional
					type = 7;
					symbol = "Operador Relacional";
					break;
				case Type.q8:       //Operador And
					type = 9;
					symbol = "Operador And";
					break;
				case Type.q9:       //Operador Not
					type = 10;
					symbol = "Operador Not";
					break;
				case Type.q10:          //Parentesis
					if (symbol == "(")
					{
						type = 14;
					}
					else
					{
						type = 15;
					}
					symbol = "Parentesis";
					break;
				case Type.q11:          // llave
					if (symbol == "{")
					{
						type = 16;
					}
					else
					{
						type = 17;
					}
					symbol = "llave";
					break;
				case Type.q12:          //punto y coma 
					type = 12;
					symbol = "punto y coma";
					break;
				case Type.q13:      //if
					type = 19;
					symbol = "if";
					break;
				case Type.q14:      //while
					type = 20;
					symbol = "while";
					break;
				case Type.q15:      // return
					type = 21;
					symbol = "return";
					break;
				case Type.q16:       // else
					type = 22;
					symbol = "else";
					break;
				case Type.q17:       // int
					type = 17;
					symbol = "int";
					break;
				case Type.q18:       // float
					type = 18;
					symbol = "float";
					break;
				case Type.q19:       // Operador Or
					type = 19;
					symbol = "Operador Or";
					break;
				case Type.q20:      //Fin de cadena
					type = 2;
					symbol = "Fin de cadena";
					break;
				case Type.q21:      //string
					type = 3;
					symbol = "string";
					break;
				case Type.q22:        // Error
					type = -1;
					symbol = "Error";
					break;
				case Type.q23: //Inicial
					type = 0;
					Symbol = "S.";
					break;
			}
		}




		public string GetToken()
		{

			return chain + " |" + symbol + " | " + type;
		}


	}
}
