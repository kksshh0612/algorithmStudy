import java.util.*;

// 소인수분해하고 HashMap에 최대 갯수 저장
class Solution {
    
    public static class Num{
        int n, cnt;
        public Num(int n, int cnt){
            this.n = n;
            this.cnt = cnt;
        }
    }
    
    // 소인수분해 후 map(수, 갯수) 반환
    public static Map<Integer, Integer> calc(int number){
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 2; i <= Math.sqrt(number); i++){
    
            while(number % i == 0){
                map.put(i, map.getOrDefault(i, 0) + 1);
                number /= i;
            }
        }
        map.put(number, map.getOrDefault(number, 0) + 1);
        
        return map;
    }
    
    public int solution(int[] arr) {
        int answer = 1;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int number : arr){
            Map<Integer, Integer> countMap = calc(number);
            
            // map과 비교하며 현재 map의 각 수 최대 갯수보다 많으면 갱신
            for(Integer key : countMap.keySet()){
                map.put(key, Math.max(countMap.get(key), map.getOrDefault(key, 0)));
            }
        }
        
        // System.out.println(map.size());
        
        for(Integer key : map.keySet()){
            // System.out.println(key + " " + map.get(key));
            
            answer *= Math.pow(key, map.get(key));
        }
        return answer;
    }
}