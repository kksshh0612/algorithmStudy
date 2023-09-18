import java.util.Scanner;

// B 맨 끝이 1이면 빼고 짝수면 2로 나눔 -> A가 될 때까지
//public class Boj16953 {
public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int answer = 0;

        while(a < b){
            if(b % 10 == 1){
                b /= 10;
                answer++;
            }else if(b % 2 == 0){
                b /= 2;
                answer++;
            }
            else{           //마지막이 1도 아니고, 2로도 나누어 떨어지지 않으면 만들 수 없는 수
                answer = -1;
                break;
            }
        }
        if(a == b){
            answer++;
        }
        else{
            answer = -1;
        }

        System.out.println(answer);
    }
}
