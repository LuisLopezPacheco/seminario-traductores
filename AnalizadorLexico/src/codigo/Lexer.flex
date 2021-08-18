package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
%{
    public String lexeme;
%}
%%
int |
float|
double|
string|
long|
switch|
case|
for|
bool|
throw|
break|
print|
return|
exception|
try|
catch|
import|
if |
else |
while {lexeme=yytext(); return Reservadas;}
{espacio} {/*Ignore*/}
"//".* {/*Ignore*/}
"<" |
"=="|
">="|
"<="|
"!="|
">" {lexeme=yytext(); return Relacional;}
"+" |
"-" |
"*" |
"%" |
"/" {lexeme=yytext(); return Aritmetica;}
"&&"|
"||" {lexeme=yytext(); return Logico;}
"=" {lexeme=yytext(); return Asignacion;}
";" {lexeme=yytext(); return PuntoComa;}
"(" {lexeme=yytext(); return ParentesisIzq;}
")" {lexeme=yytext(); return ParentesisDer;}
"{" {lexeme=yytext(); return LlaveIzq;}
"}" {lexeme=yytext(); return LlaveDer;}
"++" {lexeme=yytext(); return Incremental;}
"--" {lexeme=yytext(); return Decremental;}

{L}({L}|{D})* {lexeme=yytext(); return Identificador;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Entero;}
({D}"."{D}) {lexeme=yytext(); return Flotante;}
 . {return ERROR;}
