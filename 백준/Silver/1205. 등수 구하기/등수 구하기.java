import java.util.Scanner;

// 현재 랭킹에 내 점수를 끼워넣는 방식
//public class Boj1205 {
public class Main {    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int newNum = scanner.nextInt();
        int total = scanner.nextInt();

        int[] arr = new int[size];
        for(int i = 0; i < size; i++){
            arr[i] = scanner.nextInt();
        }

        int cnt = 1;        //내 등수
        for(int i = 0; i < size; i++){
            if(total-- > 0){
                if(arr[i] > newNum) cnt++;
                else if(arr[i] < newNum){
                    total++;
                    break;
                }
            }
            else{
                cnt = -1;
                break;
            }
        }

        if(total <= 0) cnt = -1;

        System.out.println(cnt);
    }
}
