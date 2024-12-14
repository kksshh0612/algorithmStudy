import java.util.*;

class Solution {
    
    static List<List<Integer>> graph = new ArrayList<>();
    
    static void bfs(int start, int dest, int[] answer, int size, int idx){
        if(start == dest) answer[idx] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[size + 1];
        
        queue.add(start);
        
        int len = 0;
        while(!queue.isEmpty()){
            int currTurnSize = queue.size();
            len++;
            while(currTurnSize-- > 0){
                int curr = queue.poll();
            
                check[curr] = true;
            
                for(int next : graph.get(curr)){
                    if(check[next]) continue;       // 이미 방문했으면 건너뜀
                    
                    if(next == dest){               // 찾는 목적지이면 끝
                        answer[idx] = len;
                        return;
                    }
                    
                    queue.add(next);
                    check[next] = true;
                }
            }
        }
    }
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        Arrays.fill(answer, -1);
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        
        for(int i = 0; i < sources.length; i++){
            bfs(sources[i], destination, answer, n, i);
        }
        
        return answer;
    }
}