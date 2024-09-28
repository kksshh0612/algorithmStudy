import java.util.*;
// 유니온 파인드
class Solution {
    
    public static int find(int[] parent, int n){
        if(parent[n] == n) return n;
        else return find(parent, parent[n]);
    }
    
    public static void union(int[] parent, int n1, int n2){
        
        int min = Math.min(n1, n2);
        
        parent[n1] = min;
        parent[n2] = min;
    }
    
    public int solution(int[] cards) {
        int answer = 1;
        
        int[] parent = new int[cards.length + 1];
        
        for(int i = 0; i < parent.length; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < cards.length; i++){
            int n1 = find(parent, i + 1);
            int n2 = find(parent, cards[i]);
            
            if(n1 != n2){
                union(parent, n1, n2);
            }
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 1; i < parent.length; i++){
            int key = find(parent, i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        List<Integer> list = new ArrayList<>();
        for(Integer key : map.keySet()){
            list.add(map.get(key));
        }
        Collections.sort(list, Comparator.reverseOrder());
        
        answer *= list.get(0);
        if(list.size() == 1){
            answer = 0;
        }
        else{
            answer *= list.get(1);
        }
        
        return answer;
    }
}