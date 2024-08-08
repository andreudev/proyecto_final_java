import java.util.HashMap;
import java.util.Map;

public class ArrayMatriz {

//    public static Map

    public static int[][] matriz(String stringMatriz) {
        String[] filas = stringMatriz.split("#");
        int[][] matriz = new int[filas.length][filas.length];
        for (int i = 0; i < filas.length; i++) {
            char[] columnas = filas[i].toCharArray();
            for (int j = 0; j < columnas.length; j++) {
                matriz[i][j] = Character.getNumericValue(columnas[j]);
            }
        }
        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int[] ints : matriz) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
