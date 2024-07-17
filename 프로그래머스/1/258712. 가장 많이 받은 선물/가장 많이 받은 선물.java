import java.util.*;
// 서로 줬으면, 더 적게 준 사람이 한번 줌 
// 선물 지수 = 자기가 준 수 - 받은 수    그니꺼 더 받은 사람이 덜 받은 사람한테 주는거

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        
        Map<String, Integer> memberMap = new HashMap<>();
        int idx = 0;
        for(String member : friends){
            memberMap.put(member, idx++);
        }
        
        int[][] arr = new int[friends.length][friends.length];      // 주고받은 정보
        int[] next = new int[friends.length];                       // 다음에 받을 갯수 저장
        
        for(String gift : gifts){
            StringTokenizer st = new StringTokenizer(gift);
            String giver = st.nextToken();
            String receiver = st.nextToken();
            arr[memberMap.get(giver)][memberMap.get(receiver)]++;
        }
        
        
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                // 주고받지 않았으면
                if((arr[i][j] == 0 && arr[j][i] == 0) || arr[i][j] == arr[j][i]){
                    int giveCnt1 = 0;
                    int receiveCnt1 = 0;
                    int giveCnt2 = 0;
                    int receiveCnt2 = 0;
                    for(int t = 0; t < arr.length; t++){
                        giveCnt1 += arr[i][t];
                        receiveCnt1 += arr[t][i];
                        giveCnt2 += arr[j][t];
                        receiveCnt2 += arr[t][j];
                        
                    }
                    
                    if(giveCnt1 - receiveCnt1 > giveCnt2 - receiveCnt2){
                        next[i]++;
                    }
                }
                else{
                    if(arr[i][j] > arr[j][i]){      //내가 더 줬으면
                        next[i]++;
                    }
                }
                
            }
        }
        
        Arrays.sort(next);
        answer = next[next.length - 1];
        
        return answer;
    }
}