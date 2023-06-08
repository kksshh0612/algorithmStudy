import java.util.Scanner;

//1934 최소공배수
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tCase = scanner.nextInt();
        for(int i = 0; i < tCase; i++){
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            //a를 더 큰 수로 만들기
            if(a != Math.max(a, b)){
                int tmp = a;
                a = b;
                b = tmp;
            }

            int idx = 1;
            while(true){
                if((a * idx) % b == 0){
                    System.out.println(a * idx);
                    break;
                }
                idx++;
            }
        }
    }
}