import java.util.*;

class Solution {
    
    public static ArrayList<Integer> arr = new ArrayList<>();   //순열로 만든 수 저장
    
    public static boolean isPrime(int num){
        if(num == 0 || num == 1) return false;
        if(num == 2) return true;
        
        for(int i = 2; i < num; i++){       //어떤 수로 나누어 떨어지면 소수가 아님
            if(num % i == 0) return false;
        }
        return true;
    }
    
    //숫자, 숫자 쓰였는지 체크할 배열, 자릿수, 현재 자릿수, 현재 만들어진 숫자
    public static void dfs(String num, int[] check, int digit, int currDigit, int currNum){
        if(currDigit == digit){     //원하는 자릿수만큼 수가 만들어졌으면 
            if(!arr.contains(currNum)){
                arr.add(currNum);
                // System.out.println("결과 : " + currNum);
            }
        }
        else{
            for(int i = 0; i < num.length(); i++){
                char curr = num.charAt(i);
                if(check[(int)(curr - 48)] > 0){       //아직 사용되지 않은 수이면
                    check[(int)(curr - 48)]--;
                    // System.out.println("과정 : " + (int)(curr - 48));
                    dfs(num, check, digit, currDigit + 1, currNum * 10 + (int)(curr - 48));
                    check[(int)(curr - 48)]++;
                }
            }
        }
    }
    
    public int solution(String numbers) {
        int answer = 0;
        int[] check = new int[10];      //0~9까지 어떤 숫자가 몇 개 쓰였는지 확인

        for(int i = 0; i < numbers.length(); i++){
            check[(int)(numbers.charAt(i) - 48)]++;
        }
        
        for(int i = 0; i < numbers.length(); i++){  //i+1개로 만들 수 있는 수 
            dfs(numbers, check, i + 1, 0, 0);
        }
        
        for(int i = 0; i < arr.size(); i++){
            if(isPrime(arr.get(i))){
                answer++;
            }
        }
        
        return answer;
    }
}