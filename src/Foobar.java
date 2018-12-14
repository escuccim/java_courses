import java.util.Scanner;

public class Foobar {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Weclome!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.println("Hello " + name);
    }
}
