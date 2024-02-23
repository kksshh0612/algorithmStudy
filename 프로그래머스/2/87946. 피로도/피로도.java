// 최소 필요 피로도, 소모 피로도 
// 정렬? 로는 알수없음. 완전탐색으로 해야됨
class Solution {
    
    public static int max;
    
    public static void calc(int[] order, int[][] dungeons, int total){
        
        int cnt = 0;
        
        for(int i = 0; i < order.length; i++){
            int req = dungeons[order[i]][0];
            int use = dungeons[order[i]][1];
            
            if(total >= req){
                total -= use;
                cnt++;
            }
        }
        
        // System.out.println("cnt : " + cnt);
        
        max = Math.max(cnt, max);
    }
    
    public static void DFS(int n, int[] check, boolean[] exist, int currIdx, int[][] dungeons, int total){
        
        if(currIdx == n){
            
            calc(check, dungeons, total);
            
            // for(int i = 0; i < n; i++){
            //     System.out.print(check[i] + " ");
            // }
            // System.out.println();
        }
        else{
            for(int i = 0; i < n; i++){
                if(exist[i]) continue;
                
                check[currIdx] = i;
                exist[i] = true;
                DFS(n, check, exist, currIdx + 1, dungeons, total);
                exist[i] = false;
            }
            
        }
    }
    
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        max = 0;
        
        DFS(dungeons.length, new int[dungeons.length], new boolean[dungeons.length], 0, dungeons, k);
        
        answer = max;
        
        return answer;
    }
}