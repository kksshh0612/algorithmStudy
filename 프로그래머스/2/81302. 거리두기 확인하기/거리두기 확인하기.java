import java.util.*;
// 대기실 5개, 5x5
// 맨해튼 거리 2 초과로 앉아야 함. 파티션으로 막혀있으면 상관없음
class Solution {
    
    static class Pos{
        int row, col;
        public Pos(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    
    static char[][] arr = new char[5][5];
    static int[] dirRow = {-1, 0, 1, 0};
    static int[] dirCol = {0, 1, 0, -1};
    
    static boolean check;
    static void dfs(int depth, int row, int col, boolean[][] visited){
        if(depth > 1){
            return;
        }
        else{
            visited[row][col] = true;
            for(int i = 0; i < 4; i++){
                int nextRow = row + dirRow[i];
                int nextCol = col + dirCol[i];
                
                if((nextRow < 0 || nextRow >= 5) || (nextCol < 0 || nextCol >= 5)) continue;
                if(visited[nextRow][nextCol]) continue;
                if(arr[nextRow][nextCol] == 'X') continue;
                if(arr[nextRow][nextCol] == 'P') {
                    check = false;
                    return;
                }
                
                dfs(depth + 1, nextRow, nextCol, visited);
            }
        }
    }
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        int idx = 0;
        for(String[] place : places){
            ArrayList<Pos> people = new ArrayList<>();   // 사람 위치 리스트
            
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    arr[i][j] = place[i].charAt(j);
                    if(arr[i][j] == 'P'){
                        people.add(new Pos(i, j));
                    }
                }
            }
            
            check = true;
            for(Pos pos : people){
                boolean[][] visited = new boolean[5][5];
                dfs(0, pos.row, pos.col, visited);
                if(!check) break;
            }
            answer[idx++] = check ? 1 : 0;
        }
    
        return answer;
    }
}
