import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int quotation = 0;          //인용 수 
        int quoCitation = 0;        //quotation 이상 인용된 논문 수 
        int max = 0;
        Arrays.sort(citations);     //오름차순 정렬 
        
        for(int i = 0; i < citations.length; i++){
            quotation = citations[i];       //인용 수 
            quoCitation = citations.length - i;
            
            if(quotation >= quoCitation){
                max = quoCitation;
                break;
            }
        }
        
        answer = max;
        
        return answer;
    }
}