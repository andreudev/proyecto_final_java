
public class Main {
    public static void main(String[] args) {

        GameOfLife gol = new GameOfLife(args);
        gol.mostrarInfo();
        for (int i = 0; i < gol.getGenerations(); i++) {
            gol.getTablero().vecindario(gol.getN());
            gol.getTablero().imprimirMatriz();
        }
    }
}