import java.util.Scanner;

public class MatrizAdjunta {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingresa el número de filas: ");
        int n = scanner.nextInt();
        
        System.out.print("Ingresa el número de columnas: ");
        int m = scanner.nextInt();

        int[][] matriz = new int[n][m];

        if(n==m){
            System.out.println("Ingresa los elementos de la matriz:");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("Valor [" + (i + 1) + "][" + (j + 1) + "]: ");
                    matriz[i][j] = scanner.nextInt();
                }
            }
            
            int[][] adjunta = calcularMatrizAdjunta(matriz);
            System.out.println("\nMatriz Adjunta:");
            mostrarMatriz(adjunta);
    
            scanner.close();
        } else {
            System.out.println("No se puede, no es una matriz cuadrada");
        }
    }

    private static int[][] calcularMatrizAdjunta(int[][] matriz) {
        int n = matriz.length;
        int[][] adjunta = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cofactor = calcularCofactor(matriz, i, j);
                adjunta[j][i] = cofactor;
            }
        }

        return adjunta;
    }


    private static int calcularCofactor(int[][] matriz, int fila, int columna) {
        int signo = (fila + columna) % 2 == 0 ? 1 : -1;
        int submatriz[][] = obtenerSubmatriz(matriz, fila, columna);
        return signo * determinante(submatriz);
    }

    private static int[][] obtenerSubmatriz(int[][] matriz, int fila, int columna) {
        int n = matriz.length;
        int[][] submatriz = new int[n - 1][n - 1];
        int subfila = 0, subcolumna = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != fila && j != columna) {
                    submatriz[subfila][subcolumna++] = matriz[i][j];

                    if (subcolumna == n - 1) {
                        subcolumna = 0;
                        subfila++;
                    }
                }
            }
        }

        return submatriz;
    }

    private static int determinante(int[][] matriz) {
        int n = matriz.length;

        if (n == 1) {
            return matriz[0][0];
        }

        if (n == 2) {
            return matriz[0][0] * matriz[1][1] - matriz[0][1] * matriz[1][0];
        }

        int det = 0;

        for (int i = 0; i < n; i++) {
            int signo = (i % 2 == 0) ? 1 : -1;
            int cofactor = signo * matriz[0][i] * determinante(obtenerSubmatriz(matriz, 0, i));
            det += cofactor;
        }

        return det;
    }

    private static void mostrarMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("["+matriz[i][j]+"]" + "   ");
            }
            System.out.println();
        }
    }
}
