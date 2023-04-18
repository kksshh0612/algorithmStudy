import java.util.*;

class Solution {    //모든 경로에 단속 카메라 걸리게 하는데, 카메라 놓는 최소 갯수 
    public int solution(int[][] routes) {
        int answer = 0;     
        
        Arrays.sort(routes, new Comparator<int[]>(){
            @Override
            public int compare(int[] route1, int[] route2){
                return route1[1] - route2[1];       //끝나는 지점 기준 오름차순 정렬
            }
        });
        
        int camLoc = Integer.MIN_VALUE;
        
        for(int i = 0; i < routes.length; i++){     //차의 갯수만큼 반복 
            if(camLoc < routes[i][0]){              //마지막 캠의 위치가 현재 차의 시작위치보다 작으면 하나 설치 
                answer++;
                camLoc = routes[i][1];
            }
        }
            
            
        return answer;
    }
}