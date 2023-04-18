import java.util.*;

class Solution {        //노랑의 가로+세로+가로+세로+4 = 갈색
      
    public int[] solution(int brown, int yellow) {
        int[] answer = {};      //가로, 세로 중 큰거 먼저 
        answer = new int[2];
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> ansArrayList = new ArrayList<>();
        
        for(int i = 1; i <= yellow; i++){
            if(yellow % i == 0){
                arr.add(i);
                
            }
        }
        //인덱스
        int left = 0;
        int right = arr.size() - 1;
        
        while(left <= right){
            int leftNum = arr.get(left++);
            int rightNum = arr.get(right--);

            if((leftNum + rightNum) * 2 + 4 == brown){
                ansArrayList.add(leftNum + 2);
                ansArrayList.add(rightNum + 2);
            }
        }
        Collections.sort(ansArrayList, Comparator.reverseOrder());
        
        answer[0] = ansArrayList.get(0);
        answer[1] = ansArrayList.get(1);
        
        return answer;
    }
}