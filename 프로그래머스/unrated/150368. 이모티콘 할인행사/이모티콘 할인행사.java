import java.util.*;
//플러스 사용자 최대로 늘리기, 판매액 최대 / 할인률은 10 20 30 40

class Solution {            //구매할 최소 할인율, 가격        //이모티콘 정가 
    
    public static int maxJoinNum;   //최대 가입자 수
    public static int maxSaleSum;   //최대 매출액 
    
    public static void DFS(int[][] discountedPrice, boolean[][] check, int currIdx, int emoticonNum, 
                          int[][] users){
        int joinNum = 0;
        int saleNum = 0;
        int[][] usersCopy = new int[users.length][2];
        for(int i = 0; i < users.length; i++){          //유저 정보 복사
            usersCopy[i][0] = users[i][0];
            usersCopy[i][1] = users[i][1];
        }
        
        if(currIdx == emoticonNum){
            for(int i = 0; i < emoticonNum; i++){
                for(int j = 0; j < 4; j++){
                    if(check[j][i] == true){            //10,20,30,40 할인된 가격중 선택된 가격
                        // System.out.print(discountedPrice[j][i] + " ");
                        for(int k = 0; k < usersCopy.length; k++){      //사람 수만큼 
                            if((j + 1) * 10 >= usersCopy[k][0]){        //고객이 원하는 할인률 이상일 경우만 구매
                                usersCopy[k][1] -= discountedPrice[j][i];
                            }
                        }
                        break;
                    }
                }
                
            }
            // System.out.println();
            for(int i = 0; i < usersCopy.length; i++){
                // System.out.println("유저 : " + usersCopy[i][1]);
                if(usersCopy[i][1] <= 0){
                    joinNum++;
                }
                else{
                    saleNum += users[i][1] - usersCopy[i][1];
                }
            }
            if(joinNum > maxJoinNum){
                maxJoinNum = joinNum;
                maxSaleSum = saleNum;
            }
            else if(joinNum == maxJoinNum){     //같으면 판매액이 더 많아야 함
                if(saleNum > maxSaleSum){
                    maxJoinNum = joinNum;
                    maxSaleSum = saleNum;
                }
            }
        }
        else{
            for(int i = 0; i < 4; i++){
                if(check[i][currIdx] == false){
                    check[i][currIdx] = true;
                    DFS(discountedPrice, check, currIdx + 1, emoticonNum, users);
                    check[i][currIdx] = false;
                }
                
            }
        }
    }
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};      //이모티콘 플러스 가입자 수, 이모티콘 매출액 
        int[][] discountedPrice = new int[4][emoticons.length];
        boolean[][] check = new boolean[4][emoticons.length];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < emoticons.length; j++){
                discountedPrice[i][j] = emoticons[j] * (10 - i - 1) / 10; // 할인률마다 할인된 가격 계산 
            }
        }
        // for(int i = 0; i < 4; i++){
        //     for(int j = 0; j < emoticons.length; j++){
        //         System.out.print(discountedPrice[i][j] +" "); 
        //     }
        //     System.out.println();
        // }
        
        maxJoinNum = 0;
        maxSaleSum = 0;
        
        DFS(discountedPrice, check, 0, emoticons.length, users);
        
        answer = new int[2];
        answer[0] = maxJoinNum;
        answer[1] = maxSaleSum;
        
        return answer;
    }
}