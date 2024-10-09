import java.util.*;

class Solution {
    
    // 공약수 구하기
    List<Integer> getList(int[] arr){
        List<Integer> list = new ArrayList<>();
        
        for(int i = 2; i <= Math.sqrt(arr[0]); i++){
            if(arr[0] % i == 0){
                list.add(i);
                list.add(arr[0] / i);
            }
        }
        list.add(arr[0]);
        
        for(int i = 1; i < arr.length; i++){
            List<Integer> removeList = new ArrayList<>();
            for(Integer div : list){
                if(arr[i] % div != 0) removeList.add(div);
            }
            list.removeAll(removeList);
        }
        
        return list;
    }
    
    public int checkMax(List<Integer> list, int[] arr){
        // arr이 리스트로 다 나누어지지 않는 수 중 가장 큰 리스트 값
        for(int i = list.size() - 1; i >= 0; i--){
            boolean ans = true;
            for(int j = 0; j < arr.length; j++){
                if(arr[j] % list.get(i) == 0){
                    ans = false;
                    break;
                }
            }
            if(ans) return list.get(i);
        }
        return 0;
    }
    
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        
        // A의 공약수 
        List<Integer> aList = getList(arrayA);
        
        Collections.sort(aList);
        
        List<Integer> bList = getList(arrayB);
        
        Collections.sort(bList);
        
        // 비교
        answer = Math.max(checkMax(aList, arrayB), checkMax(bList, arrayA));
        
    
        return answer;
    }
}