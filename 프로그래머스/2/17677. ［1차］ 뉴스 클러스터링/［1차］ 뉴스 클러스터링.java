import java.util.*;
// 교집합 크기 / 합집합 크기
class Solution {
    
    public static List<String> tokens1 = new ArrayList<>();
    public static List<String> tokens2 = new ArrayList<>();
    public static Map<String, Integer> map1 = new HashMap<>();
    public static Map<String, Integer> map2 = new HashMap<>();
    
    public static void putMap(List<String> tokens, Map<String, Integer> map){
        for(String token : tokens){
            map.put(token, map.getOrDefault(token, 0) + 1);
        }
    }
    
    public static double zacad(){
        int cross = 0, sum = 0;
        Set<String> alreadyFind = new HashSet<>();
        
        for(String token : map1.keySet()){
            for(String tokenCompare : map2.keySet()){
                if(token.equals(tokenCompare)){
                    cross += Math.min(map1.get(token), map2.get(tokenCompare));
                    sum += Math.max(map1.get(token), map2.get(tokenCompare));
                    alreadyFind.add(token);
                }
            }
        }
        
        // 첫번째 map 확인 -> map1과 안겹치는 것들 모두 합집합
        for(String token : map1.keySet()){
            if(alreadyFind.contains(token)) continue;
            
            sum += map1.get(token);
        }
        
        // 두번째 map 확인 -> map1과 안겹치는 것들 모두 합집합
        for(String token : map2.keySet()){
            if(alreadyFind.contains(token)) continue;
            
            sum += map2.get(token);
        }
        
        System.out.println(cross + " " + sum);
        
        return (double)cross / (double)sum;
    }
    
    public int solution(String str1, String str2) {
        int answer = 0;
        
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        
        for(int i = 0; i < str1.length() - 1; i++){
            char token1 = str1.charAt(i);
            char token2 = str1.charAt(i + 1);
            
            if((token1 > 'z' || token1 < 'a') || (token2 > 'z' || token2 < 'a')) continue;
            
            tokens1.add(new StringBuilder().append(token1).append(token2).toString());
        }
        for(int i = 0; i < str2.length() - 1; i++){
            char token1 = str2.charAt(i);
            char token2 = str2.charAt(i + 1);
            
            if((token1 > 'z' || token1 < 'a') || (token2 > 'z' || token2 < 'a')) continue;
            
            tokens2.add(new StringBuilder().append(token1).append(token2).toString());
        }
        
        // 각 문자당 몇개씩 있는지 셈
        putMap(tokens1, map1);
        putMap(tokens2, map2);
        
        if(tokens1.isEmpty() && tokens2.isEmpty()){
            answer = 65536;
        }
        else{
           // 유사도 검사
            double compareResult = zacad();
            // System.out.println(Math.round(compareResult*100) / 100.0);
            answer = (int)(compareResult * 65536); 
        }
        
        return answer;
    }
}