import java.util.*;
// 파기해야할 개인정보 위치 구하기 (1부터 시작)
// terms는 map에 저장 / 더해서 today보다 이전이면 파기 
class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> ans = new ArrayList<>();
        
        Map<String, Integer> valTerm = new HashMap<>();     //유효기간 
        for(String term : terms){
            StringTokenizer st = new StringTokenizer(term);
            valTerm.put(st.nextToken(), Integer.parseInt(st.nextToken()));
        }
        
        int todayYear = Integer.parseInt(today.substring(0, 4));
        int todayMonth = Integer.parseInt(today.substring(5, 7));
        int todayDay = Integer.parseInt(today.substring(8, 10));
        
        int todayTotal = todayYear*12*28 + todayMonth*28 + todayDay;
        
        // System.out.println(todayYear + " " + todayMonth + " " + todayDay);
        
        for(int i = 0; i < privacies.length; i++){
            
            String curr = privacies[i].substring(0, 10);
            int currYear = Integer.parseInt(curr.substring(0, 4));
            int currMonth = Integer.parseInt(curr.substring(5, 7));
            int currDay = Integer.parseInt(curr.substring(8, 10));
            
            String type = privacies[i].substring(11, privacies[i].length());
            
            int valMonth = valTerm.get(type);
            
            int currTotal = currYear*12*28 + currMonth*28 + currDay + valMonth*28;
            
            if(currTotal <= todayTotal) ans.add(i + 1);
            
            // System.out.println(curr);
            // System.out.println(type);
            
            
        }
        
        
        return ans;
    }
}