import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 0,0 에서 n-1,n-1까지 가는데 도둑루피 만나면 소지금 - 됨.
// 잃는 금액의 최소값 구하기 -> 합의 최솟값 구하기 -> 다익스트라
// 현재 위치 -> 다음 위치 탐색할 때, 더 작으면 큐에 넣음.
//public class Boj4485 {
public class Main {
    public static class Pos{
        int x, y;
        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};

    public static void BFS(int[][] arr, int[][] dp){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(0, 0));
        dp[0][0] = arr[0][0];

        while(!queue.isEmpty()){
            Pos curr = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextX = curr.x + dirX[i];
                int nextY = curr.y + dirY[i];

                if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;

                if(dp[curr.y][curr.x] + arr[nextY][nextX] < dp[nextY][nextX]){
                    queue.add(new Pos(nextX, nextY));
                    dp[nextY][nextX] = dp[curr.y][curr.x] + arr[nextY][nextX];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        while(true){
            idx++;

            int size = Integer.parseInt(bufferedReader.readLine());

            if(size == 0) break;

            int[][] arr = new int[size][size];
            int[][] dp = new int[size][size];

            for(int i = 0; i < size; i++){
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for(int j = 0; j < size; j++){
                    arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            BFS(arr, dp);

            System.out.println("Problem " + idx + ": " + dp[size - 1][size - 1]);
        }

    }
}
