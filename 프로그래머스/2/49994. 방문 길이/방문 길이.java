import java.util.*;
// 처음 걸어본 길 수 세기
// 좌표 넘어가면 무시
class Solution {
    
    public static int[] dirRow = {-1, 1, 0, 0};     // UDRL
    public static int[] dirCol = {0, 0, 1, -1};
    
    public static class Pos{
        int row, col;
        public Pos(int r, int c){
            this.row = r;
            this.col = c;
        }
    }
    
    // 각 위치에 연결된 위치 리스트 저장
    public static List<Pos>[][] connectedPosArr = new ArrayList[11][11];
    
    // 이미 거쳐간 길인지 확인
    public static boolean isConnected(int startRow, int startCol, int targetRow, int targetCol){
        List<Pos> currList = connectedPosArr[targetRow][targetCol];
        
        for(Pos pos : currList){
            if(pos.row == startRow && pos.col == startCol) return true;
        }
        return false;
    }
    
    public int solution(String dirs) {
        int answer = 0;
        
        // 초기 값 세팅
        int row = 5, col = 5;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                connectedPosArr[i][j] = new ArrayList<>();
            }
        }
        
        // 시작
        for(int i = 0; i < dirs.length(); i++){
            char dir = dirs.charAt(i);
            int dirIdx = 0;
            
            switch(dir){
                case 'U' : {
                    dirIdx = 0;
                    break;
                }
                    case 'D' : {
                    dirIdx = 1;
                    break;
                }
                    case 'R' : {
                    dirIdx = 2;
                    break;
                }
                    case 'L' : {
                    dirIdx = 3;
                    break;
                }
            }
            
            int nextRow = row + dirRow[dirIdx];
            int nextCol = col + dirCol[dirIdx];
            
            // 범위 벗어나면 다음으로
            if((nextRow < 0 || nextRow > 10) || (nextCol < 0 || nextCol > 10)) continue;
            
            // 이미 거쳐간 길인지 확인 -> 이미 거쳐간 길이 아니면 길 넣고 answer++
            if(!isConnected(row, col, nextRow, nextCol)){
                connectedPosArr[nextRow][nextCol].add(new Pos(row, col));
                connectedPosArr[row][col].add(new Pos(nextRow, nextCol));
                answer++;
            }
            
            row = nextRow;
            col = nextCol;
        }
        
        return answer;
    }
}