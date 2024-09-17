import java.util.*;
import java.io.*;

// 모든 위치에서 십자가 놓을 수 있는지 확인. 십자가 모든 자리가 별이면 십자가 놓고 true 처리
// 십자가 크기는 가로 세로가 최대일 때까지 늘어남
public class Main {

    public static class Cross{
        int row, col, level;
        public Cross(int r, int c, int l){
            this.row = r;
            this.col = c;
            this.level = l;
        }
    }

    public static class Pos{
        int row, col;
        public Pos(int r, int c){
            this.row = r;
            this.col = c;
        }
    }

    public static int row, col;
    public static char[][] arr;
    public static List<Cross> ans;
    public static boolean[][] putted;

    // 십자가 놓을 수 있는지 확인 currRow와 currCol은 십자가 중심
    public static void check(int currRow, int currCol, int level){
        List<Pos> pointList = new ArrayList<>();        // 별인 위치

        if(!putted[currRow][currCol] && arr[currRow][currCol] == '*'){
            pointList.add(new Pos(currRow, currCol));
        }
        else if(arr[currRow][currCol] == '.') return;

        for(int i = 1; i <= level; i++){
            if(!putted[currRow - i][currCol] && arr[currRow - i][currCol] == '*') {
                pointList.add(new Pos(currRow - i, currCol));
            }
            else if(arr[currRow - i][currCol] == '.') return;

            if(!putted[currRow][currCol + i] && arr[currRow][currCol + i] == '*') {
                pointList.add(new Pos(currRow, currCol + i));
            }
            else if(arr[currRow][currCol + i] == '.') return;

            if(!putted[currRow + i][currCol] && arr[currRow + i][currCol] == '*') {
                pointList.add(new Pos(currRow + i, currCol));
            }
            else if(arr[currRow + i][currCol] == '.') return;

            if(!putted[currRow][currCol - i] && arr[currRow][currCol - i] == '*') {
                pointList.add(new Pos(currRow, currCol - i));
            }
            else if(arr[currRow][currCol - i] == '.') return;
        }

        put(pointList);
        if(!pointList.isEmpty()){
            ans.add(new Cross(currRow, currCol, level));
        }
    }

    // 십자가 놓기
    public static void put(List<Pos> list){
        for(Pos pos : list){
            if(!putted[pos.row][pos.col]){
                putted[pos.row][pos.col] = true;
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        // 입력
        row = sc.nextInt();
        col = sc.nextInt();
        arr = new char[row][col];
        for(int i = 0; i < row; i++){
            String str = sc.next();
            for(int j = 0; j < col; j++){
                arr[i][j] = str.charAt(j);
            }

        }
        ans = new ArrayList<>();
        putted = new boolean[row][col];

        // 십자가 한 변의 최대 길이
        int minLen = Math.min(row, col);
        int maxCrossSize = minLen % 2 == 0 ? minLen - 1 : minLen;

        int currCrossLevel = 1;
        // 십자가 1부터 탐색 3, 5, 7...
        while(currCrossLevel * 2 + 1  <= maxCrossSize){

            for(int i = currCrossLevel; i < row - currCrossLevel; i++){
                for(int j = currCrossLevel; j < col - currCrossLevel; j++){
                    check(i, j, currCrossLevel);
                }
            }
            currCrossLevel++;         // 다음 크기 십자가로
        }

        boolean isClear = true;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(arr[i][j] == '*' && !putted[i][j]){
                    isClear = false;
                }
            }
        }

        // 정답 출력
        StringBuilder ansBuilder = new StringBuilder();
        if(!isClear){
            ansBuilder.append(-1).append("\n");
        }
        else{
            ansBuilder.append(ans.size()).append("\n");
            for(Cross cross : ans){
                ansBuilder.append(cross.row + 1).append(" ").append(cross.col + 1).append(" ").append(cross.level).append("\n");
            }
        }
        
        System.out.println(ansBuilder);
    }
}