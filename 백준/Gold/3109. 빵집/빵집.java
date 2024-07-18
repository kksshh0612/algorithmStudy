import java.util.Scanner;

// 왼쪽->오른쪽 파이프 놓을건데, 겹치면 안됨.
// 가스관과 빵집을 연결하는 파이프 최대 갯수
public class Main {

    public static int[] dirRow = {-1, 0, 1};
    public static int[] dirCol = {1, 1, 1};

    public static boolean dfs(char[][] arr, boolean[][] check, int currRow, int currCol){
        for(int i = 0; i < 3; i++){
            int nextRow = currRow + dirRow[i];
            int nextCol = currCol + dirCol[i];

            if((nextRow < 0 || nextRow >= arr.length) || (nextCol < 0 || nextCol >= arr[0].length)) continue;
            if(check[nextRow][nextCol]) continue;
            if(arr[nextRow][nextCol] == 'x') continue;

            check[nextRow][nextCol] = true;

            if(nextCol == arr[0].length-1) return true;
            if(dfs(arr, check, nextRow, nextCol)) return true;
        }
        return false;       // 아무데도 갈 데 없음.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        char[][] arr = new char[row][col];
        for(int i = 0; i < row; i++){
            String input = scanner.next();
            for(int j = 0; j < col; j++){
                arr[i][j] = input.charAt(j);
            }
        }

        boolean[][] check = new boolean[row][col];

        int ans = 0;

        for(int i = 0 ; i < row; i++){
            if(dfs(arr, check, i, 0)) ans++;
        }

        System.out.println(ans);
    }
}