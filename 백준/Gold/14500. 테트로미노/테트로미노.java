import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 완전탐색으로 4칸 탐색하는 경우 모두 구해보기.
// ㅗ 모양의 경우, 두번째에서 탐색 한번더 하기.
public class Main {

    public static int max;
    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};

    public static void dfs(int[][] arr, boolean[][] check, int cnt, int currX, int currY, int sum){
        if(cnt == 4){
            max = Math.max(max, sum);
        }
        else{
            for(int i = 0; i < 4; i++){
                int nextX = currX + dirX[i];
                int nextY = currY + dirY[i];

                if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;
                if(check[nextY][nextX]) continue;

                if(cnt == 2){
                    check[nextY][nextX] = true;
                    dfs(arr, check, cnt + 1, currX, currY, sum + arr[nextY][nextX]);
                    check[nextY][nextX] = false;
                }

                check[nextY][nextX] = true;
                dfs(arr, check, cnt + 1, nextX, nextY, sum + arr[nextY][nextX]);
                check[nextY][nextX] = false;
            }
        }
    }

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
        boolean[][] check = new boolean[row][col];

        max = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                check[i][j] = true;
                dfs(arr, check, 1, j, i, arr[i][j]);
                check[i][j] = false;
            }
        }

        System.out.println(max);
    }
}