class Solution {
    public int[] solution(int[] arr) {
        int[] answer;
        if(arr.length > 1){
            answer = new int[arr.length - 1];
        }
        else{
            answer = new int[1];
        }
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }
      
        int idx = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == min) {
                continue;
            }
            answer[idx++] = arr[i];
        }
        if(idx == 0) answer[0] = -1;
        
        return answer;
    }
}