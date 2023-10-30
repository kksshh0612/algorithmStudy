import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 자기 앞에 애들이 다 작으면 그 자리에 섬
// 자기 앞에 자기보다 큰 친구 있으면 그 맨 앞에 섬. 그 뒤 애들은 한칸씩 물러남
// 학생들이 뒤로 물러난 총 걸음 수
// 뒤에서 앞으로 올 때, 몇번째에서 몇번째로 왔는지. ex) 3번째 -> 0번째 --> 뒤로 총 세걸음
public class Main {

    public static int countBackWalk(List<Integer> heights){
        int cnt = 0;
        for(int i = 1; i < heights.size(); i++){        //두 번째 학생부터
            for(int j = 0; j < i; j++){
                if(heights.get(i) < heights.get(j)){
                    cnt += i - j;
                    Integer currHeight = heights.get(i);
                    heights.remove(i);
                    heights.add(j, currHeight);
                    break;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < tCase; i++){
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            Integer caseToken = Integer.parseInt(stringTokenizer.nextToken());
            List<Integer> height = new ArrayList<>();
            for(int j = 0; j < 20; j++){
                height.add(Integer.parseInt(stringTokenizer.nextToken()));
            }
            map.put(caseToken, height);
        }

        for(Integer key : map.keySet()){
            List<Integer> currHeights = map.get(key);
            int cnt = countBackWalk(currHeights);

            System.out.println(key + " " + cnt);
        }
    }
}
