import java.util.*;

// 배열을 하나 더 생성해서 지울 부분 체크.
// 
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] arr = new char[m][n];
        boolean[][] remove = new boolean[m][n];     // 지울 칸
        
        int idx = 0;
        for(String b : board){
            arr[idx++] = b.toCharArray();
        }
        
        while(true){
            int cnt = 0;        // 이번 턴에 삭제되는 갯수
            
            // 지울 칸 찾아서 표시
            for(int i = 0; i < m - 1; i++){
                for(int j = 0; j < n - 1; j++){
                    char curr = arr[i][j];
                    
                    if(curr == '!') continue;       // 이미 삭제된 칸임
                    
                    // 정사각형 모양 모두 같으면
                    if(arr[i][j + 1] == curr && arr[i + 1][j + 1] == curr && arr[i + 1][j] == curr){
                        remove[i][j] = true;
                        remove[i][j + 1] = true;
                        remove[i + 1][j] = true;
                        remove[i + 1][j + 1] = true;
                    }
                }
            }

            
            // 이번 턴에 지워야 되는 값들 삭제 처리
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){ 
                    if(remove[i][j]){
                        arr[i][j] = '!';
                        remove[i][j] = false;
                        cnt++;
                    } 
                }
            }
            
            // 아래로 내리기 (!와 바꿔주기)
            for(int i = m - 2; i >= 0; i--){
                for(int j = 0; j < n; j++){ 
                    if(arr[i][j] == '!') continue;
                    
                    int row = i;
                    while(row < m - 1 && arr[row + 1][j] == '!'){
                        char tmp = arr[row][j];
                        arr[row][j] = arr[row + 1][j];
                        arr[row + 1][j] = tmp;
                        row++;
                    }
                   
                }
            }
            if(cnt == 0) break;
            answer += cnt;
 
            
        }
        

        
        return answer;
    }
}