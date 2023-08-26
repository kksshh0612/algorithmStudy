class Solution {
    public int solution(int[] array, int height) {
        int answer = 0;
        for(Integer h : array){
            if(h > height){
                answer++;
            }
        }
        return answer;
    }
}