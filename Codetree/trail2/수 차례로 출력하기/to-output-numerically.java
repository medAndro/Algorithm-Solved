import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recursiveAsc(n);
        System.out.println();
        recursiveDesc(n);
    }

    static void recursiveAsc(int n){
        if(n == 0){
            return;
        }
        recursiveAsc(n-1);
        System.out.print(n+" ");
    }


    static void recursiveDesc(int n){
        if(n == 0){
            return;
        }
        System.out.print(n+" ");
        recursiveDesc(n-1);
    }
}