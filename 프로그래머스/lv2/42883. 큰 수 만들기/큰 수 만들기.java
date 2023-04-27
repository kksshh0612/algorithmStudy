import java.util.*; 

class Solution {        //앞에서부터 k+1개씩 탐색하며 최댓값을 answer에 + 해준다.
    public String solution(String number, int k){
        String answer = "";
        int max = 0;
        int lastIdx = -1;
        StringBuilder sb = new StringBuilder("");
        
        for(int i = 0; i < number.length() - k; i++){
            max = 0;
            for(int j = lastIdx + 1; j <= i + k; j++){            //k+1개씩 탐색하면서 최댓값 뽑기 
                int curr = (int)(number.charAt(j) - '0');
                if(curr > max){
                    max = curr;
                    lastIdx = j;            //현재 최댓값을 뽑아서 문자열에 붙였으면, 그 앞의 수들은 못씀. 
                }
            }
            sb.append(Integer.toString(max));    
        }
        
        answer = sb.toString();
        
        return answer;
    }
}

//자릿수 높은 수가 낮은 수보다 작으면 제거해야함. 
//내 앞에 있는 수 중 나보다 작은 수들 중 가장 작은거 먼저 제거 

// class Solution {
//     public String solution(String number, int k) {
//         String answer = "";
//         ArrayList<Integer> arr = new ArrayList<>();

//         for(int i = 0; i < number.length(); i++){
//             arr.add((int)(number.charAt(i) - 48));      //문자열을 숫자로 변환 후 저장 
//         }

//         int min = Integer.MAX_VALUE;
//         int minIdx = 0;
//         int smallValCnt = 0;
//         for(int i = 1; i < arr.size(); i++){
//             if(k <= 0) break;

//             smallValCnt = 0;
//             min = Integer.MAX_VALUE;
            
//             List<Integer> partArr = new ArrayList<>(arr.subList(0, i));        //현재 나보다 앞에 있는 것들
            
//             // System.out.print("현재 부분 : " );
//             // for(int j = 0; j < partArr.size(); j++){
//             //     System.out.print(partArr.get(j) + " ");
//             // }
//             // System.out.println();
            
//             for(int j = 0; j < partArr.size(); j++){
//                 if(partArr.get(j) != -1 && partArr.get(j) < arr.get(i)){        //나보다 작은 값이 몇개 있는지 셈 
//                     smallValCnt++;
//                 }
//             }
            
//             // System.out.println("인덱스 : " +i + "현재 수 : "+ arr.get(i) + " 작은 수 갯수 : " + smallValCnt);
            
//             while(k > 0 && smallValCnt > 0){       //나보다 작은 값이 있으면 반복
//                 for(int j = 0; j < partArr.size(); j++){
//                     if(partArr.get(j) != -1 && partArr.get(j) < min){
//                         min = partArr.get(j);
//                         minIdx = j;
//                     }
//                 }

//                 k--;
//                 arr.set(minIdx, -1);
//                 partArr.set(minIdx, -1);
//                 smallValCnt--;
//                 min = Integer.MAX_VALUE;
        
//             }
//         }
//         for(int i = 0; i < arr.size(); i++){
//             if(arr.get(i) != -1){
//                 answer += Integer.toString(arr.get(i));
//             }
//         }
        
//         return answer;
//     }
// }