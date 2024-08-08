import java.util.HashMap;

public class GameOfLife {
    private final int width;
    private final int height;
    private final int generations;
    private final int speed;
    private int n=0;
    private final String population;

    public GameOfLife(String[] args) {
        HashMap<String, String> argumentos = ArrayMatriz.argumentos(args);
        this.width = Integer.parseInt(argumentos.get("w"));
        this.height = Integer.parseInt(argumentos.get("h"));
        this.generations = Integer.parseInt(argumentos.get("g"));
        this.speed = Integer.parseInt(argumentos.get("s"));
        this.population = argumentos.get("p");
        this.n = Integer.parseInt(argumentos.get("n"));
    }

    public void mostrarInfo() {
        System.out.println("Width: " + this.width);
        System.out.println("Height: " + this.height);
        System.out.println("Generations: " + this.generations);
        System.out.println("Speed: " + this.speed);
        System.out.println("Population: " + this.population);
        System.out.println("N: " + this.n);
        int[][] resultado = ArrayMatriz.matriz(this.population);
        ArrayMatriz.imprimirMatriz(resultado);

    }

}
