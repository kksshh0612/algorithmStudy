import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 8X8 체스판 만들건데, 적당히 잘라서 다시 칠해야 하는 사각형의 갯수
// 체스판 두개 만들어놓고, 비교하면서 틀린거 갯수 찾고, 최소인거 고르기
public class Main{

    public static int check(char[][] arr, char[][] whiteFirst, char[][] blackFirst,
                            int startRow, int startCol){

        int whiteCnt = 0, blackCnt = 0;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                if(whiteFirst[i][j] != arr[startRow + i][startCol + j]){
                    whiteCnt++;
                }
                if(blackFirst[i][j] != arr[startRow + i][startCol + j]){
                    blackCnt++;
                }
            }
        }

        return Math.min(whiteCnt, blackCnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        char[][] arr = new char[row][col];
        for(int i = 0; i < row; i++){
            String str = bufferedReader.readLine();
            for(int j = 0; j < col; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        char[][] whiteFirst = {
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'}
        };
        char[][] blackFirst = {
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'},
                {'B','W','B','W','B','W','B','W'},
                {'W','B','W','B','W','B','W','B'}
        };
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i <= row - 8; i++){
            for(int j = 0; j <= col - 8; j++){
                int cnt = check(arr, whiteFirst, blackFirst, i, j);
                ans = Math.min(ans, cnt);
            }
        }

        System.out.println(ans);
    }
}