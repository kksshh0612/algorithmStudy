import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 익은 토마토 주변 토마토가 다음날 익음. 며칠이 지나야 모두 익는지 최소 일수 계산.
// 1 : 익은 토마토     0 : 안익은 토마토    -1 : 토마토 없음
public class Main{

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};
    public static int cnt;

    public static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int[][] arr, Queue<Pos> already){
        int currTurnSize = already.size();;

        while(currTurnSize-- > 0){
            Pos curr = already.poll();

            for(int i = 0; i < 4; i++){
                int nextX = curr.x + dirX[i];
                int nextY = curr.y + dirY[i];

                if((nextX >= 0 && nextX < arr[0].length) && (nextY >= 0 && nextY < arr.length)){
                    if(arr[nextY][nextX] == 0){
                        arr[nextY][nextX] = 1;
                        already.add(new Pos(nextX, nextY));
                        cnt++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];

        int notYet = 0;     //안익은 것의 수
        Queue<Pos> already = new LinkedList<>();        //익은 것들의 위치

        for(int i = 0; i < row; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < col; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(arr[i][j] == 0) notYet++;
                else if(arr[i][j] == 1){
                    already.add(new Pos(j, i));
                }
            }
        }

        int days = -1;
        while(!already.isEmpty()){
            days++;
            BFS(arr, already);
        }

        if(cnt != notYet) System.out.println(-1);
        else System.out.println(days);
    }

}