import java.util.*;
import java.io.*;

// 중복 제거하고 정렬해서 이분탐색
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bf.readLine());
        int[] arr = new int[size];
        Set<Integer> set = new HashSet<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < size; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            set.add(num);
        }

        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);

        StringBuilder ans = new StringBuilder();

        // 이분탐색 몇번째 인덱스인지 찾기
        for(int i = 0; i < size; i++){
            int left = 0, right = list.size() - 1;

            while(left <= right){
                int mid = (left + right) / 2;

                if(list.get(mid) < arr[i]){
                    left = mid + 1;
                }
                else if(list.get(mid) > arr[i]){
                    right = mid - 1;
                }
                else{
                    ans.append(mid).append(" ");
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}