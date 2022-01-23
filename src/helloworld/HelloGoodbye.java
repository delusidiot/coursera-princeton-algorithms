package helloworld;

public class HelloGoodbye {
    public static void main(String[] args) {
        System.out.print("Hello ");
        for (int i = 0; i < args.length; i++){
            System.out.print(args[i]);
            if (i == args.length - 1)
                System.out.println(".");
            else
                System.out.print(" and ");
        }
        System.out.print("Goodbye ");
        for (int i = args.length - 1; i >= 0; i--){
            System.out.print(args[i]);
            if (i == 0)
                System.out.println(".");
            else
                System.out.print(" and ");
        }
    }
}
