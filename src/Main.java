public class Main {
    public static void main(String[] args) {
        int width = 0, height = 0, generations = 0,speed = 0,
                n=0;
        String population = "";
        for(int i = 0; i < args.length; i++){
            //w=10 h=20 g=100 s=300 p=”101#010#111” n=1
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
        }
        System.out.print("width: " + width + "\nheight: " + height + "\ngenerations: " + generations + "\nspeed: " + speed + "\npopulation: " + population + "\nn: " + n);
    }
}