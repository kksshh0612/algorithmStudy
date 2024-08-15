import java.util.*;

// 몇개의 영역이 있는지, 가장 큰 영역 크기는 몇인지
class Solution {
    
    public static int cnt, max, currArea;
    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};
    public static boolean[][] check;
    public static int rowSize, colSize;
    
    public static void dfs(int row, int col, int[][] picture, int currNum){
        
        for(int i = 0; i < 4; i++){
            int nextRow = row + dirRow[i];
            int nextCol = col + dirCol[i];
            
            if((nextRow < 0 || nextRow >= rowSize) || (nextCol < 0 || nextCol >= colSize)) continue;
            if(check[nextRow][nextCol]) continue;
            
            if(picture[nextRow][nextCol] == currNum){
                check[nextRow][nextCol] = true;
                currArea++;
                dfs(nextRow, nextCol, picture, currNum);
            }
        }
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        rowSize = picture.length;
        colSize = picture[0].length;

        check = new boolean[rowSize][colSize];
        cnt = 0;
        max = 0;
        
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                if(check[i][j] || picture[i][j] == 0) continue;           // 이미 방문했으면 건너뜀
                
                currArea = 1;
                check[i][j] = true;
                dfs(i, j, picture, picture[i][j]);
                cnt++;
                max = Math.max(max, currArea);
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea = cnt;
        answer[1] = maxSizeOfOneArea = max;
        
        return answer;
    }
}