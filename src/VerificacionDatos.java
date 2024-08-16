import java.util.HashMap;

public class VerificacionDatos {



    public static HashMap<String, String> argumentosSplit(String[] args) {
        HashMap<String, String> argumentos = new HashMap<>();
        for (String arg : args) {
            String[] argumento = arg.split("=");
            argumentos.put(argumento[0], argumento[1]);
        }
        return argumentos;
    }


    public static int parseArgument(String arg, String argName) {
        try {
            if (arg == null) {
                return 0;
            } else if (!verificarDatoValido(arg, argName)) {
                System.out.println("Numero no valido");
                return -1;

            }
            return Integer.parseInt(arg);
        } catch (NumberFormatException e) {
            System.out.println("Argument " + argName + " is not a number ");
            return -1;
        }
    }

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
            case "generations", "n" -> {
                if (Integer.parseInt(arg) > 0) {
                    return true;
                }
            }
        }

        return false;
    }
}
