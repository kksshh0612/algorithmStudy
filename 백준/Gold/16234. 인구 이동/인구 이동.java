import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// L <= 인구 차이 <= R 이면 인구 이동 (총 인구수 / 연합 수)
// 위 매커니즘 반복 -> 총 며칠 인구이동 일어나는지
// BFS로 인구이동 일어날 수 있는 칸들 탐색한 후, 인구이동 시키기
//public class Boj16234 {
public class Main {
    public static int[] dirX = {0, 1, 0, -1};   //북동남서
    public static int[] dirY = {-1, 0, 1, 0};

    public static class Pos{
        int x;
        int y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static boolean BFS(Queue<Pos> queue, boolean[][] check, int[][] arr, int L, int R){
        int sum = 0;
        List<Pos> currUnion = new ArrayList<>();

        while(!queue.isEmpty()){
            Pos currPos = queue.poll();
            int currX = currPos.x;
            int currY = currPos.y;

            for(int i = 0; i < 4; i++){
                int nextX = currX + dirX[i];
                int nextY = currY + dirY[i];
                if((nextX >= 0 && nextX < arr.length) && (nextY >= 0 && nextY < arr.length)){
                    if(!check[nextY][nextX]){
                        int div = Math.abs(arr[currY][currX] - arr[nextY][nextX]);      //차
                        if(div >= L && div <= R){
                            queue.add(new Pos(nextX, nextY));
                            check[nextY][nextX] = true;
                            sum += arr[nextY][nextX];
                            currUnion.add(new Pos(nextX, nextY));
                        }
                    }
                }
            }
        }
        // 인구 이동이 일어났으면
        if(currUnion.size() >= 2){
            int unitedNum = sum / currUnion.size();     // 인구 이동 후 인구 수
            for(Pos pos : currUnion){
                arr[pos.y][pos.x] = unitedNum;
            }
            return true;
        }
        else return false;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());       //한 변의 길이
        int L = Integer.parseInt(stringTokenizer.nextToken());
        int R = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[size][size];
        for(int i = 0; i < size; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        int day = 0;
        Queue<Pos> queue = new LinkedList<>();

        // 인구 이동 더 이상 일어나지 않을 때까지
        while(true){
            boolean areTheyUnited = false;
            boolean[][] check = new boolean[size][size];

            for(int i = 0; i < size; i++){
                for(int j = 0; j < size; j++){
                    if(check[i][j] == false){
                        queue.add(new Pos(j, i));
                        if(BFS(queue, check, arr, L, R)) {
                            areTheyUnited = true;
                        }
                    }
                }
            }
            if(areTheyUnited){
                day++;
            }
            else break;
        }

        System.out.println(day);
    }
}
