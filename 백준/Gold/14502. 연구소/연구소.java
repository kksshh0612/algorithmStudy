import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 벽 3개 세워서 안전영역 최대한 많이 확보하기
// 벽을 세우는 경우 -> 완전탐색 dfs
// 벽을 모두 세운 후 바이러스가 퍼지는 것 (-1로 처리) -> 완전탐색 BFS
// 이후 0의 갯수를 세는 것 -> 2중 for문
// 중요한 점 : 위 동작이 끝나면 -1로 처리한 것들 다시 0으로 초기화 시켜야 함
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

    public static int ans;

    public static void dfs(int[][] arr, boolean[][] check, int cnt){
        if(cnt == 3){
            ans = Math.max(ans, countArea(arr, check));
        }
        else{
            for(int i = 0; i < arr.length; i++){
                for(int j = 0; j < arr[i].length; j++){
                    if(arr[i][j] == 0 && !check[i][j]){
                        check[i][j] = true;
                        dfs(arr, check, cnt + 1);
                        check[i][j] = false;
                    }
                }
            }
        }
    }

    public static int countArea(int[][] arr, boolean[][] check){
        int[][] copy = new int[arr.length][arr[0].length];

//        System.out.println("벽 위치 ");

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                if(check[i][j]){
                    copy[i][j] = 1;
//                    System.out.print(copy[i][j] + " ");
                    continue;
                }
                copy[i][j] = arr[i][j];

//                System.out.print(copy[i][j] + " ");
            }
//            System.out.println();
        }
        for(int i = 0; i < copy.length; i++){
            for(int j = 0; j < copy[i].length; j++){
                if(copy[i][j] == 2) bfs(copy, new Pos(j, i));
            }
        }

        int count = 0;
        for(int i = 0; i < copy.length; i++){
            for(int j = 0; j < copy[i].length; j++){
                if(copy[i][j] == 0) count++;
            }
        }

//        System.out.println("퍼진 후");
//        for(int i = 0; i < copy.length; i++){
//            for(int j = 0; j < copy[i].length; j++){
//                System.out.print(copy[i][j] + " ");
//            }
//            System.out.println();
//        }

        return count;
    }

    public static void bfs(int[][] arr, Pos startPos){
        Queue<Pos> queue = new LinkedList<>();
        boolean[][] check = new boolean[arr.length][arr[0].length];

        queue.add(startPos);

        while(!queue.isEmpty()){
            Pos currPos = queue.poll();
            check[currPos.y][currPos.x] = true;

            for(int i = 0; i < 4; i++){
                int nextX = currPos.x + dirX[i];
                int nextY = currPos.y + dirY[i];

                if((nextX < 0 || nextX >= arr[0].length) || (nextY < 0 || nextY >= arr.length)) continue;
                if(check[nextY][nextX]) continue;
                if(arr[nextY][nextX] != 0) continue;

                arr[nextY][nextX] = -1;
                check[nextY][nextX] = true;
                queue.add(new Pos(nextX, nextY));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int row = Integer.parseInt(stringTokenizer.nextToken());
        int col = Integer.parseInt(stringTokenizer.nextToken());
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        ans = 0;

        boolean[][] check = new boolean[arr.length][arr[0].length];

        dfs(arr, check, 0);

        System.out.println(ans);

    }
}