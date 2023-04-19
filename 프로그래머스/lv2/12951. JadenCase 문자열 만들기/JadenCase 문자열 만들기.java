import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char currChar = 0;
        String curr = "";
        boolean check = true;       //첫번째는 무조건 대문자
        for(int i = 0; i < s.length(); i++){
            currChar = s.charAt(i);
            curr = Character.toString(currChar);     //현재 문자 
            if(curr.equals(" ")) {
                check = true;
                answer += " ";
                continue;      //공백이면 그냥 넘어감
            }
            if(check){      //공백 다음이면 
                if(Character.isDigit(currChar)){     //숫자이면 그냥 +
                    answer += curr;
                }
                else{                                //숫자가 아니면 대문자로 변환
                    answer += curr.toUpperCase();   
                }
            }
            else{           //문자 중간일 때 
                answer += curr.toLowerCase();
            }
            check = false;

        }
        // System.out.println(answer);
        return answer;
    }
}