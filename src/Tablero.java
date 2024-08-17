// todo: Implementar los 5 tipos de vecindarios que existen en el juego de la vida

public class Tablero {
    private int[][] matrizGOL;

    public Tablero(String population, int height, int width) {
        this.matrizGOL = convMatriz(population, height, width);
    }

    private int[][] convMatriz(String stringMatriz, int height, int width) {
        if ("rnd".equals(stringMatriz)) {

            /* Genera una matriz aleatoria
            Math.random() genera un numero aleatorio entre 0 y 1
            Math.round() redondea el numero al entero mas cercano sea 0 o 1

            El operador ternario se usa para verificar si height y width son -1
            ya que estos valores serian invalidos y se asigna 0 en caso de ser invalidos
            */

            int[][] matriz = new int[height==-1?0:height][width==-1?0:width];
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[i].length; j++) {
                    matriz[i][j] = (int) Math.round(Math.random());
                }
            }
            return matriz;
        } else {
            /*
            * Convierte el string de la matriz en una matriz de enteros
            * Verifica el string si es null o si la matriz es valida en cuanto a su tamaño de filas y columnas
            * Devuelve la matriz de enteros
            */
        String[] filas = stringMatriz == null ? new String[0] : stringMatriz.split("#");
        int[][] matriz = new int[height==-1?0:height][width==-1?0:width];
        if (filas.length > height) {
            System.out.println("La matriz no es valida");
            return new int[0][0];
        }
        for (int i = 0; i < filas.length; i++) {
            char[] columnas = filas[i].toCharArray();
            if (columnas.length > width) {
                System.out.println("La matriz no es valida");
                return new int[0][0];
            }
            for (int j = 0; j < columnas.length; j++) {
                matriz[i][j] = Character.getNumericValue(columnas[j]);
            }
        }
        return matriz;
        }
    }

    /*
    * Imprime la matriz en consola
    */
    public void imprimirMatriz() {
        System.out.println("Matriz: ");
        for (int[] ints : this.matrizGOL) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public void vecindario(int n) {
        int[][] matrizAux = new int[this.matrizGOL.length][this.matrizGOL[0].length];
        for (int i = 0; i < this.matrizGOL.length; i++) {
            for (int j = 0; j < this.matrizGOL[i].length; j++) {
                // Toma en cuenta el valor de n para calcular el tipo de vecindario
                int vecinos = n == 3 ? vecindario3(i, j) : vecindario1(i, j);
                // Reglas del GOL
                if (this.matrizGOL[i][j] == 1) {
                    if (vecinos < 2 || vecinos > 3) {
                        matrizAux[i][j] = 0;
                    } else {
                        matrizAux[i][j] = 1;
                    }
                } else {
                    if (vecinos == 3)
                        matrizAux[i][j] = 1;
                }
            }
        }
        this.matrizGOL = matrizAux;
    }


    /*
    * Crea una matriz de 3x3 con los vecinos de la celda i,j
    * Si la celda esta en el borde de la matriz, se rellena con 0
     */
    private int[][] vecinadrioCopiado(int i, int j) {
        int[][] vecinos = new int[3][3];
        for (int k = i - 1; k <= i + 1; k++) {
            for (int l = j - 1; l <= j + 1; l++) {
                if (k >= 0 && k < this.matrizGOL.length && l >= 0 && l < this.matrizGOL[0].length) {
                    vecinos[k - i + 1][l - j + 1] = this.matrizGOL[k][l];
                }
            }
        }
        return vecinos;
    }



    private int vecindario1(int i, int j) {
        int vecinos = 0;
        int[][] vecinosCopiados = vecinadrioCopiado(i, j);
        for(int k=0;k<vecinosCopiados.length;k++){
            for(int l=0;l<vecinosCopiados[k].length;l++){
                if(k==l || k+l == vecinosCopiados.length-1){
                    continue;
                }
                if(vecinosCopiados[k][l]==1){
                    vecinos++;
                }
            }
        }
        return vecinos;
    }


    private int vecindario3(int i, int j) {
        int vecinos = 0;
        int[][] vecinosCopiados = vecinadrioCopiado(i, j);

        for (int[] vecino : vecinosCopiados) {
            for (int i1 : vecino) {
                if (i1 == 1) {
                    vecinos++;
                }
            }
        }
        return vecinos - this.matrizGOL[i][j];
    }

}
