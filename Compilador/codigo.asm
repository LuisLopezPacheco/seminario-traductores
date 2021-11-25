    org  100h 
    jmp inicio 
var1 db 01h
var2 db 03h
    
inicio:     mov al,04h
            mov bl,03h
            add  al,bl  ;al=al+bl
     
            mov al,04h
            mov bl,03h
            sub al,bl   ;añ=al-bl
    
            mov al,04h
            mov bl,03h 
            sub bl,al   ;bl=bl-al
    ret