using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.IO;

namespace Analizador_sintactico_LR_1
{
    class Sintactico:Lexico
    {
       
        private Stack objectStack = new();
        private Stack<int> intStack = new();
        private int fila, columna, accion;
        private bool aceptacion = false;
       

        public Sintactico()
        {
            
        }

        public void analyze1()
        {
            Token terminal = new(Token.Type.q20, "$");
            objectStack.Clear();
            objectStack.Push(terminal);
            objectStack.Push(0);
            myList.Add(terminal);
            int index=0;
            bool regla1 = false;
            bool aceptacion = false;

            int[,] tabla = new int[,] {
                //0,1,2,3
                //id,+,$,E
                {2,0,0,1},  
                {0,0,-1,0},
                {0,3,0,0},
                {4,0,0,0},
                {0,0,-2,0}
            };
    
            while (!aceptacion)
            {
                if (!regla1) {
                   
                    fila = (int)objectStack.Peek();
                    columna = myList[index].Type1;
                }
                regla1 = false;
                accion = tabla[fila, columna];
                Console.WriteLine("Columna: " + columna);
                Console.WriteLine("fila: " + fila);
                Console.Write("Contenido en la pila: ");
                showStack();
                Console.WriteLine("\nEntrada: " + myList[index].Chain + " | " + myList[index].Symbol);
                Console.WriteLine("Acción: " + accion);
                if (accion == 0)
                {
                    Console.WriteLine("Valor no aceptado");
                    Console.WriteLine("Cadena rechazada...");
                    break;
                }
                else if (accion == -2)
                {
                    Console.WriteLine("Regla: r1(E-><id>+<id>)");
                    Console.Write("POP: ");
                    for (int i=0; i<3; i++)
                    {
                        ShowPop();
                        if (i < 5)
                        {
                            Console.Write(", ");
                        }
                    }
                    var aux = (int)objectStack.Peek();
                    fila = aux;
                    columna = 3;
                   
                    Console.WriteLine();
                    regla1 = true;
                }
                else if(accion == -1)
                {
                    Console.WriteLine("Regla: r0(acept)");
                    aceptacion = true; 
                }
                else
                {
                    objectStack.Push((Token)myList[index]);
                    objectStack.Push(accion);
                }

                if (myList[index].Chain != "$")
                {
                    index++;
                }
                Console.ReadLine();
            }
            clear();
        }
        
        public void analyze2()
        {
            Token terminal = new(Token.Type.q20, "$");
            objectStack.Clear();
            objectStack.Push(terminal);
            objectStack.Push(0);
            myList.Add(terminal);
            int index = 0, abs;
            bool regla = false;
            int[] idReglas = { 3, 3 };
            int[] lonReglas = { 3, 1 };
            int[,] tabla = new int[,] {
                //0,1,2,3
                //id,+,$,E
                {2,0,0,1},
                {0,0,-1,0},
                {0,3,-3,0},
                {2,0,0,4},
                {0,0,-2,0}
            };
            while (!aceptacion)
            {
                if (!regla)
                {
                    fila = (int)objectStack.Peek();
                    columna = myList[index].Type1;
                }
                regla = false;
                accion = tabla[fila, columna];
                Console.WriteLine("Columna: " + columna);
                Console.WriteLine("fila: " + fila);
                Console.Write("Contenido en la pila: ");
                showStack();
                Console.WriteLine("\nEntrada: " + myList[index].Chain + " | " + myList[index].Symbol);
                Console.WriteLine("Acción: " + accion);
                
                if(accion > 0)                      //Desplazamiento
                {
                    objectStack.Push(myList[index]);
                    objectStack.Push(accion);
                }
                else if (accion < -1)                //reducción
                {
                    abs = (Math.Abs(accion))-2 ;
                    Console.WriteLine("Regla: r"+((Math.Abs(accion))-1));
                    
                    Console.Write("POP: ");
                   
                    for (int i = 0; i < (lonReglas[abs]); i++)
                    {
                        ShowPop();
                        if (i < ((lonReglas[abs] * 2)-1))
                        {
                            Console.Write(", ");
                        }
                    }
                    
                    fila = (int)objectStack.Peek();

                    columna = idReglas[abs];
                    Console.WriteLine();
                    regla = true;
                    
                }
                else if (accion == -1)
                {
                    Console.WriteLine("Regla: r0(acept)");
                    aceptacion = true;
                }
                else if (accion == 0)
                {
                    Console.WriteLine("Valor no aceptado");
                    Console.WriteLine("Cadena rechazada...");
                    break;
                } 

                if (myList[index].Chain != "$")
                {
                    index++;
                }
                Console.ReadLine();

            }
            clear();
        }

        public void clear()
        {
            myList.Clear();
            objectStack.Clear();
        }

        public void ShowPop()
        {
            int id = (int)objectStack.Pop();
            Token token = (Token)objectStack.Pop();
            
            Console.Write(token.Chain + id + " ");
        }

        public void showStack()
        {
            Stack aux = new(objectStack);
            
            while (aux.Count != 0)
            {
                Token token = (Token)aux.Pop();
                int id = (int)aux.Pop();
                Console.Write(token.Chain+ id + " ");
            }
            
        }
    }
}
