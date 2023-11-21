import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 최대가 되게 스티커 떼기
//public class Boj9465 {
public class Main {
    public static int solution(int[][] arr){
        if(arr[0].length > 1){
            arr[0][1] += arr[1][0];
            arr[1][1] += arr[0][0];
        }

        for(int i = 2; i < arr[0].length; i++){     //열
            arr[0][i] += Math.max(arr[1][i - 1], arr[1][i - 2]);
            arr[1][i] += Math.max(arr[0][i - 1], arr[0][i - 2]);
        }

        return Math.max(arr[0][arr[0].length - 1], arr[1][arr[0].length - 1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(bufferedReader.readLine());

        while(tCase-- > 0){
            int col = Integer.parseInt(bufferedReader.readLine());
            int[][] arr = new int[2][col];

            for(int i = 0; i < 2; i++){
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 0; j < col; j++){
                    arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }

            System.out.println(solution(arr));
        }
    }
}
