import java.util.HashMap;

public class GameOfLife {
    private final int width;
    private final int height;
    private final int generations;
    private final int speed;
    private int n = 0;
    private final String population;
    private final int[][] matrizGOL;

    public GameOfLife(String[] args) {
        HashMap<String, String> argumentos = ArrayMatriz.argumentos(args);
        this.width = parseArgument(argumentos.get("w"), "width");
        this.height = parseArgument(argumentos.get("h"), "height");
        this.generations = parseArgument(argumentos.get("g"), "generations");
        this.speed = parseArgument(argumentos.get("s"), "speed");
        this.population = argumentos.get("p");
        this.n = parseArgument(argumentos.get("n"), "n")!=0 ? parseArgument(argumentos.get("n"), "n") : 0;
        this.matrizGOL = ArrayMatriz.convMatriz(this.population, this.height, this.width);
    }

    private int parseArgument(String arg, String argName) {
        try {
            if (arg == null) {
                return 0;
            }
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Argument " + argName + " is not a number or is null. ");
            return -1;
        }

    }



    public void mostrarInfo() {
        System.out.println(this.width==0 ? "Width=[No presente]" :this.width==-1?"Width=[Invalido]" : "width: " + this.width);
        System.out.println(this.height==0 ? "Height=[No presente]" :this.height==-1?"Height=[Invalido]" : "height: " + this.height);
        System.out.println(this.generations==0 ? "Generations=[No presente]" :this.generations==-1?"Generations=[Invalido]" : "Generations: " + this.generations);
        System.out.println(this.population==null ? "Population=[No presente]" : "Population: " + this.population);
        System.out.println(this.speed==0 ? "Speed=[No presente]" :this.speed==-1?"Speed=[Invalido]" : "Speed: " + this.speed);
        System.out.println("n: " + this.n);
        ArrayMatriz.imprimirMatriz(this.matrizGOL);
    }
}