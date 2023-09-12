import java.util.*;

class Solution {
    public List<Integer> solution(String s) {
        int[] answer = {};
        
        List<Integer> list = new ArrayList<>();
        
        s = s.substring(2);     //{{ 슬라이싱 
        s = s.substring(0, s.length() - 2);     //}} 슬라이싱 
        s = s.replace("},{", "-");              //숫자 사이를 -로 통일 
        
        String[] tokens = s.split("-");          // - 기준으로 잘라서 배열에 넣기 
        
        Arrays.sort(tokens, new Comparator<String>(){
            public int compare(String o1, String o2){
                return Integer.compare(o1.length(), o2.length());
            }
        });
        
        for(String token : tokens){
            String[] nums = token.split(",");
            for(String num : nums){
                Integer number = Integer.parseInt(num);
                if(!list.contains(number)){
                    list.add(number);
                }
            }
        }

        
        return list;
    }
}