import java.util.HashMap;

public class GameOfLife {
    private final int width;
    private final int height;
    private final int generations;
    private final int speed;
    private int n = 3;
    private final String population;
    private Tablero tablero;


    public GameOfLife(String[] args) {
        HashMap<String, String> argumentos = VerificacionDatos.argumentosSplit(args);

        this.width = VerificacionDatos.parseArgument(argumentos.get("w"), "width");
        this.height = VerificacionDatos.parseArgument(argumentos.get("h"), "height");
        this.generations = VerificacionDatos.parseArgument(argumentos.get("g"), "generations");
        this.speed = VerificacionDatos.parseArgument(argumentos.get("s"), "speed");
        this.population = argumentos.get("p");

        /*
        * Se verifica que el valor de n sea mayor a 0 y menor o igual a 5
        * Funcionamient operador ternario
        * (condicion) ? valor_si_verdadero : valor_si_falso
         */

        this.n = (VerificacionDatos.parseArgument(argumentos.get("n"), "n")>0)&&(
                VerificacionDatos.parseArgument(argumentos.get("n"), "n")<=5
                ) ?
                VerificacionDatos.parseArgument(argumentos.get("n"), "n"):this.n;
        this.tablero = new Tablero(this.population, this.height, this.width);
    }




    public void mostrarInfo() {
        System.out.println(this.width==0 ? "Width=[No presente]" :this.width==-1?"Width=[Invalido]" : "width: " + this.width);
        System.out.println(this.height==0 ? "Height=[No presente]" :this.height==-1?"Height=[Invalido]" : "height: " + this.height);
        System.out.println(this.generations==0 ? "Generations=[No presente]" :this.generations==-1?"Generations=[Invalido]" : "Generations: " + this.generations);
        System.out.println(this.population==null ? "Population=[No presente]" : "Population: " + this.population);
        System.out.println(this.speed==0 ? "Speed=[No presente]" :this.speed==-1?"Speed=[Invalido]" : "Speed: " + this.speed);
        System.out.println("n: " + this.n);
        tablero.imprimirMatriz();
    }
}