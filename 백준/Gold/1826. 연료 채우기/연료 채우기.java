import java.util.*;
import java.io.*;

// 주유소 n개
public class Main {

    public static class Gas{
        int pos, val;
        public Gas(int p, int v){
            this.pos = p;
            this.val = v;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        PriorityQueue<Gas> pqTotal = new PriorityQueue<>(new Comparator<Gas>(){
            @Override
            public int compare(Gas o1, Gas o2){
                return o1.pos - o2.pos;
            }
        });

        for(int i = 0; i < size; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            pqTotal.add(new Gas(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int destDistance = Integer.parseInt(st.nextToken());
        int currGas = Integer.parseInt(st.nextToken());

        PriorityQueue<Gas> pqCurr = new PriorityQueue<>(new Comparator<Gas>(){
            @Override
            public int compare(Gas o1, Gas o2){
                return o2.val - o1.val;
            }
        });

        int cnt = 0;

        // 현재 거리 내에서 갈 수 있는 주유소 모두 pqCurr에 add
        // pqCurr에서 하나 빼서 currGas에 더하고 pqTotal에서 갈 수 있는거 또 add
        while(currGas < destDistance){
            while(!pqTotal.isEmpty() && pqTotal.peek().pos <= currGas){
                pqCurr.add(pqTotal.poll());
            }
            if(!pqCurr.isEmpty()){
                Gas gas = pqCurr.poll();
                currGas += gas.val;       // 가장 큰 주유소 더함
                cnt++;
            }
            else{       // 비어있으면 갈 수 없는 것
                cnt = -1;
                break;
            }
        }

        System.out.println(cnt);
    }
}