import java.util.Scanner;

public class scanner {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String myName = sc.nextLine();

        System.out.print("My name : " + myName);

        sc.close();
    }
}
