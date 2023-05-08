class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        
        StringBuilder sb = new StringBuilder();
        int[] xCnt = new int[10];
        int[] yCnt = new int[10];
        int curr = 0;
        
        for(int i = 0; i < X.length(); i++){
            curr = (int)(X.charAt(i) - '0');
            xCnt[curr]++;
        }
        for(int i = 0; i < Y.length(); i++){
            curr = (int)(Y.charAt(i) - '0');
            yCnt[curr]++;
        }
        
        for(int i = 9; i >= 0; i--){
            while(xCnt[i] > 0 && yCnt[i] > 0){
                sb.append(i);
                xCnt[i]--;
                yCnt[i]--;
            }
        }
        
        answer = sb.toString();
        
        if(answer.equals("")){
            answer = "-1";
        }
        else if(answer.charAt(0) == '0'){
            answer = "0";
        }
              
        return answer;
    }
}