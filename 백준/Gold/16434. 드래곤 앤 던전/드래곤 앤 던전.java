import java.util.*;
import java.io.*;
// 용사의 공격 몬스터 공격 반복. 공격한 직후 상대 체력 0 이하이면 끝
// 용을 쓰러트리기 위한 최소 (최대생명력) 구하기
public class Main {

    public static class Room{
        int type, attack, hp;
        public Room(int t, int a, int l){
            this.type = t;
            this.attack = a;
            this.hp = l;
        }
    }

    // 게임을 진행하고 체력이 남았는지 부족한지 반환
    public static boolean game(Room[] rooms, long maxHp, long attack){
        long currHp = maxHp;

        for(Room room : rooms){
            long roomHp = room.hp;
            long roomAttack = room.attack;

            if(room.type == 1){     //몬스터이면
                if(roomHp % attack == 0){
                    currHp -= (roomHp / attack - 1) * roomAttack;
                }
                else{
                    currHp -= (roomHp / attack) * roomAttack;
                }

                if(currHp <= 0) return false;
            }
            else{                   // 물약이면
                currHp = currHp + roomHp > maxHp ? maxHp : currHp + roomHp;
                attack += roomAttack;
            }
        }
        if(currHp > 0) return true;
        else return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int roomSize = Integer.parseInt(st.nextToken());
        int initAttack = Integer.parseInt(st.nextToken());

        // 1 공격력 생명력 몬스터    2 공격력 증가 생명력 회복
        Room[] rooms = new Room[roomSize];
        for(int i = 0; i < roomSize; i++){
            st = new StringTokenizer(bf.readLine());
            int type = Integer.parseInt(st.nextToken());
            int attack = Integer.parseInt(st.nextToken());
            int hp = Integer.parseInt(st.nextToken());
            rooms[i] = new Room(type, attack, hp);
        }

        // 이분탐색 ( 체력 )
        long left = 1, right = Long.MAX_VALUE - 1;
        while(left <= right){
            long mid = (left + right) / 2;

            boolean isRemainHp = game(rooms, mid, initAttack);

            if(isRemainHp){          // 최대 체력이 남거나 딱 맞으면
                right = mid - 1;
            }
            else{                       // 최대 체력이 부족하면
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}