import java.util.*;
//경로의 최댓값. 최댓값 저장하면서 내려오기 
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        ArrayList<Integer>[] dt = new ArrayList[triangle.length];
        for(int i = 0; i < dt.length; i++){
            dt[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < triangle.length; i++){
            for(int j = 0; j < triangle[i].length; j++){
                dt[i].add(triangle[i][j]);
            }
        }
        
        for(int i = 0; i < triangle.length - 1; i++){
            for(int j = 0; j < i + 1; j++){
                if(dt[i].get(j) + triangle[i + 1][j] > dt[i + 1].get(j)){
                    dt[i + 1].set(j, dt[i].get(j) + triangle[i + 1][j]);
                }
                if(dt[i].get(j) + triangle[i + 1][j + 1] >  dt[i + 1].get(j + 1)){
                    dt[i + 1].set(j + 1, dt[i].get(j) + triangle[i + 1][j + 1]);
                }
            }   
        }
        Collections.sort(dt[triangle.length - 1], Comparator.reverseOrder());
        
        answer = dt[triangle.length - 1].get(0);
        
        return answer;
    }
}