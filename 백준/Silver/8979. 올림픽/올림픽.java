import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Medal{
        int gold, silver, bronze;

        public Medal(int g, int s, int b){
            this.gold = g;
            this.silver = s;
            this.bronze = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int num = Integer.parseInt(stringTokenizer.nextToken());
        int goal = Integer.parseInt(stringTokenizer.nextToken());

        List<Medal> list = new ArrayList<>();
        Medal goalMedal = null;

        for(int i = 0; i < num; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int country = Integer.parseInt(stringTokenizer.nextToken());
            int gold = Integer.parseInt(stringTokenizer.nextToken());
            int silver = Integer.parseInt(stringTokenizer.nextToken());
            int bronze = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new Medal(gold, silver, bronze));

            if(country == goal) goalMedal = list.get(i);
        }

        Collections.sort(list, new Comparator<Medal>() {
            @Override
            public int compare(Medal o1, Medal o2) {
                if(o1.gold != o2.gold){
                    if(o1.gold < o2.gold) return 1;
                    else return -1;
                }
                if(o1.silver != o2.silver){
                    if(o1.silver < o2.silver) return 1;
                    else return -1;
                }

                if(o1.bronze < o2.bronze) return 1;
                else if(o1.bronze == o2.bronze) return 0;
                else return -1;
            }
        });

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).gold == goalMedal.gold && list.get(i).silver == goalMedal.silver
                    && list.get(i).bronze == goalMedal.bronze){
                System.out.println(i + 1);
                break;
            }
        }
    }
}