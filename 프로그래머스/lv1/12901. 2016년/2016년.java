class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int[] mon = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};   
        int totalDays = 0, currMonth = 0;
        
        while(currMonth < a){
            totalDays += mon[currMonth++];
        }
        totalDays += b;
        
        while(totalDays > 7){
            totalDays -= 7;
        }
        
        switch(totalDays){
            case 1:
                answer = "FRI";
                break;
            case 2:
                answer = "SAT";
                break;
            case 3:
                answer = "SUN";
                break;
            case 4:
                answer = "MON";
                break;
            case 5:
                answer = "TUE";
                break;
            case 6:
                answer = "WED";
                break;
            case 7:
                answer = "THU";
                break;
   
        }
        
        return answer;
    }
}