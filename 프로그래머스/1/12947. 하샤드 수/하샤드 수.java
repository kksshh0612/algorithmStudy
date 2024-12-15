class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int num = x, hiNum = 0;
        while(num > 0){
            hiNum += num % 10;
            num /= 10;
        }
        
        answer = (x % hiNum == 0) ? true : false;
        
        return answer;
    }
}