import java.util.*;
// 시작부터 레버까지 가는 거리 + 레버부터 끝까지 가는 거리 -> 다익스트라
class Solution {
    
    public static char[][] arr;
    public static int[] dirRow = {-1, 0, 1, 0};
    public static int[] dirCol = {0, 1, 0, -1};
    public static int rowSize, colSize;
    
    public static class Pos{
        int row, col;
        public Pos(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    
    // 시작 위치부터 끝 위치까지 거리 반환
    public static int bfs(Pos startPos, Pos endPos){
        Queue<Pos> queue = new LinkedList<>();
        queue.add(startPos);
        
        int[][] distance = new int[rowSize][colSize];
        for(int i = 0; i < rowSize; i++){
            for(int j = 0; j < colSize; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[startPos.row][startPos.col] = 0;
        
        int currDistance = 1;
        while(!queue.isEmpty()){
            // 큐 사이즈만큼 반복 -> 이번 사이클임
            int currTurnSize = queue.size();
            
            while(currTurnSize-- > 0){
                Pos currPos = queue.poll();
                
                for(int i = 0; i < 4; i++){
                    int nextRow = currPos.row + dirRow[i];
                    int nextCol = currPos.col + dirCol[i];
                    
                    if((nextRow < 0 || nextRow >= rowSize) 
                        || (nextCol < 0 || nextCol >= colSize)) continue;
                
                    if(arr[nextRow][nextCol] == 'X') continue;
                
                    if(currDistance < distance[nextRow][nextCol]){
                        distance[nextRow][nextCol] = currDistance;
                        queue.add(new Pos(nextRow, nextCol));
                    }
                }
            }
            currDistance++;
        }
        
        return distance[endPos.row][endPos.col];
    }
    
    public int solution(String[] maps) {
        int answer = 0;
        
        Pos startPos = new Pos(0, 0); 
        Pos leverPos = new Pos(0, 0);
        Pos endPos = new Pos(0, 0);
        
        arr = new char[maps.length][maps[0].length()];
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                arr[i][j] = maps[i].charAt(j);
                if(arr[i][j] == 'S'){
                    startPos.row = i;
                    startPos.col = j;
                }
                else if(arr[i][j] == 'L'){
                    leverPos.row = i;
                    leverPos.col = j;
                }
                else if(arr[i][j] == 'E'){
                    endPos.row = i;
                    endPos.col = j;
                }
            }
        }
        rowSize = maps.length;
        colSize = maps[0].length();
        
        // 시작 -> 레버
        int LeverDistance = bfs(startPos, leverPos);
        if(LeverDistance == Integer.MAX_VALUE){
            answer = -1;
        }
        else{       // 레버 -> 출구
            answer += LeverDistance;
            
            int exitDistance = bfs(leverPos, endPos);
            
            if(exitDistance == Integer.MAX_VALUE){
                answer = -1;
            }
            else{
                answer += exitDistance;
            }
        }
        
        
        return answer;
    }
}