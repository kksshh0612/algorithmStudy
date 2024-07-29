import java.util.*;

public class Main {

    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};
    public static boolean ans;

    public static void dfs(char[][] arr, boolean[][] check,
                           int prevRow, int prevCol, int currRow, int currCol){

        for(int i = 0; i < 4; i++){
            int nextRow = currRow + dirRow[i];
            int nextCol = currCol + dirCol[i];

            if((nextRow < 0 || nextRow >= arr.length) || (nextCol < 0 || nextCol >= arr[0].length)) continue;
            if(arr[nextRow][nextCol] != arr[currRow][currCol]) continue;
            if(nextRow == prevRow && nextCol == prevCol) continue;

            if(check[nextRow][nextCol]){
                ans = true;
                return;
            }

            check[nextRow][nextCol] = true;
            dfs(arr, check, currRow, currCol, nextRow, nextCol);
            check[nextRow][nextCol] = false;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        char[][] arr = new char[row][col];
        for(int i = 0; i < row; i++){
            String str = sc.next();
            for(int j = 0; j < col; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        // 바로 직전것만 아니면 상관없음.
        boolean[][] check = new boolean[row][col];
        ans = false;

        for(int i = 0; i < row; i++){

            if(ans) break;

            for(int j = 0; j < col; j++){
                if(!check[i][j]){
                    dfs(arr, check, -1, -1, i, j);
                }

                if(ans) break;
            }
        }

        System.out.println(ans ? "Yes" : "No");

    }
}