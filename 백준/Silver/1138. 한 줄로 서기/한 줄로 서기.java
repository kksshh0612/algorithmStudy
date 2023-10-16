import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 두번째 줄 입력은 키가 1인사람부터 자기 왼쪽에 큰 사람 몇명 있었는지
// 키가 1인 사람은 해당 숫자가 본인의 인덱스임
// 키가 작은 사람부터 해당 번째 인덱스에 채우기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int people = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[people];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i = 0; i < people; i++){
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        List<Integer> ans = new ArrayList<>();

        for(int i = people - 1; i >= 0; i--){
            ans.add(arr[i], i + 1);
        }

        for(Integer height : ans){
            System.out.print(height + " ");
        }
    }
}