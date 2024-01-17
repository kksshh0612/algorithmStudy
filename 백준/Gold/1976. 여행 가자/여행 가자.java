import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 여행 경로 가능한지 판별. 여러번 거쳐도 됨.
// 그래프 탐색 -> 여행 경로가 연결 그래프에 모두 포함됐는지
public class Main {

    public static void search(int[][] arr, boolean[] check, Set<Integer> travelCity,
                              int start){

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()){
            int curr = queue.poll();
            check[curr] = true;

            if(travelCity.contains(curr)) {
                travelCity.remove(curr);
            }

            for(int i = 0; i < arr[curr].length; i++){
                if(arr[curr][i] == 1 && !check[i]){
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int city = Integer.parseInt(bufferedReader.readLine());
        int[][] arr = new int[size][size];
        for(int i = 0; i < size; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(i == j) arr[i][j] = 1;
            }
        }
        int[] travel = new int[city];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < city; i++){
            travel[i] = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        }

        boolean[] check = new boolean[size];

        boolean ans = false;
        for(int i = 0; i < size; i++){

            if(ans) break;

            for(int j = 0; j < size; j++){
                if(arr[i][j] == 1 && !check[j]){
                    Set<Integer> set = new HashSet<>();
                    for(int k = 0; k < travel.length; k++){
                        set.add(travel[k]);
                    }

                    search(arr, check, set, i);

                    if(set.size() == 0) {
                        ans = true;
                        break;
                    }
                }
            }
        }

        if(ans && city != 0) System.out.println("YES");
        else System.out.println("NO");
    }
}