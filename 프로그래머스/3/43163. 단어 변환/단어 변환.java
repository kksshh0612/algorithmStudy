import java.util.*;
// bfs로 한글자 차이 나면 큐에 넣음. 타겟 나오면 끝
class Solution {
    
    public static int bfs(String start, String end, String[] words){
        Queue<String> queue = new LinkedList<>();
        boolean[] check = new boolean[words.length];
        
        queue.add(start);
        int turn = 0;
        while(!queue.isEmpty()){
            int currTurnSize = queue.size();
            
            while(currTurnSize-- > 0){
                String curr = queue.poll();
                
                for(int i = 0; i < words.length; i++){
                    if(curr.equals(end)){
                        return turn;
                    }
                    // 문자 하나 차이(비슷한) 이면 큐에 넣음
                    if(!check[i] && similar(curr, words[i])){
                        // System.out.println(curr + " " + words[i]);
                        queue.add(words[i]);
                        check[i] = true;
                    }
                }
                
            }
            turn++;
        }
        return 0;
        
    }
    
    public static boolean similar(String str1, String str2){
        int cnt = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)) cnt++;
        }
        
        if(cnt > 1) return false;
        else return true;
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        answer = bfs(begin, target, words);
        
        return answer;
    }
}