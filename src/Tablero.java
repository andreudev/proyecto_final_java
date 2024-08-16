public class Tablero {
    private int[][] matrizGOL;

    public Tablero(String population, int height, int width) {
        this.matrizGOL = convMatriz(population, height, width);
    }


    private int[][] convMatriz(String stringMatriz, int height, int width) {
        String[] filas = stringMatriz == null ? new String[0] : stringMatriz.split("#");
        int[][] matriz = new int[height==-1?0:height][width==-1?0:width];
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

    public void imprimirMatriz() {
        System.out.println("Matriz: ");
        for (int[] ints : this.matrizGOL) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
