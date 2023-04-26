import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[][] arr = new boolean[n + 1][n + 1];
        int[] roadLen = new int[n + 1];
        for(int i = 0; i < edge.length; i++){           //양방향 엣지 
            arr[edge[i][0]][edge[i][1]] = true;
            arr[edge[i][1]][edge[i][0]] = true;
        }
        
        roadLen[1] = 0;
        for(int i = 2; i <= n; i++){
            roadLen[i] = Integer.MAX_VALUE;
            if(arr[1][i] == true){
                queue.add(i);
                roadLen[i] = roadLen[1] + 1;
            }
        }
        
        while(!queue.isEmpty()){
            int currVtx = queue.poll();
            
            for(int i = 1; i <= n; i++){
                if(arr[currVtx][i] == true){
                    if(roadLen[currVtx] + 1 < roadLen[i]){
                        roadLen[i] = roadLen[currVtx] + 1;
                        queue.add(i);
                    }
                }
            }
        }
        
        
        Arrays.sort(roadLen);

        int maxLen = roadLen[roadLen.length - 1];       //젤 멀리 있는 정점의 거리
        
        for(int i = 1; i <= n; i++){
            if(roadLen[i] == maxLen) answer++;
        }
        
        return answer;
    }
}