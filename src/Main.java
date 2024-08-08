public class Main {
    public static void main(String[] args) {
        int width = 0, height = 0, generations = 0,speed = 0,
                n=0;
        String population = "";

        /*
            w=10 h=20 g=100 s=300 p=”101#010#111” n=1
            TODO: MODULAR EL CODIGO
            TODO: VALIDAR LOS ARGUMENTOS
            TODO: CREAR UNA MATRIZ CON LOS ARGUMENTOS
        */


        for (String arg : args)
            try {
                if (arg.startsWith("w="))
                    width = Integer.parseInt(arg.substring(2));
                else if (arg.startsWith("h="))
                    height = Integer.parseInt(arg.substring(2));
                else if (arg.startsWith("g="))
                    generations = Integer.parseInt(arg.substring(2));
                else if (arg.startsWith("s="))
                    speed = Integer.parseInt(arg.substring(2));
                else if (arg.startsWith("p="))
                    population = arg.substring(2);
                else if (arg.startsWith("n="))
                    n = Integer.parseInt(arg.substring(2));
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato de los argumentos");
            }
        System.out.println(width==0 ? "width [Invalido] " :
                "width = " + width + " ");
        System.out.println(height==0 ? "height [Invalido] " :
                "height = " + height + " ");
        System.out.println(generations==0 ? "generations [Invalido] " :
                "generations = " + generations + " ");
        System.out.println(speed==0 ? "speed [Invalido] " :
                "speed = " + speed + " ");
        System.out.println(population.isEmpty() ? "population [Invalido] " :
                "population = " + population + " ");
        System.out.println(n==0 ? "n [Invalido] " :
                "n = " + n + " ");
        System.out.println("Matriz: ");

        int[][] resultado = ArrayMatriz.matriz(population);
        ArrayMatriz.imprimirMatriz(resultado);
    }


}