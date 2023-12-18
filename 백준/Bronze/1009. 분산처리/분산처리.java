import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tCase = scanner.nextInt();

        while(tCase-- > 0){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int num = 1;
            for(int i = 0; i < b; i++){
                num = num * a;
                if(num > 10) num %= 10;
            }

            if(num == 0) System.out.println(10);
            else System.out.println(num);
        }
    }
}