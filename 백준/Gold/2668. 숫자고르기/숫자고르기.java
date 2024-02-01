
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//public class Boj2668 {
public class Main {
    public static List<Integer> search(List<Integer> ans, int[] arr, boolean[] check, int curr, int target){

        if(!ans.contains(curr)) ans.add(curr);

        if(curr == target) return ans;

        while(true){
            if(!check[arr[curr]]){
                check[arr[curr]] = true;
                List<Integer> returnAns = search(ans, arr, check, arr[curr], target);
                check[arr[curr]] = false;

                return returnAns;
            }
            else{
                return null;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size + 1];
        for(int i = 1; i <= size; i++){
            arr[i] = scanner.nextInt();
        }

        boolean[] check = new boolean[size + 1];    // 한번의 탐색에서 무한루프 방지. 2 -> 1 1 -> 3 3 -> 1 1 -> 3(방지)

        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= size; i++){
            if(!check[i]){
                List<Integer> curr = new ArrayList<>();
                curr.add(i);

                List<Integer> ansList = search(curr, arr,  check, arr[i], i);

                if(ansList != null) {
                    for(Integer ansNum : ansList){
                        check[ansNum] = true;
                        ans.add(ansNum);
                    }
                }
            }
        }

        Collections.sort(ans);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ans.size());
        for(Integer num : ans){
            stringBuilder.append("\n").append(num);
        }

        System.out.println(stringBuilder.toString());
    }
}