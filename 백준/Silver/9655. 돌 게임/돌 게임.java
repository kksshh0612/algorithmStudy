import java.util.Scanner;

// n-1 n-5 n-9를 차지해야 함
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n >= 4){
            n -= 4;
        }
        if(n % 2 == 1){
            System.out.println("SK");
        }
        else{
            System.out.println("CY");
        }
    }
}
