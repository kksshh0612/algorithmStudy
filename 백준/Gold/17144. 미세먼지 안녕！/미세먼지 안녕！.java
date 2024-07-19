import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int row, col;
    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};

    // 네 방향으로 /5만큼 확산. 확산시킨 칸은 이전 - (이전/5 X 확산된 방향 수)
    public static void spread(int[][] arr){
        int[][] add = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int cnt = 0;
                for(int k = 0; k < 4; k++){
                    int nextRow = i + dirRow[k];
                    int nextCol = j + dirCol[k];

                    if((nextRow < 0 || nextRow >= row) || (nextCol < 0 || nextCol >= col)) continue;
                    if(arr[nextRow][nextCol] == -1) continue;

                    add[nextRow][nextCol] += arr[i][j] / 5;
                    cnt++;
                }
                arr[i][j] -= arr[i][j] / 5 * cnt;
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                arr[i][j] += add[i][j];
            }
        }
    }

    // 위쪽은 반시계, 아래쪽은 시계 방향. 바람 방향으로 한칸씩 이동
    public static void clean(int[][] arr, int airDownRow){
        // 위쪽
        int startRow = airDownRow - 1;
        for(int i = startRow - 2; i >= 0; i--){             // 아래
            arr[i + 1][0] = arr[i][0];
        }
        for(int i = 1; i < col; i++){                       // 왼
            arr[0][i - 1] = arr[0][i];
        }
        for(int i = 1; i <= startRow; i++){                 // 위
            arr[i - 1][col - 1] = arr[i][col - 1];
        }
        for(int i = col - 2; i >= 1; i--){                  // 오른
            arr[startRow][i + 1] = arr[startRow][i];
        }
        arr[startRow][1] = 0;

        // 아래쪽
        startRow = airDownRow;
        for(int i = startRow + 2; i < row; i++){
            arr[i - 1][0] = arr[i][0];
        }
        for(int i = 1; i < col; i++){
            arr[row - 1][i - 1] = arr[row - 1][i];
        }
        for(int i = row - 2; i >= startRow; i--){
            arr[i + 1][col - 1] = arr[i][col - 1];
        }
        for(int i = col - 2; i >= 1; i--){
            arr[startRow][i + 1] = arr[startRow][i];
        }
        arr[startRow][1] = 0;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        row = Integer.parseInt(stringTokenizer.nextToken());
        col = Integer.parseInt(stringTokenizer.nextToken());
        int sec = Integer.parseInt(stringTokenizer.nextToken());

        int[][] arr = new int[row][col];
        int airDownRow = 0;     // 공기청정기의 아래쪽
        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(arr[i][j] == -1) airDownRow = i;
            }
        }

        while(sec-- > 0){
            spread(arr);
            clean(arr, airDownRow);
        }

        int ans = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                ans += arr[i][j];
            }
        }
        System.out.println(ans + 2);

    }
}