import java.util.HashMap;
import java.util.Map;

public class ArrayMatriz {

    public static HashMap<String, String> argumentos(String[] args) {
        HashMap<String, String> argumentos = new HashMap<>();
        for (String arg : args) {
            String[] argumento = arg.split("=");
            argumentos.put(argumento[0], argumento[1]);
        }
        return argumentos;
    }

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
        System.out.println("Matriz: ");
        for (int[] ints : matriz) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
