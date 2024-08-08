public class Main {
    public static void main(String[] args) {
        int width = 0, height = 0, generations = 0,speed = 0,
                n=0;
        String population = "";
        for(int i = 0; i < args.length; i++){
            //w=10 h=20 g=100 s=300 p=”101#010#111” n=1
            try {
                if(args[i].startsWith("w="))
                    width = Integer.parseInt(args[i].substring(2));
                else if(args[i].startsWith("h="))
                    height = Integer.parseInt(args[i].substring(2));
                else if(args[i].startsWith("g="))
                    generations = Integer.parseInt(args[i].substring(2));
                else if(args[i].startsWith("s="))
                    speed = Integer.parseInt(args[i].substring(2));
                else if(args[i].startsWith("p="))
                    population = args[i].substring(2);
                else if(args[i].startsWith("n="))
                    n = Integer.parseInt(args[i].substring(2));
            } catch (NumberFormatException e) {
                System.out.println("Error en el formato de los argumentos");
            }
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


    }
}