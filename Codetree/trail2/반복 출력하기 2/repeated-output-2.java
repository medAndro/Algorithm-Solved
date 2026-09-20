import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursive(n);
    }
    static void recursive(int depth){
        if(depth == 0){
            return;
        }
        System.out.println("HelloWorld");
        recursive(depth-1);
    }
}