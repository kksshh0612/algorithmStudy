import java.util.*;

class Solution {
    
    
    public static class Pos{
        int row, col;
        
        public Pos(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};
    public static int[] oil;
    
    public static void bfs(int[][] land, int startRow, int startCol, boolean[][] check){
        
        int row = land.length;
        int col = land[0].length;
        int sum = 1;
        
        Queue<Pos> queue = new LinkedList<>();
        queue.add(new Pos(startRow, startCol));
        check[startRow][startCol] = true;
        
        int oilStart = Integer.MAX_VALUE;
        int oilEnd = Integer.MIN_VALUE;
        
        while(!queue.isEmpty()){
            Pos curr = queue.poll();
            
            if(curr.col <= oilStart) oilStart = curr.col;
            if(curr.col >= oilEnd) oilEnd = curr.col;
            
            if((curr.row < 0 || curr.row >= row) || (curr.col < 0 || curr.col >= col)) continue;
            
            for(int i = 0; i < 4; i++){
                int nextRow = curr.row + dirRow[i];
                int nextCol = curr.col + dirCol[i];
                
                if((nextRow < 0 || nextRow >= row) || (nextCol < 0 || nextCol >= col)) continue;
                if(land[nextRow][nextCol] == 0) continue;
                if(check[nextRow][nextCol]) continue;
                
                sum++;
                queue.add(new Pos(nextRow, nextCol));
                check[nextRow][nextCol] = true;
            }
        }
        for(int i = oilStart; i <= oilEnd; i++){
            oil[i] += sum;
        }
    }
    
    public int solution(int[][] land) {
        int answer = 0;
        
        oil = new int[land[0].length];
        boolean[][] check = new boolean[land.length][land[0].length];
        
        for(int i = 0; i < land[0].length; i++){            // 열
            for(int j = 0; j < land.length; j++){           // 행
                if(!check[j][i] && land[j][i] == 1){
                    bfs(land, j, i, check);                
                }
            }
        }
        
        for(int i = 0; i < oil.length; i++){            // 열
            
            answer = Math.max(oil[i], answer);
        }
        
        
        return answer;
    }
}