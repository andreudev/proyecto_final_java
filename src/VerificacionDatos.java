import java.util.HashMap;

public class VerificacionDatos {


    /**
    * Metodo que recibe un arreglo de Strings y los separa en un HashMap
    * @param args Arreglo de Strings
    * @return HashMap con los argumentos
    *
    * Ejemplo:
    * args = {"width=10","height=10","speed=250","n=3","generations=10","p=glider"}
    * argumentosSplit(args) -> {width=10, height=10, speed=250, n=3, generations=10, p=glider}
     */
    public static HashMap<String, String> argumentosSplit(String[] args) {
        HashMap<String, String> argumentos = new HashMap<>();
        for (String arg : args) {
            String[] argumento = arg.split("=");
            argumentos.put(argumento[0], argumento[1]);
        }
        return argumentos;
    }

    /**
    * Metodo que recibe un String y un nombre de argumento
    * Verifica si el argumento es un numero y si es valido
    * @param arg String con el argumento
    * @param argName Nombre del argumento
    * @return El numero {@code int} si es valido, 0 si es null y -1 si no es valido
    * Ejemplo:
    * arg = "10", argName = "width"
    * parseArgument(arg, argName) -> 10
     */

    public static int parseArgument(String arg, String argName) {
        try {
            if (arg == null) {
                return 0;
            } else if (!verificarDatoValido(arg, argName)) {
                System.out.println("Number not valid");
                return -1;

            }
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Argument " + argName + " is not a number ");
            return -1;
        }
    }

    /**
     * Este metodo verifica si el argumento esta dentro de los valores validos
     * @param arg String con el argumento
     * @param argName Nombre del argumento
     * @return {@code true} si el argumento es valido, {@code false} si no es valido
     */

    private static boolean verificarDatoValido(String arg, String argName) {
        final int [] width = {10,20,40,80};
        final int [] height = {10,20,40};
        final int [] speed = {250,1000};

        switch (argName) {
            case "width" -> {
                for (int i : width) {
                    if (i == Integer.parseInt(arg)) {
                        return true;
                    }
                }
            }
            case "height" -> {
                for (int i : height) {
                    if (i == Integer.parseInt(arg)) {
                        return true;
                    }
                }
            }
            case "speed" -> {
                for (int i : speed) {
                    if (i == Integer.parseInt(arg)) {
                        return true;
                    }
                }
            }
            case "n" -> {
                if (Integer.parseInt(arg) > 0) {
                    return true;
                }
            }
            case "generations" -> {
                if (Integer.parseInt(arg) >= 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
