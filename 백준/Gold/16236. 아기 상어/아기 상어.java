import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 처음 상어 크기 2
// 크기가 작은 물고기는 먹을 수 있음. 같으면 지나갈수 있음
// 가장 가까운 먹을 수 있는 물고기부터 먹음. 거리 같으면 위, 왼 순
// 자신의 현재 크기만큼 물고기 먹으면 크기 + 1
// 더이상 먹을 물고기 없으면 끝. 이동거리 출력
public class Main {

    public static int[] dirX = {0, 1, 0, -1};       //북동남서
    public static int[] dirY = {-1, 0, 1, 0};

    public static int shark, eatCnt, distance;  // 상어 크기, 먹은 수, 이동 거리

    public static class Pos{
        int x, y;

        public Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static Pos search(int[][] arr, Pos startPos){
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[arr.length][arr[0].length];

        queue.add(startPos);
        isVisited[startPos.y][startPos.x] = true;

        int currDistanceCnt = 0;
        while(!queue.isEmpty()){
            int currTurnSize = queue.size();
            currDistanceCnt++;

            PriorityQueue<Pos> canMovePos = new PriorityQueue<>(new Comparator<Pos>() {
                @Override
                public int compare(Pos o1, Pos o2) {
                    if(o1.y != o2.y) return o1.y - o2.y;
                    return o1.x - o2.x;
                }
            });

            while(currTurnSize-- > 0){
                Pos currPos = queue.poll();

                for(int i = 0; i < 4; i++){
                    int nextX = currPos.x + dirX[i];
                    int nextY = currPos.y + dirY[i];

                    if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;
                    if(isVisited[nextY][nextX]) continue;
                    if(arr[nextY][nextX] > shark) continue;     // 상어보다 큰 물고기면 지나침

                    isVisited[nextY][nextX] = true;
                    queue.add(new Pos(nextX, nextY));

                    if(arr[nextY][nextX] != 0 && arr[nextY][nextX] < shark){
                        canMovePos.add(new Pos(nextX, nextY));
                    }
                }
            }
            if(!canMovePos.isEmpty()){

                Pos eatPos = canMovePos.poll();

                arr[eatPos.y][eatPos.x] = 0;
                eatCnt++;
                distance += currDistanceCnt;

                return eatPos;
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[size][size];
        Pos currPos = null;
        for(int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(arr[i][j] == 9){
                    currPos = new Pos(j, i);
                    arr[i][j] = 0;
                }
            }
        }
        shark = 2;
        eatCnt = 0;
        distance = 0;
        
        while(true){
            Pos sharkPos = search(arr, currPos);
            if(sharkPos == null) break;

            if(eatCnt == shark){
                shark++;
                eatCnt = 0;
            }

            currPos = sharkPos;
        }

        System.out.println(distance);

    }
}