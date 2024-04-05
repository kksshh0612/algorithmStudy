import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[] dirX = {-1, 0, 1, 0};
    public static int[] dirY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];
        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        int ans = 2 * row * col;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                for(int k = 0; k < 4; k++){
                    int nextX = j + dirX[k];
                    int nextY = i + dirY[k];

                    if((nextX < 0 || nextX >= col) || (nextY < 0 || nextY >= row)){
                        ans+= arr[i][j];
                    }
                    else if(arr[i][j] > arr[nextY][nextX]){
                        ans += arr[i][j] - arr[nextY][nextX];
                    }
                }
            }
        }

        System.out.println(ans);
    }
}