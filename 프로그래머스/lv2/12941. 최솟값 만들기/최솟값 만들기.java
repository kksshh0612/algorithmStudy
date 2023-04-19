import java.util.*;

class Solution
{
//     public static int min;
    
//     public static void DFS(int[] A, int[] B, int currIdx, boolean[] check, int[] mixArr){
//         if(currIdx == A.length){    //섞인 배열과 B를 곱함. 
//             int mulSum = 0;
//             for(int i = 0; i < B.length; i++){
//                 mulSum += (mixArr[i] * B[i]);
//                 // System.out.print(mixArr[i] + " ");
//             }
//             // System.out.println();
//             if(mulSum < min){
//                 min = mulSum;
//             }
//         }
//         else{
//             for(int i = 0; i < A.length; i++){
//                 if(check[i] == false){
//                     check[i] = true;
//                     mixArr[currIdx] = A[i];
//                     DFS(A, B, currIdx + 1, check, mixArr);
//                     check[i] = false;
//                 }
//             }
//         }
//     }
    
//     public int solution(int []A, int []B)
//     {
//         int answer = 0;
//         boolean[] check = new boolean[A.length];
//         int[] mixArr = new int[A.length];
//         min = Integer.MAX_VALUE;
        
//         DFS(A, B, 0, check, mixArr);
        
//         answer = min;

//         return answer;
//     }
    
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Integer[] arrB = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(A);
        Arrays.sort(arrB, Collections.reverseOrder());
        
        for(int i = 0; i < A.length; i++){
            answer += A[i] * arrB[i];
        }
        

        return answer;
    }
}