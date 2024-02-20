import java.util.*;
// 간선 비용 기준으로 정렬하고, union에 포함된 것인지 확인해서 둘 중 하나 포함 안됐으면 해당 간선 추가 
// 유니온 파인드로 해결하기 
class Solution {
    
    public static int[] parent;
    
    // 루트를 찾는 함수 
    public static int find(int x){
        if(parent[x] == x) return x;
        else return find(parent[x]);
    }
    
    //유니온을 만드는 함수 
    public static boolean union(int x, int y){
        int xParent = find(x);
        int yParent = find(y);
        
        if(xParent == yParent) return false;      //이미 같은 유니온
        
        // 작은 것이 부모가 됨 
        if(xParent < yParent) parent[yParent] = xParent;
        else parent[xParent] = yParent;
        
        return true;
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int totalVal = 0;
        parent = new int[n];
        
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        
        // 간선 비용 기준 정렬 
        Arrays.sort(costs, new Comparator<int[]>(){
        
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[2] - o2[2];
            }
        });
        
        
        for(int i = 0; i < costs.length; i++){
            int vtx1 = costs[i][0];
            int vtx2 = costs[i][1];
            
            if(union(vtx1, vtx2)){
                totalVal += costs[i][2];
            }
        }
        
        answer = totalVal;
        
        return answer;
    }
}