Matriz Adjunta

Integrantes del equipo:
Gadiel Alcazar Bernal
Laura Juarez Vargas

Introducción
En este proyecto haremos un programa donde al ingresar una matriz devuelva el resultado de la matriz adjunta.

¿Qué es?
Una matriz adjunta es el resultado de sacar la matriz negativa de una matriz, se obtiene de la siguiente forma:

1. Calcular el determinante de cada elemento de la matriz original. El determinante es un número que se obtiene haciendo una operación con los elementos de una submatriz que se forma eliminando la fila y la columna donde está el elemento.
En esta matriz:
    [a][b][c]
A=  [d][e][f]
    [g][h][i]

el determinante del elemento "a" se calcula con la submatriz:
[e][f]
[h][i]

y la operación es esta:
det(a) = (e*i) - (f*h)

2. Después de haber sacado los determinantes de cada posición se sigue una regla de signos donde
"a" es positivo
"b" es negativo
"c" es positivo
"d" es negativo
y así sucesivamente...

esa se llama, matriz de cofactores, y es así:
        [ei-fh] -[di-fg]  [dh-eg]
cof(A)=-[bi-ch]  [ai-cg] -[ah-bg]
        [bf-ce] -[af-cd]  [ae-bd]

y para obtener la matriz adjunta solo se cambian las filas por  las columnas, lo que da como resultado de la matriz A:
        [ei-fh] -[bi-ch]  [bf-ce]
adj(A)=-[di-fg]  [ai-cg] -[af-cd]
        [dh-eg] -[ah-bg]  [ae-bd]
