import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static int minDistance;

    // 현재 선택된 치킨집들과 집들의 거리 최솟값 구함
    public static void calcDistance(List<int[]> chickenPos, List<int[]> home){
        int distanceSum = 0;
        for(int[] currHome : home){
            int minHomeToChickenDistance = Integer.MAX_VALUE;
            for(int[] currChickenPos : chickenPos){
                int currHomeToChickenDistance = Math.abs(currHome[0] - currChickenPos[0]) + Math.abs(currHome[1] - currChickenPos[1]);
                minHomeToChickenDistance = Math.min(minHomeToChickenDistance, currHomeToChickenDistance);
            }

            distanceSum += minHomeToChickenDistance;
        }

        minDistance = Math.min(distanceSum, minDistance);
    }

    // 조합 
    public static void DFS(List<int[]> chicken, boolean[] check, int currIdx, int size, int currSize, List<int[]> home){
        if(currSize == size){
            List<int[]> currChicken = new ArrayList<>();
            for(int i = 0; i < check.length; i++){
                if(check[i]){
                    currChicken.add(chicken.get(i));
                }
            }
      
            calcDistance(currChicken, home);
        }
        else{
            for(int i = currIdx; i < check.length; i++){
                check[i] = true;
                DFS(chicken, check, i + 1, size, currSize + 1, home);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int size = Integer.parseInt(stringTokenizer.nextToken());
        int chickenMax = Integer.parseInt(stringTokenizer.nextToken());

        List<int[]> chicken = new ArrayList<>();        // 치킨집 좌표를 담는 배열
        List<int[]> home = new ArrayList<>();           // 집 위치를 좌표로 담는 배열

        int[][] arr = new int[size][size];
        for(int i = 0; i < size; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 0; j < size; j++){
                arr[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if(arr[i][j] == 2){
                    int[] pos = new int[2];
                    pos[0] = j;     // x좌표
                    pos[1] = i;     // y좌표
                    chicken.add(pos);
                }
                if(arr[i][j] == 1){
                    int[] pos = new int[2];
                    pos[0] = j;     // x좌표
                    pos[1] = i;     // y좌표
                    home.add(pos);
                }
            }
        }
        boolean[] check = new boolean[chicken.size()];
        minDistance = Integer.MAX_VALUE;

        DFS(chicken, check, 0, chickenMax, 0, home);

        System.out.println(minDistance);
    }
}