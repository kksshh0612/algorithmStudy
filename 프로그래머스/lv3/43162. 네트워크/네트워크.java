import java.util.*;
//visited[n] 만들고, BFS로 탐색하면 visited에 true로 세팅. 더이상 갈 곳이 없으면 answer + 1
//모든 노드 수를 찾을 때까지 반복 
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int vtxCnt = 0;     //현재까지 탐색한 노드 수 
        int currVtx = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 1; i < n; i++){     //0과 연결된 노드들 찾기 
            if(computers[0][i] == 1){
                queue.add(i);
            }
        }
        vtxCnt++;           //0번 탐색함 
        visited[0] = true;  
        answer++;           //네트워크 수 하나 증가 
        
        while(vtxCnt < n){      //모든 노드를 탐색할 때까지 반복 
            if(!queue.isEmpty()){           //큐가 비어있지 않다면 같은 네트워크 내를 탐색중인 것임. 
                currVtx = queue.poll();     //현재 탐색중인 노드 
                if(visited[currVtx] == false){
                    // System.out.println("현재 노드 : " + currVtx);
                    vtxCnt++; 
                    visited[currVtx] = true;
                    
                    for(int i = 0; i < n; i++){
                        if(i == currVtx) continue;      //자기 자신이면 건너뜀
                        if(visited[i] == false && computers[currVtx][i] == 1){
                            queue.add(i);
                        }
                    }
                }
            }
            else{           //큐가 비어있다면 새로운 네트워크를 찾을 차례
                answer++;   //네트워크 수 증가 
                for(int i = 0; i < visited.length; i++){
                    if(visited[i] == false){    //아직 탐색 안한 노드 찾으면 
                        queue.add(i);
                        break;
                    }
                }
            }
            
        }
        
        return answer;
    }
}