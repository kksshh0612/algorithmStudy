import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int moveRow = Integer.parseInt(stringTokenizer.nextToken());
        int moveCol = Integer.parseInt(stringTokenizer.nextToken());

        int[][] arr = new int[row + moveRow][col + moveCol];
        int[][] ans = new int[row][col];

        for(int i = 0; i < row + moveRow; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col + moveCol; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i = 0; i < moveRow; i++){
            for(int j = 0; j < col; j++){
                ans[i][j] = arr[i][j];
            }
        }
        for(int i = 0; i < moveCol; i++){
            for(int j = 0; j < row; j++){
                ans[j][i] = arr[j][i];
            }
        }

        for(int i = moveRow; i < row; i++){
            for(int j = moveCol; j < col; j++){
                ans[i][j] = arr[i][j] - ans[i - moveRow][j - moveCol];
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                stringBuilder.append(ans[i][j]).append(" ");
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}