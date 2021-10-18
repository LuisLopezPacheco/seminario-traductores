# Tarea 6. Analizador Semántico

Esta actividad consistirá en realizar el analizador semántico con lo que se había hecho en la actividad anterior (tanto analizador léxico como sintáctico). También en esta actividad se mostrará tanto los errores semánticos como el propio árbol sintáctico formado por dicho análisis.

Recordando, la gramática utilizada es la siguiente:

[compilador.xlsx](https://github.com/Erosval2101/Traductores_de_Lenguaje_II/files/5646517/compilador.xlsx)

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

## Resultados.

![Captura1](https://user-images.githubusercontent.com/70926870/101234942-8aadd680-3689-11eb-834e-8ee2a4c2dbdb.PNG)

![Captura3](https://user-images.githubusercontent.com/70926870/101234998-0ad43c00-368a-11eb-9393-2cb41edab703.PNG)

![Captura4](https://user-images.githubusercontent.com/70926870/101235008-29d2ce00-368a-11eb-996f-5a293690a3bc.PNG)

![Captura5](https://user-images.githubusercontent.com/70926870/101235023-5555b880-368a-11eb-9f56-057f371194aa.PNG)

![Captura6](https://user-images.githubusercontent.com/70926870/101235034-7dddb280-368a-11eb-8ca0-e09655631891.PNG)

![Captura7](https://user-images.githubusercontent.com/70926870/101235052-a2d22580-368a-11eb-8d48-c8a270498fe1.PNG)

![Captura8](https://user-images.githubusercontent.com/70926870/101235068-c4331180-368a-11eb-932b-e9c9edd5409e.PNG)

![Captura2](https://user-images.githubusercontent.com/70926870/101234941-8a154000-3689-11eb-9681-951e5c521c83.PNG)

![Captura9](https://user-images.githubusercontent.com/70926870/101235089-fa709100-368a-11eb-9664-0b0f1fbf7a75.PNG)

![Captura10](https://user-images.githubusercontent.com/70926870/101235099-170cc900-368b-11eb-8879-f5a1e53a0dfe.PNG)
 
![Captura11](https://user-images.githubusercontent.com/70926870/101235167-bf229200-368b-11eb-93e0-26e3ebb20f00.PNG)

![Captura12](https://user-images.githubusercontent.com/70926870/101235174-c21d8280-368b-11eb-9cb5-876a14ce2dc0.PNG)

![Captura13](https://user-images.githubusercontent.com/70926870/101235173-c184ec00-368b-11eb-9c95-08799e57d556.PNG)

![Captura14](https://user-images.githubusercontent.com/70926870/101235172-c0ec5580-368b-11eb-9df3-e88f59fff961.PNG)

![Captura15](https://user-images.githubusercontent.com/70926870/101235171-c053bf00-368b-11eb-9467-e51128a538df.PNG)

![Captura16](https://user-images.githubusercontent.com/70926870/101235169-bfbb2880-368b-11eb-8cba-91f0f79cf4c5.PNG)

![Captura17](https://user-images.githubusercontent.com/70926870/101235168-bf229200-368b-11eb-846a-d769cf8e96ea.PNG)
