# Tarea 6. Analizador Semántico

Esta actividad consistirá en realizar el analizador semántico con lo que se había hecho en la actividad anterior (tanto analizador léxico como sintáctico). También en esta actividad se mostrará tanto los errores semánticos como el propio árbol sintáctico formado por dicho análisis.


Mientras que las reglas de la gramática son las siguientes:

 - R1 programa ::= Definiciones 
 - R2 Definiciones ::= \e 
 - R3 Definiciones ::= Definicion Definiciones 
 - R4 Definicion ::= DefVar 
 - R5 Definicion ::= DefFunc 
 - R6 DefVar ::= tipo identificador ListaVar ; 
 - R7 ListaVar ::= \e 
 - R8 ListaVar ::= , identificador ListaVar 
 - R9 DefFunc ::= tipo identificador ( Parametros ) BloqFunc 
 - R10 Parametros ::= \e 
 - R11 Parametros ::= tipo identificador ListaParam 
 - R12 ListaParam ::= \e 
 - R13 ListaParam ::= , tipo identificador ListaParam 
 - R14 BloqFunc ::= { DefLocales } 
 - R15 DefLocales ::= \e 
 - R16 DefLocales ::= DefLocal DefLocales 
 - R17 DefLocal ::= DefVar 
 - R18 DefLocal ::= Sentencia 
 - R19 Sentencias ::= \e 
 - R20 Sentencias ::= Sentencia Sentencias 
 - R21 Sentencia ::= identificador = Expresion ; 
 - R22 Sentencia ::= if ( Expresion ) SentenciaBloque Otro 
 - R23 Sentencia ::= while ( Expresion ) Bloque 
 - R24 Sentencia ::= return ValorRegresa ; 
 - R25 Sentencia ::= LlamadaFunc ; 
 - R26 Otro ::= \e 
 - R27 Otro ::= else SentenciaBloque 
 - R28 Bloque ::= { Sentencias } 
 - R29 ValorRegresa ::= \e 
 - R30 ValorRegresa ::= Expresion 
 - R31 Argumentos ::= \e 
 - R32 Argumentos ::= Expresion ListaArgumentos 
 - R33 ListaArgumentos ::= \e 
 - R34 ListaArgumentos ::= , Expresion ListaArgumentos 
 - R35 Termino ::= LlamadaFunc 
 - R36 Termino ::= identificador 
 - R37 Termino ::= entero 
 - R38 Termino ::= real 
 - R39 Termino ::= cadena 
 - R40 LlamadaFunc ::= identificador ( Argumentos ) 
 - R41 SentenciaBloque ::= Sentencia 
 - R42 SentenciaBloque ::= Bloque 
 - R43 Expresion ::= ( Expresion ) 
 - R44 Expresion ::= opSuma Expresion 
 - R45 Expresion ::= opNot Expresion 
 - R46 Expresion ::= Expresion opMul Expresion 
 - R47 Expresion ::= Expresion opSuma Expresion 
 - R48 Expresion ::= Expresion opRelac Expresion 
 - R49 Expresion ::= Expresion opIgualdad Expresion 
 - R50 Expresion ::= Expresion opAnd Expresion 
 - R51 Expresion ::= Expresion opOr Expresion 
 - R52 Expresion ::= Termino 
 
Y para poner a prueba el analizador semántico se usarán dos códigos de prueba. Estos códigos son los siguientes:
 
### Código 1:
 
```sh
int main(){
float a;
int b;
int c;
c = a+b;
c = suma(8,9);
}
```

### Código 2:

```sh
int a;
int suma(int a, int b){
	return a+b;
}

int main(){
float a;
int b;
int c;
c = a+b;
c = suma(8.5,9.9);
}
```


