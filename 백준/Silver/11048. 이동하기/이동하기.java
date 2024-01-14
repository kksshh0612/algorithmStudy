
import java.util.Scanner;

public class Main {

    public static int[] nextX = {0, 1, 1};
    public static int[] nextY = {1, 0, 1};

    public static void count(int[][] arr, int[][] dp, int currX, int currY){

        for(int i = 0; i < 3; i++){
            int nextXPos = currX + nextX[i];
            int nextYPos = currY + nextY[i];

            if((nextXPos < 0 || nextXPos >= arr[0].length) || (nextYPos < 0 || nextYPos >= arr.length)) continue;

            if(dp[currY][currX] + arr[nextYPos][nextXPos] > dp[nextYPos][nextXPos]){
                dp[nextYPos][nextXPos] = dp[currY][currX] + arr[nextYPos][nextXPos];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] arr = new int[row][col];
        int[][] dp = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] = scanner.nextInt();
                dp[i][j] = arr[i][j];
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                count(arr, dp, j, i);
            }
        }

        System.out.println(dp[row - 1][col - 1]);
    }
}