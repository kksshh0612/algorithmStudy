import java.util.Scanner;

// 0과 1 중 묶음의 수가 더 적은 것 선택해서 뒤집기
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inpuut = scanner.nextLine();
        char[] arr = inpuut.toCharArray();

        int[] bundleCnt = new int[2];       // 0 1
        char prev = arr[0];
//        int cnt = 1;
        bundleCnt[prev - '0'] = 1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] == prev) continue;;

            prev = arr[i];
            bundleCnt[prev - '0']++;
        }

        System.out.println(Math.min(bundleCnt[0], bundleCnt[1]));
    }
}