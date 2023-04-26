import java.util.*;
//진행하며 현재까지 거리를 더해서 저장하며 진행. 
//탐색하는 칸이 1이 아니면서 본인 + 1 보다 작으면 그쪽으로 진행할 수 없음. 리턴. 
//오른쪽, 아래, 위, 왼쪽 순으로 탐색 
class Solution {
    
    public static int min;
    
    public int solution(int[][] maps) { //int[y좌표][x좌표] <<---명심!!!
        int answer = 0;
        Integer[] start = new Integer[2];        //x, y
        // Integer[] next = new Integer[2];        
        int[] dirX = {1, 0, 0, -1};
        int[] dirY = {0, 1, -1, 0};     //오른쪽, 아래, 위, 왼쪽 
        Queue<Integer[]> queue = new LinkedList<>();    //x, y 저장
        
        min = Integer.MAX_VALUE;
        
        start[0] = 0;
        start[1] = 0;
        queue.add(start);
        
        while(!queue.isEmpty()){
            Integer[] curr = queue.poll();
            
            if(curr[1] == maps.length - 1 && curr[0] == maps[0].length - 1){    //목적지에 다다르면
                if(maps[curr[1]][curr[0]] < min){
                    min = maps[curr[1]][curr[0]];
                    break;
                }
            }
            
            for(int i = 0; i < 4; i++){
                Integer[] next = {curr[0] + dirX[i], curr[1] + dirY[i]};
            
                //map의 범위 안에서
                if((next[1] >= 0 && next[1] < maps.length) && (next[0] >= 0 && next[0] < maps[0].length)){
                    //다음에 갈 곳이 1이거나, 현재 경로에서 가는 길이보다 클 때 진출 
                    if(maps[next[1]][next[0]] == 1 || maps[next[1]][next[0]] > maps[curr[1]][curr[0]] + 1){
                        // System.out.println(next[0] + ", " + next[1]);
                        maps[next[1]][next[0]] = maps[curr[1]][curr[0]] + 1;
                        queue.add(next);
                    }
                }
            }
            
        }
        
        
        if(min == Integer.MAX_VALUE){
            answer = -1;
        }
        else{
            answer = min;
        }

        return answer;
    }
}