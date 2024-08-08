import java.util.HashMap;

public class GameOfLife {
    private int width = 0;
    private int height = 0;
    private int generations = 0;
    private int speed = 0;
    private int n=0;
    private String population = "";

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
