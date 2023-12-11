import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


// 불이 동서남북으로 번짐. 불이 붙었거나, 다음에 붙을 칸을 못감. 최대한 빨리 탈출하는 시간
public class Main {

    public static class Pos{
        int x, y;
        Pos(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static int[] dirX = {0, 1, 0, -1};
    public static int[] dirY = {-1, 0, 1, 0};
    public static int row, col;
    public static char[][] map;
    public static boolean[][] alreadyFired;

    public static boolean isInRange(int currX, int currY){
        if((currX >= 0 && currX < col) &&(currY >= 0 && currY < row)) return true;
        else return false;
    }

    public static void fireSpread(Queue<Pos> firePos){

        int currTurnSize = firePos.size();

        while(currTurnSize-- > 0){

            Pos pos = firePos.poll();

            for(int i = 0; i < 4; i++){
                int nextX = pos.x + dirX[i];
                int nextY = pos.y + dirY[i];

                if(isInRange(nextX, nextY) && (!alreadyFired[nextY][nextX] && map[nextY][nextX] != '#')){
                    alreadyFired[nextY][nextX] = true;
                    map[nextY][nextX] = '*';
                    firePos.add(new Pos(nextX, nextY));
                }
            }
        }
    }

    public static int BFS(Queue<Pos> queue, int currCnt, boolean[][] check){

        int currTurnSize = queue.size();        //이번 턴에 확인할 위치

        boolean isEnd = true;
        while(currTurnSize-- > 0) {

            Pos currPos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = currPos.x + dirX[i];
                int nextY = currPos.y + dirY[i];

                if(isInRange(nextX, nextY)) {
                    if (!check[nextY][nextX] && map[nextY][nextX] == '.') {
                        check[nextY][nextX] = true;
                        queue.add(new Pos(nextX, nextY));
                        isEnd = false;
                    }
                }
                else{
                    queue.clear();
                    return currCnt + 1;
                }
            }
        }

        if(isEnd) return -1;

        return currCnt + 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(bufferedReader.readLine());

        while(tCase-- > 0){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            col = Integer.parseInt(stringTokenizer.nextToken());
            row = Integer.parseInt(stringTokenizer.nextToken());

            map = new char[row][col];
            alreadyFired = new boolean[row][col];
            int startX = 0, startY = 0;                 // 상근 시작 위치
            Queue<Pos> firePos = new LinkedList<>();

            for(int i = 0; i < row; i++){
                String str = bufferedReader.readLine();
                for(int j = 0; j < col; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '@'){
                        startX = j;
                        startY = i;
                        map[i][j] = '.';
                    }
                    else if(map[i][j] == '*'){
                        alreadyFired[i][j] = true;
                        firePos.add(new Pos(j, i));
                    }
                }
            }
            boolean[][] check = new boolean[row][col];

            Queue<Pos> queue = new LinkedList<>();
            queue.add(new Pos(startX, startY));

            int cnt = 0;
            while(!queue.isEmpty()){

                fireSpread(firePos);

                cnt = BFS(queue, cnt, check);
            }

            if(cnt == -1) System.out.println("IMPOSSIBLE");
            else System.out.println(cnt);

        }
    }
}
