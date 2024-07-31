import java.util.*;

// t초동안 1초마다 X 체력 회복 t초 연속 감으면 y 추가
// 중간에 공격당하면 멈추고 다시 붕대 감은 -> 시간은 0으로 초기화
// 체력 0 이하면 죽음
// 공격 끝나고 남은 체력. 중간에 죽으면 -1
class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;
        
        int maxHealth = health;
        int t = -1, cnt = 0, attackIdx = 0;
        while(true){
            
            // System.out.println(health);
            t++;
            
            if(health == -1) break;
            if(attackIdx >= attacks.length) break;
            
            if(attacks[attackIdx][0] == t){
                health -= attacks[attackIdx][1];
                if(health <= 0) health = -1;
                attackIdx++;
                cnt = 0;
                continue;
            }
            
            cnt++;
          
            health = health + bandage[1] >= maxHealth ? maxHealth : health + bandage[1];
          
            if(cnt == bandage[0]){
                health = health + bandage[2] >= maxHealth ? maxHealth : health + bandage[2];
                cnt = 0;
            } 
            
        }
        
        answer = health;
        
        return answer;
    }
}