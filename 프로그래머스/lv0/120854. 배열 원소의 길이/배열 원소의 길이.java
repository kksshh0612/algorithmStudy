class Solution {
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int idx = 0;
        for(String token : strlist){
            answer[idx++] = token.length();
        }
        return answer;
    }
}