class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];      //최저 순위, 최고 순위 
        int zero = 0, correct = 0;      //알아볼 수 없는 수와 맞춘 수 
        
        
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                zero++;
                continue;
            }
            for(int j = 0; j < win_nums.length; j++){
                if(lottos[i] == win_nums[j]){
                    correct++;
                    break;
                }
            }
        }
        //6개 1등   5개 2등   4개 3등   3개 4등   2개 5등   1개 6등
        
        answer[0] = 6 - (correct + zero) + 1;
        answer[1] = 6 - correct + 1;
        
        if(correct + zero == 0) answer[0] = 6;
        if(correct == 0) answer[1] = 6;
        
        return answer;
    }
}