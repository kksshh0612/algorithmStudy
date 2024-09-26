import java.util.*;

class Solution {
    
    // k를 1로 만드는 과정을 리스트로 반환
    public static List<Integer> make(int k){
        List<Integer> list = new ArrayList<>();
        list.add(k);
        
        while(k > 1){
            if(k % 2 == 0){
                k /= 2;
            }
            else{
                k = k * 3 + 1;
            }
            list.add(k);
        }
        return list;
    }
    
    // 넓이 누적합 구하기
    public static double[] calcArea(List<Integer> list){
        double[] area = new double[list.size()];
        area[0] = 0;
        
        for(int i = 1; i < list.size(); i++){
            int min = Math.min(list.get(i), list.get(i - 1));
            int max = Math.max(list.get(i), list.get(i - 1));
            
            area[i] = area[i - 1] + min + (double)(max - min) / 2;
        }
        
        return area;
    }
    
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        
        List<Integer> list = make(k);
        double[] areaSum = calcArea(list);
        
        int idx = 0;
        for(int[] range : ranges){
            int start = range[0];
            int end =  areaSum.length - 1 + range[1];
            
            if(end < start){
                answer[idx++] = -1;
                continue;
            } 
            
            answer[idx++] = areaSum[areaSum.length - 1] - areaSum[start] - 
                (areaSum[areaSum.length - 1] - areaSum[end]);
        }
        
        // for(int i = 0; i < areaSum.length; i++){
        //     System.out.println(areaSum[i]);
        // }
        
        return answer;
    }
}