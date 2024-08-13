import java.util.*;
import java.io.*;
// 치즈가 모두 녹는데 걸리는 시간, 모두 녹기 한시간 전에 남아있던 수 구하기
// 빈 곳은 -1로 초기화. 한번 녹을때마다 추가적인 빈 곳 있는지 확인하기
public class Main {

    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};
    public static int time;

    public static class Pos{
        int row, col;
        public Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void bfs(int[][] arr, int total){
        int row = arr.length;
        int col = arr[0].length;
        time++;

        Queue<Pos> queue = new LinkedList<>();
        boolean[][] check = new boolean[row][col];
        Pos start = new Pos(0, 0);
        queue.add(start);
        check[start.row][start.col] = true;

        int cnt = 0;

        while(!queue.isEmpty()){
            Pos curr = queue.poll();

            for(int i = 0; i < 4; i++){
                int nextRow = curr.row + dirRow[i];
                int nextCol = curr.col + dirCol[i];

                if((nextRow < 0 || nextRow >= row) || (nextCol < 0 || nextCol >= col)) continue;
                if(check[nextRow][nextCol]) continue;

                if(arr[nextRow][nextCol] == 0){
                    queue.add(new Pos(nextRow, nextCol));
                }
                else{
                    arr[nextRow][nextCol] = 0;
                    cnt++;
                }
                check[nextRow][nextCol] = true;
            }
        }
        total -= cnt;
        if(total == 0){
            System.out.println(time);
            System.out.println(cnt);
        }
        else{
            bfs(arr, total);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        int total = 0;
        for(int i = 0; i < row; i++){
            st = new StringTokenizer(bf.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) total++;
            }
        }
        time = 0;
        bfs(arr,total);
    }
}