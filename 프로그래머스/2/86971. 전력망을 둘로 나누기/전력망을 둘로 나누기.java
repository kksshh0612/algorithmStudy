import java.util.*;
// 모든 그래프를 노드 갯수 차이 최소로 해서 자르기. 최소 갯수 구하기 
// 일단 다 연결하고 wires 반복문 돌면서 하나씩 지워보기 
class Solution {
    
    public static int min;
    
    public void search(int[][] graph, boolean[] check, int start, int n){
        
        int cnt = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = true;
        
        while(!queue.isEmpty()){
            
            int currTurnSize = queue.size();
            
            while(currTurnSize-- > 0){
                int curr = queue.poll();
                
                for(int i = 1; i <= n; i++){
                    if(graph[curr][i] != 0 && !check[i]){
                        // System.out.println("여기 " + i);
                        queue.add(i);
                        check[i] = true;
                        cnt++;
                    }
                }
            }
        }
        min = Math.min(min, Math.abs((n - cnt) - cnt));
    }
    
    public int solution(int n, int[][] wires) {
        int answer = -1;
        
        int originalSize = n;
        min = originalSize;
        
        int[][] graph = new int[n + 1][n + 1];
        for(int i = 0; i < wires.length; i++){
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;
        }
        
        // System.out.println(originalSize);
        
        for(int i = 0; i < wires.length; i++){
            graph[wires[i][0]][wires[i][1]] = 0;
            graph[wires[i][1]][wires[i][0]] = 0;        //잠시 간선 삭제
            
            // for(int k = 1; k <= n; k++){
            //     for(int j = 1; j <= n; j++){
            //         System.out.print(graph[k][j] + " ");
            //     }
            //     System.out.println();
            // }
            
            // System.out.println("시작");
            search(graph, new boolean[n + 1], 1, n);
            
            graph[wires[i][0]][wires[i][1]] = 1;
            graph[wires[i][1]][wires[i][0]] = 1;        //다시 간선 삽입
        }
        
        answer = min;
        
        return answer;
    }
}