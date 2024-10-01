import java.util.*;
// 연결된 곳 숫자 더해서 저장하고 오름차순 -> BFS
class Solution {
    
    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};
    public static int[][] arr;
    
    public static class Pos{
        int row, col;
        public Pos(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    
    public static int bfs(int row, int col, boolean[][] check){
        Queue<Pos> queue = new LinkedList<>();
        
        int sum = arr[row][col];
        check[row][col] = true;
        queue.add(new Pos(row, col));
        
        while(!queue.isEmpty()){
            Pos currPos = queue.poll();
            
            if((currPos.row < 0 || currPos.row >= arr.length) || 
                   (currPos.col < 0 || currPos.col >= arr[0].length)) continue;   
            
            for(int i = 0; i < 4; i++){
                int nextRow = currPos.row + dirRow[i];
                int nextCol = currPos.col + dirCol[i];
            
                if((nextRow < 0 || nextRow >= arr.length) || 
                   (nextCol < 0 || nextCol >= arr[0].length)) continue;   
                if(arr[nextRow][nextCol] == -1) continue;
                if(check[nextRow][nextCol]) continue;
            
                queue.add(new Pos(nextRow, nextCol));
                check[nextRow][nextCol] = true;
                sum += arr[nextRow][nextCol];
            }
        }
        
        return sum;
    }
    
    public List<Integer> solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        
        // arr에 값 세팅. X는 -1로 세팅
        arr = new int[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                char token = maps[i].charAt(j);
                
                if(token == 'X'){
                    arr[i][j] = -1;
                }
                else{
                    arr[i][j] = token - '0';
                }
            }
        }
        
        boolean[][] check = new boolean[arr.length][arr[0].length];
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                if(arr[i][j] != -1 && !check[i][j]){
                    int sum = bfs(i, j, check);
                    
                    answer.add(sum);
                }
            }
        }
        
        Collections.sort(answer);
        
        if(answer.isEmpty()) answer.add(-1);
        
        return answer;
    }
}