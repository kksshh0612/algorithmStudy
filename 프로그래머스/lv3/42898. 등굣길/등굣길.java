import java.util.*;
//현재 위치의 왼쪽, 위쪽 탐색하면서 가짓수 더하기 
class Solution {
    
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int num = 1000000007;
        int[][] dt = new int[n + 1][m + 1]; 

        dt[1][1] = 1;
        
        for(int i = 0; i < puddles.length; i++) {
            dt[puddles[i][1]][puddles[i][0]] = -1; 
        }
        
        for(int i = 1; i <= n; i++){        //y좌표
            for(int j = 1; j <= m; j++){     //x좌표

                if(dt[i][j] == -1) continue;
             
                if(dt[i - 1][j] > 0){     //위쪽이 범위 밖이거나 물웅덩이가 아니면
                    dt[i][j] += dt[i - 1][j] % num;      //위쪽의 값 더함
                }
                if(dt[i][j - 1] > 0){       //왼쪽이 범위 밖이거나 물웅덩이가 아니면
                    dt[i][j] += dt[i][j - 1] % num;      //왼쪽의 값 더함
                }
                
            }
        }
        
        answer = dt[n][m] % num;
        
        
        return answer;
    }
}


