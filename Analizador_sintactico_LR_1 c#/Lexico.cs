using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Analizador_sintactico_LR_1
{
    class Lexico
    {
        public List<Token> myList = new();
        private int state;
        private String result;

        

        public void analyze(string mychain)
        {
            mychain += " ";
            int index = 0;
            char c;
            state = 0;

            while (index < mychain.Length)
            {
                c = mychain[index++];

                switch (state)
                {
                    case 0:
                        {
                            if (char.IsLetter(c))
                            {
                                state = 1;
                                result += c;
                            }
                            else if (char.IsDigit(c)) //listo
                            {
                                state = 2;
                                result += c;
                            }
                            else if (Equals(c, '+') || Equals(c, '-')) //listo
                            {
                                result += c;
                                addToken(Token.Type.q4);
                            }
                            else if (Equals(c, '*') || Equals(c, '/'))  //listo
                            {
                                result += c;
                                addToken(Token.Type.q5);
                            }
                            else if (Equals(c, '=')) //listo
                            {
                                state = 5;
                                result += c;
                            }
                            else if (Equals(c, '<') || Equals(c, '>') || Equals(c, '!')) // listo
                            {
                                state = 6;
                                result += c;
                            }
                            else if (Equals(c, '&')) // listo
                            {
                                state = 7;
                                result += c;
                            }
                            else if (Equals(c, '|'))  // listo
                            {
                                state = 8;
                                result += c;
                            }
                            else if (Equals(c, '(') || Equals(c, ')'))  // listo
                            {
                                result += c;
                                addToken(Token.Type.q10);
                            }
                            else if (Equals(c, '{') || Equals(c, '}'))  // listo
                            {
                                result += c;
                                addToken(Token.Type.q11); // listo
                            }
                            else if (Equals(c, ';'))  // listo
                            {
                                result += c;
                                addToken(Token.Type.q12);
                            }
                            else if (Equals(c, '.'))
                            {
                                state = 9;
                                result += c;
                            }
                            else if (Equals(c, '$'))
                            {
                                result += c;
                                addToken(Token.Type.q20);
                            }
                            else if (Equals(c, ' '))
                            {

                            }
                            else
                            {
                                result += c;
                                state = -1;
                            }
                        }
                        break;
                    case 1:
                        {
                            if (char.IsLetter(c) || char.IsDigit(c))
                            {
                                result += c;
                            }
                            else if (!(Equals(c, '.')))
                            {
                                addToken(isReservedWord(result));
                                index--;
                            }
                            else
                            {
                                result += c;
                                state = -1;
                            }
                        }
                        break;
                    case 2:                 //Entero
                        {
                            if (char.IsDigit(c))
                            {
                                //el estado no cambia
                                result += c;
                            }
                            else if (Equals(c, '.'))
                            {
                                state = 3;
                                result += c;
                            }
                            else if (char.IsLetter(c))
                            {
                                addToken(Token.Type.q2);
                                index--;
                            }
                            else if (isSpace(c))
                            {
                                addToken(Token.Type.q2);
                            }
                            else
                            {
                                addToken(Token.Type.q2);
                                index--;
                            }
                        }
                        break;
                    case 3:                 //Flotante
                        {
                            if (char.IsDigit(c))
                            {
                                result += c;
                                state = 4;
                            }
                            else if (char.IsLetter(c) || Equals(c, '.'))      //error
                            {
                                result += c;
                                state = -1;
                            }
                            else if (isSpace(c))
                            {
                                result += '0';
                                addToken(Token.Type.q3);
                            }
                            else
                            {
                                result += '0';
                                addToken(Token.Type.q3);
                            }
                        }
                        break;
                    case 4:                 //Flotante
                        {
                            if (char.IsDigit(c))
                            {
                                result += c;

                            }
                            else if (char.IsLetter(c) || Equals(c, '.'))   //error
                            {
                                result += c;
                                state = -1;
                            }
                            else if (isSpace(c))
                            {

                                addToken(Token.Type.q3);
                            }
                            else
                            {
                                addToken(Token.Type.q3);
                                index--;
                            }
                        }
                        break;
                    case 5:                 //Operador = y ==
                        {
                            if (Equals(c, '='))
                            {
                                result += c;
                                addToken(Token.Type.q7);
                            }
                            else
                            {
                                addToken(Token.Type.q6);
                                index--;
                            }

                        }
                        break;
                    case 6:                //Operador < | > | <= | >= | != 
                        {
                            if (Equals(c, '=') && Equals(result, "<"))
                            {
                                result += c;
                                addToken(Token.Type.q7);
                            }
                            else if (Equals(c, '=') && Equals(result, ">"))
                            {
                                result += c;
                                addToken(Token.Type.q7);
                            }
                            else if (Equals(c, '=') && Equals(result, "!"))
                            {
                                result += c;
                                addToken(Token.Type.q7);
                            }
                            else
                            {
                                if (Equals(result, "!"))
                                {
                                    addToken(Token.Type.q19);
                                    index--;
                                }
                                else
                                {
                                    addToken(Token.Type.q7);
                                    index--;
                                }
                            }
                        }
                        break;
                    case 7:                 //Operador &&
                        {
                            if (Equals(c, '&'))
                            {
                                result += c;
                                addToken(Token.Type.q8);
                            }
                            else
                            {
                                result += c;
                                state = -1;
                            }
                        }
                        break;
                    case 8:                 //Operador ||
                        {
                            if (Equals(c, '|'))
                            {
                                result += c;
                                addToken(Token.Type.q9);
                            }
                            else
                            {
                                result += c;
                                state = -1;
                            }
                        }
                        break;
                    case 9:
                        {
                            if (Equals(c, '.'))
                            {
                                state = -1;
                                result += c;
                            }
                            else if (char.IsLetter(c))
                            {
                                state = -1;
                                result += c;
                            }
                            else if (char.IsDigit(c))
                            {
                                result += c;

                            }
                            else
                            {
                                addToken(Token.Type.q3);
                            }
                        }
                        break;
                    case -1:
                        {
                            if (char.IsDigit(c) || char.IsLetter(c) || Equals(c, '.'))
                            {
                                result += c;
                            }
                            else
                            {
                                index--;
                                addToken(Token.Type.q22);
                            }
                        }
                        break;
                }

            }

            

        }


        public void addToken(Token.Type type)
        {
            myList.Add(new Token(type, result));
            result = "";
            state = 0;
        }

        bool isSpace(char c)
        {
            return Equals(c, ' ') || Equals(c, '\t');
        }

        Token.Type isDataType(string chain)
        {
            if (chain == "int")
            {
                return Token.Type.q17;
            }
            else if (chain == "float")
            {
                return Token.Type.q18;
            }
            else if (chain == "string")
            {
                return Token.Type.q21;
            }
            else if (chain == "string")
            {
                return Token.Type.q18;
            }
            return Token.Type.q1;
        }


        Token.Type isReservedWord(string chain)
        {

            if (chain == "if")
            {
                return Token.Type.q13;
            }
            else if (chain == "while")
            {
                return Token.Type.q14;
            }
            else if (chain == "return")
            {
                return Token.Type.q15;
            }
            else if (chain == "else")
            {
                return Token.Type.q16;
            }
            else if (chain == "int")
            {
                return Token.Type.q17;
            }
            else if (chain == "float")
            {
                return Token.Type.q18;
            }
            else if (chain == "string")
            {
                return Token.Type.q21;
            }
            else if (chain == "string")
            {
                return Token.Type.q18;
            }
            return Token.Type.q1;
        }

    }
}
