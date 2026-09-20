import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursiveStar(n);
    }

    static void recursiveStar(int n){
        if(n == 0){
            return;
        }

        recursiveStar(n-1);
        for(int i = 0; i<n; i++){
            System.out.print("*");
        }
        System.out.println();
    }
}