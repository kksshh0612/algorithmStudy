import java.util.*;
import java.io.*;

// 최대 몇개의 계란을 깰 수 있는지
public class Main {

    public static int size;
    public static Egg[] eggs;
    public static int max;

    public static class Egg{
        int strength, weight;
        public Egg(int s, int w){
            this.strength = s;
            this.weight = w;
        }
    }

    public static void dfs(int curr){
        if(curr == size){
            int breakCnt = 0;
            for(Egg egg : eggs){
                if(egg.strength <= 0) breakCnt++;
            }
            max = Math.max(max, breakCnt);
        }
        else{
            if(eggs[curr].strength <= 0){       // 손에 든 계란이 깨졌으면
                dfs(curr + 1);
            }
            else{
                boolean canBreak = false;
                for(int i = 0; i < size; i++){
                    if(i == curr || eggs[i].strength <= 0) continue;

                    canBreak = true;
                    eggs[i].strength -= eggs[curr].weight;
                    eggs[curr].strength -= eggs[i].weight;

                    dfs(curr + 1);

                    eggs[i].strength += eggs[curr].weight;
                    eggs[curr].strength += eggs[i].weight;
                }
                if(!canBreak){
                    dfs(curr + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bf.readLine());
        eggs = new Egg[size];
        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        max = 0;

        dfs(0);

        System.out.println(max);
    }
}