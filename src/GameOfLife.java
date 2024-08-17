import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Scanner;

// todo: Implementar un metodo que verifique que datos son necesarios para iniciar las generaciones (Hecho)
// todo: Implementar un metodo que verifique que los datos sean validos (Hecho)


public class GameOfLife implements KeyListener {
    private final int width;
    private final int height;
    private final int generations;
    private final int speed;
    private volatile boolean stop = false;
    private int n = 3;
    private final String population;
    private Tablero tablero;


    /**
     * Constructor de la clase
     * @param args Arreglo de Strings
     */

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

    /**
     * Metodo que verifica si los datos son validos
     * @return {@code true} si los datos son validos, {@code false} si no son validos
     */
    private boolean readyToGo() {
        return this.width != -1 && this.height != -1 && this.generations != -1 && this.speed != -1
                && tablero.getMatrizGOL().length != 0;
    }


    /**
     * Metodo que inicia el juego
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        if (readyToGo()) {
            mostrarInfo();
            System.out.println("Presione enter para iniciar el juego");
            scanner.nextLine();



            if (this.generations > 0) {
                generaciones();
            }else {
                generacionsInfinitas();
            }
        } else {
            System.out.println("No se puede iniciar el juego");
        }
    }

    /**
     * Metodo que genera generaciones finitas
     */
    private void generaciones() {

        //for (int i = 0; (i < this.generations) && !tablero.isExtincto(); i++) {
        // Si se quiere que el juego se detenga cuando la poblacion se extinga
        for (int i = 0; i < this.generations; i++) {
            clearScreen();
            tablero.vecindario(this.n);
            tablero.imprimirMatriz();
            System.out.print("Generacion: " + (i + 1));
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Metodo que genera generaciones infinitas
     * Se ejecuta hasta que el usuario presione enter
     */

    private void generacionsInfinitas() {
        int i = 0;
        while (!stop && !tablero.isExtincto()) {
            clearScreen();
            tablero.vecindario(this.n);
            tablero.imprimirMatriz();
            System.out.print("Generacion: " + (i + 1));
            try {
                Thread.sleep(this.speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }

    /**
     * Metodo que limpia la pantalla
     */

    private void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo que muestra la informacion de los datos ingresados
     */

    public void mostrarInfo() {
        System.out.println(this.width==0 ? "Width=[No presente]" :this.width==-1?"Width=[Invalido]" : "width: " + this.width);
        System.out.println(this.height==0 ? "Height=[No presente]" :this.height==-1?"Height=[Invalido]" : "height: " + this.height);
        System.out.println(this.generations==0 ? "Generations=[No presente]" :this.generations==-1?"Generations=[Invalido]" : "Generations: " + this.generations);
        System.out.println(this.population==null ? "Population=[No presente]" : "Population: " + this.population);
        System.out.println(this.speed==0 ? "Speed=[No presente]" :this.speed==-1?"Speed=[Invalido]" : "Speed: " + this.speed);
        System.out.println("n: " + this.n);
        tablero.imprimirMatriz();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            stop = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}