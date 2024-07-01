import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// r 줄이기 -> (2row+2col - 4) 로 mod 연산 하기
public class Main {

    public static void rotate(int[][] arr, int minus, int row, int col){
        int start = arr[0 + minus][0 + minus];

        for(int i = 0 + minus; i < col - minus - 1; i++){
            arr[minus][i] = arr[minus][i + 1];
        }
        for(int i = 0 + minus; i < row - minus - 1; i++){
            arr[i][col - minus - 1] = arr[i + 1][col - minus - 1];
        }
        for(int i = col- 1 - minus; i > 0 + minus; i--){
            arr[row - minus - 1][i] = arr[row - minus - 1][i - 1];
        }
        for(int i = row- 1 - minus; i > 0 + minus + 1; i--){
            arr[i][minus] = arr[i - 1][minus];
        }
        arr[minus + 1][minus] = start;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int rotateCnt = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i = 0; i < Math.min(row, col) / 2; i++){
            int currRotateCnt = rotateCnt % (2 * (row -  2 * i) + 2 * (col - 2 * i) - 4);

            for(int j = 0; j < currRotateCnt; j++){
                rotate(arr, i, row, col);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                stringBuilder.append(arr[i][j]).append(" ");
            }
            if(i < row - 1) stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }
}