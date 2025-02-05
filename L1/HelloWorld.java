import java.util.Scanner;

public class HelloWorld{
    // static void main(String[] args){
    //     System.out.print("Hello World");
    // }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        String name[] = new String[n];
        for(int i=0; i < n; i++){
            name[i] = sc.nextLine();
        }

        for(String x : name){
            myName(x);
        }
    }
}