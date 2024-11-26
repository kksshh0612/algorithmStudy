import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        for(int num : numbers){
            list.add(String.valueOf(num));
        }
        
        Collections.sort(list, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        
        StringBuilder ans = new StringBuilder();
        for(String str : list){
            ans.append(str);
        }
        
        answer = ans.toString();
        
        if(answer.charAt(0) == '0'){
            answer = "0";
        }
        
        return answer;
    }
}