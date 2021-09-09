using System;
using System.Collections.Generic;

namespace Analizador_sintactico_LR_1
{
    class Program
    {
        static void Main(string[] args)
        {

            string myChain = "hola+mundo";
            Console.WriteLine("Entrada 1: hola+mundo");

            Sintactico mySyntactic = new();
            mySyntactic.analyze(myChain);
            Console.WriteLine();
            Console.WriteLine("Simbolos | Tipo | ID");
            foreach (Token aux in mySyntactic.myList)
            {
                Console.WriteLine(aux.GetToken());
            }
            Console.WriteLine("\nEjercicio 1");
            mySyntactic.analyze1();
            mySyntactic.clear();
            Console.ReadLine();
            //********************************************+Ejercicio: 2********************************************+
            Console.Clear();
            Console.WriteLine("Entrada 2: a+b+c+d+e+f");
            myChain = "a+b+c+d+e+f";
            mySyntactic.analyze(myChain);
            foreach (Token aux in mySyntactic.myList)
            {
                Console.WriteLine(aux.GetToken());
            }
            Console.WriteLine("\nEjercicio 1");
            mySyntactic.analyze2();
           
        }
    }
}
