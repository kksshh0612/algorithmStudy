import java.util.*;
import java.io.*;

public class Main {

    public static char[][] map = new char[5][5];
    public static boolean[][] check = new boolean[5][5];
    public static List<Pos> initList = new ArrayList<>();
    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};
    public static int ans = 0;

    public static class Pos{
        int row, col;
        public Pos(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    // 25개에서 7개 뽑기 (조합)
    public static void dfs(int total, List<Pos> list, int sCnt, int currIdx){
        if(total == 7){
            if(sCnt < 4) return;
            if(isConnected(list)) ans++;
        }
        else{
            for(int i = currIdx; i < 25; i++){
                Pos curr = initList.get(i);

                if(check[curr.row][curr.col]) continue;
                check[curr.row][curr.col] = true;
                list.add(curr);
                if(map[curr.row][curr.col] == 'S'){
                    dfs(total + 1, list, sCnt + 1, i + 1);
                }
                else{
                    dfs(total + 1, list, sCnt, i + 1);
                }
                check[curr.row][curr.col] = false;
                list.remove(curr);
            }
        }
    }

    // 7개가 연결돼있는지 확인
    public static boolean isConnected(List<Pos> list){
        boolean[][] checkMap = new boolean[5][5];
        for(Pos pos : list){
            checkMap[pos.row][pos.col] = true;
        }

        Queue<Pos> queue = new LinkedList<>();
        queue.add(list.get(0));

        int findCnt = 1;
        while(!queue.isEmpty()){
            Pos curr = queue.poll();

//            if(!checkMap[curr.row][curr.col]) continue;
            checkMap[curr.row][curr.col] = false;
            for(int i = 0; i < 4; i++){
                int nextRow = curr.row + dirRow[i];
                int nextCol = curr.col + dirCol[i];

                if((nextRow < 0 || nextRow >= 5) || (nextCol < 0 || nextCol >= 5)) continue;
                if(!checkMap[nextRow][nextCol]) continue;

                queue.add(new Pos(nextRow, nextCol));
                checkMap[nextRow][nextCol] = false;
                findCnt++;
            }
        }

        if(findCnt == 7) return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++){
            String line = sc.next();
            for(int j = 0; j < 5; j++){
                map[i][j] = line.charAt(j);
                initList.add(new Pos(i, j));
            }
        }

        dfs(0, new ArrayList<>(), 0, 0);

        System.out.println(ans);
    }
}