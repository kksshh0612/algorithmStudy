import java.util.*;
//합친 영역은 해당 수 갯수 + 1 하고 -1로 초기화 
class Solution {
    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        int originalLen = arr.length;
        int currLen = arr.length;               //현재 한 변의 갯수 
        int currStartX = 0, currStartY = 0;     //현재 탐색하는 시작 좌표 
        int zero = 0, one = 0;                  //0과 1의 갯수
        int firstNum = 0;                       //모든 수와 비교할 첫번째 수 
        boolean check = true;
        
        while(currLen > 1){     //묶음의 길이가 2일때까지 반복
            // System.out.println(currStartX + " " + currStartY);
            check = true;
            firstNum = arr[currStartY][currStartX];     //탐색하는 묶음에서 첫번째 수랑 모두 비교.
            if(firstNum != -1){
                for(int i = currStartY; i < currStartY + currLen; i++){
                    for(int j = currStartX; j < currStartX + currLen; j++){      //j가 x임. 주의!!
                        
                        if(firstNum != arr[i][j]){      //같지 않은 수가 나오면 false
                            check = false;
                            break;
                        }
                    }
                }
                if(check){      //모든 수가 같으면 -1로 모두 바꿔주어 탐색하지 않도록 처리 
                    if(firstNum == 1) one++;
                    else zero++;
                    for(int i = currStartY; i < currStartY + currLen; i++){
                        for(int j = currStartX; j < currStartX + currLen; j++){      //j가 x임. 주의!!
                            arr[i][j] = -1;     
                        }
                    }
                }
            }
            
            currStartX += currLen;              //일단 x는 계속 길이만큼 건너뛰면서 증가시킴.
            if(currStartX >= originalLen){      //근데 범위 넘어가면
                currStartY += currLen;          //Y를 증가시키고 x를 0으로 만듦. 그니까 다음 줄 첫번째로 가는 것. 
                currStartX = 0;
            } 
            if(currStartY >= originalLen){      //근데 이제 Y도 넘어가면? 탐색이 끝난 것. 
                currLen /= 2;
                currStartX = 0;
                currStartY = 0;
            }
        }
        //모든 탐색이 끝나면 길이가 1일때만 남음. 
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] == 1) one++;
                else if(arr[i][j] == 0) zero++;
            }
        }
        
        answer[0] = zero;
        answer[1] = one;
        
        return answer;
    }
}