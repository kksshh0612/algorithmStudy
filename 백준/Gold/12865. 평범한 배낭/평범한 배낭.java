import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Thing{
        int weight;
        int value;

        public Thing(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int thingNum = Integer.parseInt(stringTokenizer.nextToken());
        int weight = Integer.parseInt(stringTokenizer.nextToken());

        List<Thing> list = new ArrayList<>();
        for(int i = 0; i < thingNum; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new Thing(w, v));
        }

        Collections.sort(list, new Comparator<Thing>() {
            @Override
            public int compare(Thing o1, Thing o2) {
                if(o1.weight < o2.weight) return -1;
                else if(o1.weight == o2.weight) return 0;
                else return 1;
            }
        });

        int[][] dp = new int[thingNum][weight + 1];
        for(int i = list.get(0).weight; i <= weight; i++){
            dp[0][i] = list.get(0).value;
        }

        for(int i = 1; i < thingNum; i++){
            Thing curr = list.get(i);
            for(int j = 1; j <= weight; j++){
                if(j < curr.weight){
                    dp[i][j] = dp[i - 1][j];
                }
                else{
                    dp[i][j] = Math.max(dp[i - 1][j - curr.weight] + curr.value, dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[thingNum - 1][weight]);
    }
}