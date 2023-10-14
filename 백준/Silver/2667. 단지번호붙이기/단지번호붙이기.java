
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//public class Boj2667 {
public class Main {
    public static int[] dirX = {0, 1, 0, -1};     //행렬에서 열.   북동남서
    public static int[] dirY = {-1, 0, 1, 0};     //행렬에서 행.   북동남서
    public static int cnt;

    public static void DFS(int[][] map, boolean[][] isVisited, int currX, int currY){
        isVisited[currY][currX] = true;

        for(int i = 0; i < 4; i++){
            int nextX = currX + dirX[i];
            int nextY = currY + dirY[i];
            if((nextX >= 0 && nextX < map.length) && (nextY >= 0 && nextY < map.length))
            if(!isVisited[nextY][nextX] && map[nextY][nextX] != 0){
                cnt++;
                DFS(map, isVisited, nextX, nextY);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[][] map = new int[size][size];
        boolean[][] isVisited = new boolean[size][size];
        for(int i = 0; i < size; i++){
            String token = bufferedReader.readLine();
            for(int j = 0; j < token.length(); j++){
                map[i][j] = token.charAt(j) - '0';
            }
        }
        List<Integer> ans = new ArrayList<>();


        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(!isVisited[i][j] && map[i][j] != 0){
                    cnt = 1;
                    DFS(map, isVisited, j, i);
//                    System.out.println(cnt);
                    ans.add(cnt);
                }
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for(Integer answer : ans){
            System.out.println(answer);
        }
    }
}
