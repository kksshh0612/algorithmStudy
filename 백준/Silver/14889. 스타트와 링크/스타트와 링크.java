import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 두 팀으로 나누기 -> 조합 -> 완전탐색  두 팀으로 나누는 거니까, 총 인원수/절반 을 뽑는 경우의 수를 구하면 됨.  ex) 4명일 때, 4C2 를 구하면 됨
// 그런데, 한 팀을 고르면 다른 팀은 당연히 정해지는 것 
// 완전탐색으로 두 팀으로 나눈 후에 능력치 더하기 능력치 더할 때에는 2중for문으로 해당 팀 사람 능력치 더하기
//public class Boj14889 {
public class Main {
    
    public static int min;
    
    public static void DFS(int people, int[][] arr, int[] currTeam, int idx, int cnt){
        if(cnt == people / 2){
            int sum1 = 0, sum2 = 0;
            List<Integer> team1 = new ArrayList<>();
            List<Integer> team2 = new ArrayList<>();

            // 팀1 세팅
            for(int i = 0; i < currTeam.length; i++){
                team1.add(currTeam[i]);
            }

            // 팀2 세팅
            for(int i = 0; i < people; i++){
                if(!team1.contains(i)){
                    team2.add(i);
                }
            }

            // 각 팀 점수 더함
            for(int i = 0; i < team1.size(); i++){
                int person1 = team1.get(i);
                int person2 = team2.get(i);
                for(int j = 0; j < team1.size(); j++){
                    sum1 += arr[person1][team1.get(j)];
                    sum2 += arr[person2][team2.get(j)];
                }
            }

            if(Math.abs(sum1 - sum2) < min){
                min = Math.abs(sum1 - sum2);
            }
        }
        else{
            for(int i = idx; i < people; i++){
                //한 팀을 구하면 다른 팀은 자동으로 정해짐. 첫번째가 0인 이후로는 구할 필요 없음.
                // 0 1 2 3 4 5 일때, 012를 하면 345 자동으로 팀 됨. 045를 하면 123 자동 팀 됨. 따라서, 123 할 필요 없음.
                if(currTeam[0] == 0){
                    currTeam[cnt] = i;
                    DFS(people, arr, currTeam, i + 1, cnt + 1);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[people][people];
        for(int i = 0; i < people; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < people; j++){
                arr[i][j] =Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        min = Integer.MAX_VALUE;
        boolean[] check = new boolean[people];
        int[] currTeam = new int[people / 2];

        DFS(people, arr, currTeam, 0, 0);

        System.out.println(min);
    }
}