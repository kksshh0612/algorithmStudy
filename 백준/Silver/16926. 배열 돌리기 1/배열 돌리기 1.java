import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] dirX = {1, 0, -1, 0};
    private static int[] dirY = {0, 1, 0, -1};

    private static void rotate(int rotateNum, int[][] arr, int row, int col){

        for(int i = 0; i < rotateNum / 2; i++){
            int x = i;
            int y = i;

            int lastVal = arr[y][x];

            int idx = 0;
            while(idx < 4){                 //네 면
                int nextX = x + dirX[idx];
                int nextY = y + dirY[idx];

                if((nextX < col - i && nextX >= i) && (nextY < row - i && nextY >= i)){
                    arr[y][x] = arr[nextY][nextX];
                    x = nextX;
                    y = nextY;
                }
                else{
                    idx++;
                }
            }
            arr[y + 1][x] = lastVal;
        }
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
        int min = Math.min(row, col);

        for(int i = 0; i < rotateCnt; i++){
            rotate(min, arr, row, col);
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}