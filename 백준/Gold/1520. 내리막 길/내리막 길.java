import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 내리막길로 갈 수 잇는 경우의 수
// 각 칸에 현재까지 온 방법의 수 적기
public class Main {

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};

    public static int DFS(int[][] dp, int[][] arr, int currX, int currY){

        if(dp[currY][currX] != -1) return dp[currY][currX];

        if(currX == arr[0].length - 1 && currY == arr.length - 1) return 1;

        dp[currY][currX] = 0;

        for(int i = 0; i < 4; i++){
            int nextX = currX + dirX[i];
            int nextY = currY + dirY[i];

            if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;

            if(arr[nextY][nextX] < arr[currY][currX]){

                dp[currY][currX] += DFS(dp, arr, nextX, nextY);
            }
        }

        return dp[currY][currX];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                dp[i][j] = -1;
            }
        }


        int ans = DFS(dp, arr, 0, 0);

//        for(int i = 0; i < row; i++){
//            for(int j = 0; j < col; j++){
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }

        System.out.println(ans);


    }
}